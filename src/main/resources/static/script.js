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

    if (response.ok) {
      const data = await response.json();
      loggedInUserId = data.userId;
      document.getElementById('loginStatus').innerText = `✅ ${loggedInUserId}님, 로그인되었습니다.`;
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

  const title = document.getElementById('diaryTitle').value;
  const content = document.getElementById('diaryContent').value;

  const body = {
    title,
    content,
    submitted: false
    // 날짜는 백엔드에서 LocalDate.now() 로 자동 처리
  };

  try {
    const response = await fetch('/api/diary/submit', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      credentials: 'include',
      body: JSON.stringify(body)
    });

    if (response.ok) {
      alert('일기가 성공적으로 저장되었습니다.');
    } else {
      const error = await response.text();
      alert(`저장 실패: ${error}`);
    }
  } catch (error) {
    console.error('저장 오류:', error);
    alert('서버 오류로 저장에 실패했습니다.');
  }
}

// 📆 달력 선택 시 조회
document.addEventListener('DOMContentLoaded', () => {
  const calendar = document.getElementById('calendar');
  calendar.addEventListener('change', () => {
    if (!loggedInUserId) {
      alert('로그인 후 이용해주세요.');
      return;
    }

    const selectedDate = calendar.value;
    if (selectedDate) {
      loadDiaryAndReport(selectedDate);
    }
  });
});

// 📄 일기 + 보고서 조회
async function loadDiaryAndReport(date) {
  document.getElementById('diaryResult').innerText = '불러오는 중...';
  document.getElementById('reportResult').innerText = '불러오는 중...';
  document.getElementById('reportTextResult').innerText = '불러오는 중...';

  try {
    // 1. 일기 불러오기
    const diaryRes = await fetch(`/api/diary/${loggedInUserId}/${date}`, {
      credentials: 'include'
    });

    if (diaryRes.ok) {
      const diary = await diaryRes.json();
      document.getElementById('diaryResult').innerText =
          `제목: ${diary.title}\n\n내용:\n${diary.content}`;
    } else {
      document.getElementById('diaryResult').innerText = '❌ 일기를 찾을 수 없습니다.';
    }

    // 2. 보고서 (수치 요약용)
    const reportRes = await fetch(`/api/report/get?userId=${loggedInUserId}&date=${date}`);
    if (reportRes.ok) {
      const report = await reportRes.json();
      document.getElementById('reportResult').innerText =
          `📌 ${report.reportTitle || '리포트'}\n\n\n` +
          `✨ 요약 키워드: ${report.coreKeywords?.join(', ') || '없음'}\n\n` +
          `😊 주요 감정: ${report.keyEmotions?.join(', ') || '없음'}\n\n` +
          `💡 솔루션\n` +
          `- 과거 솔루션: ${report.solution.past_solution || '없음'}\n` +
          `- 현재 솔루션: ${report.solution.current_solution || '없음'}\n\n` +
          `🧩 현재 분석\n` +
          `- 문제점: ${report.currentAnalysis.problem || '없음'}\n` +
          `- 생각 패턴: ${report.currentAnalysis.thought || '없음'}\n` +
          `- 자원: ${report.currentAnalysis.resource || '없음'}\n\n` +
          `💬 응원 메시지: ${report.feedbackAndCheer || '없음'}\n\n` +
          `🔁 반복 패턴: ${report.repetitivePattern || '없음'}\n\n` +
          `🌱 추천: ${report.recommendation || '없음'}\n\n`;

    } else {
      document.getElementById('reportResult').innerText = '❌ 보고서를 찾을 수 없습니다.';
    }

    // 3. 줄글 분석 + 감정 지표
    const textRes = await fetch(`/api/report/text/${loggedInUserId}/${date}`, {
      credentials: 'include'
    });
    if (textRes.ok) {
      const textReport = await textRes.json();
      document.getElementById('reportTextResult').innerText =
          `📘 줄글 요약:\n${textReport.reportText || '없음'}\n\n` +
          `📊 감정 지표:\n` +
          `- 스트레스: ${textReport.stress ?? 'N/A'}\n` +
          `- 에너지: ${textReport.energy ?? 'N/A'}\n` +
          `- 감정: ${textReport.emotion ?? 'N/A'}\n` +
          `- 우울감: ${textReport.depression ?? 'N/A'}\n` +
          `- 불안감: ${textReport.anxiety ?? 'N/A'}`;
    } else {
      document.getElementById('reportTextResult').innerText = '❌ 줄글 분석을 찾을 수 없습니다.';
    }

  } catch (error) {
    console.error('불러오기 오류:', error);
    document.getElementById('diaryResult').innerText = '서버 오류';
    document.getElementById('reportResult').innerText = '서버 오류';
    document.getElementById('reportTextResult').innerText = '서버 오류';
  }
}
