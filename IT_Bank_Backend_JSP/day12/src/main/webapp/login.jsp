<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<style>
	.frame{
		border:1px solid red;
		width:900px;
		margin: 0 auto;
		padding: 10px;
		
	}
	

</style>
</head>
<body>
<form action="login-action.jsp" method="post" class="frame">
	<h3>로그인</h3>
	<input type="text" name="userid" placeholder="아이디 입력">
	<input type="password" name="userpw" placeholder="비밀번호 입력">
	<p><input type="submit" value="로그인"></p> 
</form>
	
</body>
</html>