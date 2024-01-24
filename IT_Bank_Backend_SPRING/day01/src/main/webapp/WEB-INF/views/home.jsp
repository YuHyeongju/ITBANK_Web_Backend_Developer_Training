<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello world!</h1>
<hr>

<h3>접속된 DB 버전 : ${version }</h3>
<h3>오늘 날짜: ${sysdate }</h3>

<a href="member"><button>member</button></a> <!-- day01의 member로 요청이 들어감 -->



<!-- <script type="text/javascript">
	function getTime() {
		var d = new Date();	// 현재 날짜와 시간
		var hur = d.getHours();		// 시
		var min = d.getMinutes();	//분
		var sec = d.getSeconds();	//초
 
		var timeBoard = document.getElementById("WhatTimeIsItNow"); // 값이 입력될 공간
		
		var time = "현재 시간 : " + hur + "시 " + min + "분 " + sec + "초"	// 형식 지정
		
		timeBoard.innerHTML = time;	// 출력
		
		setTimeout(getTime, 1000);	//1000밀리초(1초) 마다 반복
	}
</script>

<p id="WhatTimeIsItNow"></p> -->
</body>
</html>

<!-- 
	스프링 프로젝트를 생성하면 기본적으로 home.jsp가 있는데 그상태로 프로젝트를 생성하면 
	서버타입이 출력될 떄 한글이 깨지는 문제가 생긴다.
	이때 home.jsp를 지우고 새로 만들어서 입력하여 실행하면 정상적으로 작동한다.
	서버 재시작 단축키 alt + shift + x  R
 -->