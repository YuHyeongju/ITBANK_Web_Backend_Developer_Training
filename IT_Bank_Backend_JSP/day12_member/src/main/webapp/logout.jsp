<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<section>
	<h4>logout.jsp</h4>
	<c:remove var="login" scope="session"/>
	<c:redirect url="login.jsp"/>
</section>
</body>
</html>