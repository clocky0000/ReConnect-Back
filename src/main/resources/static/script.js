let loggedInUserId = null;  // 로그인한 사용자 ID를 저장

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

    // 2. 보고서 불러오기
    const reportRes = await fetch(`/api/report/get?userId=${loggedInUserId}&date=${date}`);
    if (reportRes.ok) {
      const report = await reportRes.json();
      document.getElementById('reportResult').innerText = JSON.stringify(report, null, 2);
    } else {
      document.getElementById('reportResult').innerText = '❌ 보고서를 찾을 수 없습니다.';
    }

  } catch (error) {
    console.error('불러오기 오류:', error);
    document.getElementById('diaryResult').innerText = '서버 오류';
    document.getElementById('reportResult').innerText = '서버 오류';
  }
}
