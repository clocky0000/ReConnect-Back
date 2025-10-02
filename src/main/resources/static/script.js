let loggedInUserId = null;  // 로그인한 사용자 ID를 저장

// 회원가입
async function signup() {
  const userId = document.getElementById('signupUserId').value.trim();
  const password = document.getElementById('signupPassword').value;
  const passwordConfirm = document.getElementById('signupPasswordConfirm').value;
  const name = document.getElementById('signupName').value.trim();
  const birthDate = document.getElementById('signupBirthDate').value;
  const job = document.getElementById('signupJob').value.trim();
  const isSubscribed = document.getElementById('signupIsSubscribed').checked;

  if (!userId || !password || !passwordConfirm || !name || !birthDate || !job) {
    document.getElementById('signupStatus').innerText = '❗ 모든 필드를 입력해주세요.';
    return;
  }

  if (password !== passwordConfirm) {
    document.getElementById('signupStatus').innerText = '❌ 비밀번호가 일치하지 않습니다.';
    return;
  }

  const body = {
    userId,
    password,
    passwordConfirm,
    name,
    birthDate,       // "yyyy-MM-dd" 형식
    job,
    isSubscribed
  };

  try {
    const response = await fetch('/api/user/save', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(body)
    });

    if (response.ok) {
      document.getElementById('signupStatus').innerText = '✅ 회원가입 성공! 로그인 해주세요.';
      // 입력값 초기화
      ['signupUserId', 'signupPassword', 'signupPasswordConfirm', 'signupName', 'signupBirthDate', 'signupJob'].forEach(id => {
        document.getElementById(id).value = '';
      });
      document.getElementById('signupIsSubscribed').checked = false;
    } else {
      const errorMsg = await response.text();
      document.getElementById('signupStatus').innerText = '❌ 회원가입 실패: ' + errorMsg;
    }
  } catch (error) {
    console.error('회원가입 오류:', error);
    document.getElementById('signupStatus').innerText = '서버 오류로 회원가입에 실패했습니다.';
  }
}

// 🔐 로그인 함수
async function login() {
  const userId = document.getElementById('loginUserId').value;
  const password = document.getElementById('loginPassword').value;

  try {
    const response = await fetch('/api/user/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      credentials: 'include', // 세션 쿠키 유지
      body: JSON.stringify({ userId, password })
    });

    const coupleCodeEl = document.getElementById('coupleCodeResult');
    if (response.ok) {
      const data = await response.json();
      loggedInUserId = data.userId;
      document.getElementById('loginStatus').innerText = `✅ ${loggedInUserId}님, 로그인되었습니다.`;

      if (data.coupleCode) {
        document.getElementById('coupleCodeResult').innerText =
            `이미 발급된 연인 코드가 있습니다.\n`
            + `💌 연인 코드: ${data.coupleCode}`;
        coupleCodeEl.dataset.coupleCode = data.coupleCode; // dataset에 저장
      } else {
        document.getElementById('coupleCodeResult').innerText = '연인 코드가 없습니다.';
        coupleCodeEl.dataset.coupleCode = null;
      }
    } else {
      document.getElementById('loginStatus').innerText = '❌ 로그인 실패: 아이디 또는 비밀번호를 확인해주세요.';
    }
  } catch (error) {
    console.error('로그인 오류:', error);
    document.getElementById('loginStatus').innerText = '서버 오류로 로그인에 실패했습니다.';
  }
}


// 📔 일기 저장 함수
async function submitDiary() {
  if (!loggedInUserId) {
    alert('로그인 후 일기를 작성할 수 있습니다.');
    return;
  }

  // questionNumber 선택
  const questionNumber = parseInt(document.getElementById('questionNumber').value);
  const content = document.getElementById('diaryContent').value;

  if (!content) {
    alert('내용을 입력해주세요.');
    return;
  }

  // coupleCode는 로그인 시 이미 받아온 데이터를 사용
  const coupleCode = document.getElementById('coupleCodeResult').dataset.coupleCode || null;

  const body = {
    content,
    questionNumber
  };

  try {
    const response = await fetch('/api/diary/submit', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      credentials: 'include',
      body: JSON.stringify(body)
    });

    if (response.ok) {
      alert(`${questionNumber}번 일기가 성공적으로 저장되었습니다.`);
      // 입력값 초기화
      document.getElementById('diaryContent').value = '';
    } else {
      const error = await response.text();
      alert(`저장 실패: ${error}`);
    }
  } catch (error) {
    console.error('저장 오류:', error);
    alert('서버 오류로 저장에 실패했습니다.');
  }
}

// 📄 내 일기 + 보고서 조회
async function loadDiaryAndReport(questionNumber) {
  if (!loggedInUserId) {
    alert('로그인 후 이용해주세요.');
    return;
  }

  if (!questionNumber || isNaN(questionNumber)) {
    alert('번호를 선택해주세요.');
    return;
  }

  const coupleCode = document.getElementById('coupleCodeResult').dataset.coupleCode;
  if (!coupleCode) {
    alert('연인 코드가 존재하지 않습니다.');
    return;
  }

  // 내 일기 영역 초기화
  document.getElementById('diaryResult').innerText = '불러오는 중...';

  try {
    // 1. 내 일기 불러오기
    const diaryRes = await fetch(`/api/diary/${loggedInUserId}/${coupleCode}/${questionNumber}`, {
      credentials: 'include'
    });

    if (diaryRes.ok) {
      const diary = await diaryRes.json();
      document.getElementById('diaryResult').innerText =
          `제목: 일기 ${questionNumber}번\n\n내용:\n${diary.content}`;
    } else {
      document.getElementById('diaryResult').innerText = '❌ 일기를 찾을 수 없습니다.';
    }
  } catch (error) {
    console.error('내 일기 불러오기 오류:', error);
    document.getElementById('diaryResult').innerText = '서버 오류';
  }
}

// 💞 파트너 일기 조회
async function loadPartnerDiary(questionNumber) {
  if (!loggedInUserId) {
    alert('로그인 후 이용해주세요.');
    return;
  }

  const coupleCode = document.getElementById('coupleCodeResult').dataset.coupleCode;
  if (!coupleCode) {
    alert('연인 코드가 존재하지 않습니다.');
    return;
  }

  try {
    const userRes = await fetch(`/api/user/${loggedInUserId}`, { credentials: 'include' });
    if (!userRes.ok) {
      alert('사용자 정보를 불러올 수 없습니다.');
      return;
    }
    const userData = await userRes.json();
    const partnerId = userData.partnerId;
    if (!partnerId) {
      alert('연인을 먼저 지정해주세요.');
      return;
    }

    const partnerDiaryRes = await fetch(`/api/diary/partner/${questionNumber}`, { credentials: 'include' });
    if (partnerDiaryRes.ok) {
      const diary = await partnerDiaryRes.json();
      document.getElementById('partnerDiaryResult').innerText =
          `💞 파트너 일기 ${questionNumber}번\n\n내용:\n${diary.content}`;
    } else {
      const errorText = await partnerDiaryRes.text();
      document.getElementById('partnerDiaryResult').innerText = `❌ 일기를 찾을 수 없습니다.`;
    }

  } catch (error) {
    console.error('파트너 일기 불러오기 오류:', error);
    document.getElementById('partnerDiaryResult').innerText = '서버 오류';
  }
}

// reasons 조회
async function loadReportReasons() {
  if (!loggedInUserId) {
    alert('로그인 후 이용해주세요.');
    return;
  }

  const questionNumber = parseInt(document.getElementById('questionNumber').value);
  if (!questionNumber) {
    alert('번호를 선택해주세요.');
    return;
  }

  try {
    const res = await fetch(`/api/report/reasons/${loggedInUserId}/${questionNumber}`, {
      credentials: 'include',
    });

    if (res.ok) {
      const data = await res.json();
      document.getElementById('reasonsResult').innerText = JSON.stringify(data, null, 2);
    } else {
      document.getElementById('reasonsResult').innerText = '❌ 데이터가 없습니다.';
    }
  } catch (error) {
    console.error(error);
    document.getElementById('reasonsResult').innerText = '서버 오류 발생';
  }
}

// metadata 조회
async function loadReportMetadata() {
  if (!loggedInUserId) {
    alert('로그인 후 이용해주세요.');
    return;
  }

  const questionNumber = parseInt(document.getElementById('questionNumber').value);
  if (!questionNumber) {
    alert('번호를 선택해주세요.');
    return;
  }

  try {
    const res = await fetch(`/api/report/metadata/${loggedInUserId}/${questionNumber}`, {
      credentials: 'include',
    });

    if (res.ok) {
      const data = await res.json();
      document.getElementById('metadataResult').innerText = JSON.stringify(data, null, 2);
    } else {
      document.getElementById('metadataResult').innerText = '❌ 데이터가 없습니다.';
    }
  } catch (error) {
    console.error(error);
    document.getElementById('metadataResult').innerText = '서버 오류 발생';
  }
}

// scores 조회
async function loadReportScores() {
  if (!loggedInUserId) {
    alert('로그인 후 이용해주세요.');
    return;
  }

  const questionNumber = parseInt(document.getElementById('questionNumber').value);
  if (!questionNumber) {
    alert('번호를 선택해주세요.');
    return;
  }

  try {
    const res = await fetch(`/api/report/scores/${loggedInUserId}/${questionNumber}`, {
      credentials: 'include',
    });

    if (res.ok) {
      const data = await res.json();
      document.getElementById('scoresResult').innerText = JSON.stringify(data, null, 2);
    } else {
      document.getElementById('scoresResult').innerText = '❌ 데이터가 없습니다.';
    }
  } catch (error) {
    console.error(error);
    document.getElementById('scoresResult').innerText = '서버 오류 발생';
  }
}

// 연인 코드 발급
document.getElementById('generateCoupleCodeBtn').addEventListener('click', async () => {
  if (!loggedInUserId) {
    alert('로그인 후 이용해주세요.');
    return;
  }

  try {
    const response = await fetch(`/api/user/${loggedInUserId}/coupleCode`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      credentials: 'include'
    });

    if (response.ok) {
      const data = await response.json();
      document.getElementById('coupleCodeResult').innerText =
          `💌 새 연인 코드: ${data.coupleCode}`;
      alert('✅ 연인 코드가 생성되었습니다.');
    } else {
      const error = await response.text();
      document.getElementById('coupleCodeResult').innerText = '❌ 코드 생성 실패: ' + error;
    }
  } catch (error) {
    console.error('연인 코드 발급 오류:', error);
    document.getElementById('coupleCodeResult').innerText = '서버 오류로 코드 발급 실패';
  }
});

// 연인 코드로 연결
async function connectWithCoupleCode() {
  if (!loggedInUserId) {
    alert('로그인 후 이용해주세요.');
    return;
  }

  const coupleCode = document.getElementById('inputCoupleCode').value.trim();
  if (!coupleCode) {
    alert('연인 코드를 입력해주세요.');
    return;
  }

  try {
    const response = await fetch(`/api/user/${loggedInUserId}/connect?coupleCode=${coupleCode}`, {
      method: 'POST',
      credentials: 'include'
    });

    if (response.ok) {
      const data = await response.json();
      document.getElementById('connectStatus').innerText =
          `💞 ${data.partnerId}님과 연결되었습니다!`;
      alert('✅ 연인 연결 성공!');
    } else {
      const errorMsg = await response.text();
      document.getElementById('connectStatus').innerText = '❌ 연결 실패: ' + errorMsg;
    }
  } catch (error) {
    console.error('연인 연결 오류:', error);
    document.getElementById('connectStatus').innerText = '서버 오류로 연결 실패';
  }
}

async function saveSurvey(){
  const body = {
    totalAnxiety: parseInt(document.getElementById('svTA').value) || null,
    totalAvoidance: parseInt(document.getElementById('svTV').value) || null
  };
  for (let i = 1; i <= 36; i++) {
      const el = document.getElementById(`svQ${i}`);
      const v  = el ? parseInt(el.value, 10) : NaN;
      body[`q${i}`] = Number.isFinite(v) ? v : null;
    }
  const res = await fetch('/api/survey/save',{
    method:'POST',
    headers:{'Content-Type':'application/json'},
    body: JSON.stringify(body)
  });
  document.getElementById('svOut').innerText = res.ok ? '✅ 저장됨' : '❌ 저장 실패';
}

function renderSurveyInputs() {
  const wrap = document.getElementById('surveyInputs');
  wrap.innerHTML = '';
  for (let i = 1; i <= 36; i++) {
    const row = document.createElement('label');
    row.style.display = 'inline-block';
    row.style.margin = '4px 8px';
    row.innerHTML = `Q${i}: <input type="number" id="svQ${i}" min="1" max="5">`;
    wrap.appendChild(row);
  }
}
document.addEventListener('DOMContentLoaded', renderSurveyInputs);

async function loadSurvey(){
  const res = await fetch('/api/survey/me', { credentials: 'include' });
  const out = document.getElementById('svOut');
  if(res.ok){
    out.innerText = JSON.stringify(await res.json(), null, 2);
  }else{
    out.innerText = `❌ 없음/권한없음 (${res.status})`;
  }
}

// ====================== 아이템 리포트 조회 ======================
async function loadItemReport() {
  if (!loggedInUserId) {
    alert('로그인 후 조회 가능합니다.');
    return;
  }

  const itemId = parseInt(document.getElementById('itemReportNumber').value);
  const coupleCode = document.getElementById('coupleCodeResult').dataset.coupleCode;

  if (!itemId || !coupleCode) {
    alert('아이템 번호와 연인 코드가 필요합니다.');
    return;
  }

  try {
    const res = await fetch(`/api/itemReport/${coupleCode}/${itemId}`, {
      credentials: 'include'
    });
    const out = document.getElementById('itemReportResult');

    if (res.ok) {
      const data = await res.json();
      out.innerText = JSON.stringify(data, null, 2);
    } else {
      const err = await res.text();
      out.innerText = '❌ 조회 실패: ' + err;
    }
  } catch (err) {
    console.error('아이템 리포트 조회 오류:', err);
    document.getElementById('itemReportResult').innerText = '서버 오류';
  }
}

// ====================== 파이널 리포트 조회 ======================
async function loadFinalReport() {
  if (!loggedInUserId) {
    alert('로그인 후 조회 가능합니다.');
    return;
  }

  const coupleCode = document.getElementById('coupleCodeResult').dataset.coupleCode;

  if (!coupleCode) {
    alert('연인 코드가 필요합니다.');
    return;
  }

  try {
    const res = await fetch(`/api/finalReport/${coupleCode}`, {
      credentials: 'include'
    });
    const out = document.getElementById('finalReportResult');

    if (res.ok) {
      const data = await res.json();
      out.innerText = JSON.stringify(data, null, 2);
    } else {
      const err = await res.text();
      out.innerText = '❌ 조회 실패: ' + err;
    }
  } catch (err) {
    console.error('파이널 리포트 조회 오류:', err);
    document.getElementById('finalReportResult').innerText = '서버 오류';
  }
}

// ====================== 최근 보고서 / 진행상황 불러오기 ======================
async function fetchLastReportAndProgress() {
  if (!loggedInUserId) {
    alert('로그인 후 이용해주세요.');
    return;
  }

  const coupleEl = document.getElementById('coupleCodeResult');
  const coupleCode = coupleEl?.dataset?.coupleCode;
  if (!coupleCode) {
    alert('연인 코드가 없습니다. 먼저 발급/연결해주세요.');
    return;
  }

  // 1) 마지막 보고서 번호
  let lastReport = 0;
  try {
    const res = await fetch(`/api/itemReport/last-item/${coupleCode}`, { credentials: 'include' });
    if (res.ok) {
      const txt = await res.text(); // 정수 문자열
      lastReport = parseInt(txt, 10) || 0;
    } else {
      console.warn('last-item API 실패', await res.text());
    }
  } catch (e) {
    console.error('last-item 호출 오류', e);
  }
  document.getElementById('lastReportNo').textContent = lastReport;

  // 1-1) 1..N 보고서 버튼 만들기
  const list = document.getElementById('reportList');
  list.innerHTML = '';
  for (let i = 1; i <= lastReport; i++) {
    const a = document.createElement('a');
    a.className = 'btn';
    a.href = '#';
    a.textContent = `보고서 ${i}`;
    a.onclick = (ev) => { ev.preventDefault(); loadItemReportByNumber(i); };
    list.appendChild(a);
  }

  // 2) 둘 다 작성 완료한 마지막 질문 번호
  let lastCompleted = 0;
  try {
    const res2 = await fetch(`/api/diary/last-completed/${coupleCode}`, { credentials: 'include' });
    if (res2.ok) {
      const txt2 = await res2.text(); // 정수 문자열
      lastCompleted = parseInt(txt2, 10) || 0;
    } else {
      console.warn('last-completed API 실패', await res2.text());
    }
  } catch (e) {
    console.error('last-completed 호출 오류', e);
  }
  document.getElementById('lastDoneQ').textContent = lastCompleted;

  // 2-1) 다음 질문 번호(최대 36로 캡)
  const next = Math.min(36, (lastCompleted || 0) + 1);
  document.getElementById('nextQ').textContent = next;
}

// 보고서 번호 버튼 클릭 시: 입력창에 넣고 기존 조회 함수 재사용
function loadItemReportByNumber(n) {
  const input = document.getElementById('itemReportNumber');
  if (input) input.value = n;
  loadItemReport();
}
