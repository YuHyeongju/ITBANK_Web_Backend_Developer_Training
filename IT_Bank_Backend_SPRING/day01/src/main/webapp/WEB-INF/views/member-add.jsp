<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member-add.jsp</title>
</head>
<body>
	<form method="POST">
		<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
		<p><input type="password" name="userpw" placeholder="PW" required ></p>
		<p><input type="text" name="username" placeholder="Name" required ></p>
		<p><input type="text" name="gender" placeholder="남성/여성" required ></p>
		<p><input type="email" name="email" placeholder="Email" required ></p>
		<p><input type="submit"></p>
	
	</form>
</body>
</html>