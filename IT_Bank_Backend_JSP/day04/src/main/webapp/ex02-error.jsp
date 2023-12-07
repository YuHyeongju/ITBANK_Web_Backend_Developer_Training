<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-error.jsp</title>
</head>
<body>
<h1>ex02-error.jsp</h1>
<hr>

<%

	String msg = exception.getMessage();

%>
<h3><%=msg %></h3>
<h3>정수를 입력해주시기 바랍니다.</h3>
<a href="ex02-form.jsp"><button>다시</button></a> 
</body>
</html>
<%--
	포워딩 예시
	평상시에는 action페이지로 넘어가서 결과를 보여주지만
	에러가 발생하면 action은 모르겠다면서 error페이지에게 
	물어보라고 한다. 그럼 에러 페이지에게로 이동해서 문제를 
	보여준다.
--%>