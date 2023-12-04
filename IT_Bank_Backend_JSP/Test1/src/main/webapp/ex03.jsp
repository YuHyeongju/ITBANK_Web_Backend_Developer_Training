<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
</head>
<body>
<h1>JSP 기본문법활용 + JDBC</h1>
<hr>

<%@ page import="ex03.Ex03DAO" %> <%--디렉티브 코드 지시자 --%>


<%!	

private Ex03DAO dao = new Ex03DAO();

%>	<%--선언부  디클레이션--%>

<%

String DBVersion  = dao.getDBversion();


%>
<%--스크립틀릿 --%>
<h3>DB version: <%=DBVersion %></h3> <%--표현식 익스프레션--%>
</body>
</html>