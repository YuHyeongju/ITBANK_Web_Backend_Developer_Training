<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex06-action.jsp</title>
</head>
<body>
<jsp:useBean id="login" class="ex06.MemberDTO" scope="session"></jsp:useBean> 
<%--scope의 기본값은 pageContext이다. --%>
<jsp:setProperty property="name" name="login"/>

<%
	// 세션에 객체를 저장하는것만으로도 이 페이지의 역할은 끝남
	// 다음 화면으로 연결시켜주기 위해서 리다이렉트를 사용함.
	// 페이지가 바뀌면서 요청도 새로 들어갔지만, 세션은 같은 세션이기 때문에 attribute를 사용할 수 있다.
	response.sendRedirect("ex06.jsp"); // 대문페이지에 보여주는것이 준비되어있음.
	
	// 주로 세션과 많이 연계하는 redirect

%>
</body>
</html>