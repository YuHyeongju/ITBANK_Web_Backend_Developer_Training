<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과페이지</title>
</head>
<body>
	<h1>결과페이지</h1>
	<hr>
	
	
	<%--${param.이름}: parameter 접근 --%>
	<%--${이름}: Attribute 접근 --%>
	
	<h4>${param.name }님은 ${msg }</h4>

</body>
</html>