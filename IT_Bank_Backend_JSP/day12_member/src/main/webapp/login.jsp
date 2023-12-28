<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<section class="loginSection">
		<form action="login-action.jsp" method="post" >
			<h3>로그인</h3>
			<div class="login">
				<input type="text" name="userid" placeholder="아이디 입력" required
					autofocus> 
				<input type="password" name="userpw"
					placeholder="비밀번호 입력" required>
			</div>
			<p>
				<input type="submit" value="로그인">
			</p>
		</form>
	</section>


</body>
</html>