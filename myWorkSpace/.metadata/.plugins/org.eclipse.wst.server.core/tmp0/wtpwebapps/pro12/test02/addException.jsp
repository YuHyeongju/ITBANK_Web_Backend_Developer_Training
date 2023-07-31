<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage = True %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>애러 페이지</title>
</head>
<body>
		=========== toString() 내용 =============
		<h1> <%=exception.toString() %></h1>
		=========== getMessage() 내용 ===========
		<h1> <%= exception.getMessage() %></h1>
		=========== printStackTrace() 내용 ==========
		<h1> <% exception.printStackTrace(); %></h1>
		<h3>
		숫자만 입력 가능합네다. 다시 입력 하라우.
		<a href ='add.html'></a>다시하기</a>
		</h3>
		
</body>
</html>