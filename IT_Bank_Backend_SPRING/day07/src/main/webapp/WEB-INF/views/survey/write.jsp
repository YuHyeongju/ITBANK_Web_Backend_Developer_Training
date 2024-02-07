<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write.jsp</title>
</head>
<body>
<section>
	<form method="POST" enctype="multipart/form-data">
	<input type="hidden" name="writer" value="${login.userid }">
	<p><input type="text" name="title" placeholder="설문 제목 입력"></p>
	<h3>설문 내용 1</h3> 
	<p><input type="text" name="content1" placeholder="설문 내용1 입력" required></p>
	<p><input type="file" name="upload0" required></p>
	<h3>설문 내용2</h3>
	<p><input type="text" name="content2" placeholder="설문 내용2 입력" required></p>
	<p><input type="file" name="upload1" required></p>
	<p><input type="submit"></p>
	</form>
</section>

</body>
</html>