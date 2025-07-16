async function submitDiary() {
  const userId = document.getElementById('diaryUserId').value;
  const date = document.getElementById('diaryDate').value;
  const title = document.getElementById('diaryTitle').value;
  const content = document.getElementById('diaryContent').value;

  const body = {
    userId,
    date,
    title,
    content,
    submitted: false
  };

  try {
    const response = await fetch('/api/diary/submit', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
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
};

async function getReport() {
  const userId = document.getElementById('searchUserId').value;
  const date = document.getElementById('searchDate').value;

  const res = await fetch(`/api/report/get?userId=${userId}&date=${date}`);
  const json = await res.json();
  document.getElementById('reportResult').innerText = JSON.stringify(json, null, 2);
}
