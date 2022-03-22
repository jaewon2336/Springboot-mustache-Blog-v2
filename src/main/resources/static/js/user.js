// 1. 이벤트 리스너
$("#btn-join").click(() => {
    join();
});


$("#btn-login").click(() => {
    login();
});


// 2. 기능

// 회원가입 요청 메서드
let join = async () => {

    // (1) username, password, email, address 찾아서 자바스크립트 오브젝트로 만들기
    let joinDto = {
        username: $("#username").val(),
        password: $("#password").val(),
        email: $("#email").val(),
        address: $("#address").val()
    }

    // (2) 자바스크립트 오브젝트 -> JSON 변환 (통신의 표준이 JSON!!)
    // let userJson = JSON.stringify(userDto);

    // (3) fetch 요청
    let response = await fetch("/api/join", {
        method: 'POST',
        body: JSON.stringify(joinDto),
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    });

    let responseParse = await response.json();

    // (4) 회원가입이 잘되면 알림창을 띄우고 로그인 페이지로 이동
    if (responseParse.code == 1) {
        alert("회원가입에 성공하였습니다.");
        location.href = "/loginForm";
    } else {
        alert("회원가입에 실패하였습니다.");
    }
}

// 로그인 요청 메서드
let login = async () => {
    let loginDto = {
        username: $("#username").val(),
        password: $("#password").val()
    }

    let response = await fetch("/api/login", {
        method: 'POST',
        body: JSON.stringify(loginDto),
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    });

    let responseParse = await response.json();

    if (responseParse.code == 1) {
        alert("로그인에 성공하셨습니다.");
        location.href = "/";
    } else {
        alert("로그인에 실패하였습니다.");
    }
}