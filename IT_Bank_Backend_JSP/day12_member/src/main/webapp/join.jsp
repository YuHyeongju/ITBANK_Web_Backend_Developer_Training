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
<section class="join">
	<form action="join-action.jsp" method="POST">
		<h3>회원가입</h3>
		<p>
			<input type="text" name="userid" placeholder="아이디 입력" required autofocus>
		</p>
		<p>
			<input type="password" name="userpw" placeholder="비밀번호 입력" required>
		</p>
		<p>
			<input type="text" name="userName" placeholder="이름 입력" required>
		</p>
		<p>
			<label><input type="radio" name="gender" value="남성" required>남자</label>
			<label><input type="radio" name="gender" value="여성" required>여자</label>
		</p>
		<p>
			<input type="email" name="email" placeholder="이메일 입력" required>
		</p>
		<p>
			<input type="submit" value="회원가입">
			<a href="${cpath }/list.jsp" style="text-decoration: none">목록</a>
		</p>
		
	</form>
</section>	
</body>
</html>