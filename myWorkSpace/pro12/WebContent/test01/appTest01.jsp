<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
session.setAttribute("name","이순신");
application.setAttribute("address","서울시 성동구");
//session : 브라우저 하나당 한개
//application : 서버가 종료되지않으면 누구나 접근가능

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 스코프 테스트 1</title>
</head>
<body>
<h1>이름과 주소를 저장합니다.</h1>
<a href = appTest02.jsp>두번째 웹페이지로 이동</a>
</body>
</html>