<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member-modify.jsp</title>
</head>
<body>
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID" required autofocus value="${dto.userid } "></p>
		<p><input type="password" name="userpw" placeholder="PW" required value="${dto.userpw }"></p>
		<p><input type="text" name="username" placeholder="Name" required value="${dto.username }"></p>
		<p><input type="text" name="gender" placeholder="남성/여성" required value="${dto.gender }"></p>
		<p><input type="email" name="email" placeholder="Email" required value="${dto.email }"></p>
		<p><input type="submit"></p>
	
	</form>
</body>
</html>