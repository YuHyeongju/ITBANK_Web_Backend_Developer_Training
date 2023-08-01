<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%--스크립트 릿 --%>
    
<%

request.setAttribute("name", "이순신");
request.setAttribute("address", "서울시 강남구");

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫 번째 jsp</title>
</head>
<body>
	<% 
	RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
	dispatch.forward(request,response);
	//다른페이지로 정보를 넘길때는 dispatch를 사용해야한다.
	%>
</html>