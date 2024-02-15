<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수량 수정</title>
</head>
<body>
<h3>수량 수정</h3>
<form method="POST">
	<p><input type="number" name="count" value="${dto.count }"></p>
	<input type="submit" value="수정완료">
</form>
</body>
</html>