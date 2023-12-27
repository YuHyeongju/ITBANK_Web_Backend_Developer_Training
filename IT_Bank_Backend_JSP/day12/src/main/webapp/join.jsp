<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
</head>
<body>
	<form action="join-action.jsp" method="POST">
		<h3>회원가입</h3>
		<p>
			<input type="text" name="userid" placeholder="아이디 입력" required>
		</p>
		<p>
			<input type="password" name="userpw" placeholder="비밀번호 입력" required>
		</p>
		<p>
			<input type="text" name="name" placeholder="이름 입력" required>
		</p>
		<p>
			<label><input type="radio" name="gender" value="1">남자</label>
			<label><input type="radio" name="gender" value="0">여자</label>
		</p>
		<p>
			<input type="email" name="email" placeholder="이메일 입력" required>
		</p>

	</form>
</body>
</html>