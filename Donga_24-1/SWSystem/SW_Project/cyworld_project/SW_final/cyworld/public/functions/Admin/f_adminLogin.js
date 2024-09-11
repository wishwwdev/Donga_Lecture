async function loginHandler(event) {
    event.preventDefault(); // 폼 제출을 막음

    const id = document.getElementById('id').value;
    const password = document.getElementById('password').value;

    const response = await fetch('/admin/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id, password })
    });

    const result = await response.json();

    // alert를 하기위해서 router에서 페이지 변경하지 않음
    alert(result.message);
    if (result.success) window.location.href = '/admin/home';
    else window.location.href = '/admin/login';
}
  

// DOM 요소가 로드되었을 때 이벤트 리스너를 추가합니다.
document.addEventListener('DOMContentLoaded', () => {
    const loginButton = document.getElementById('login-button');

    if (loginButton) loginButton.addEventListener('click', loginHandler);
});