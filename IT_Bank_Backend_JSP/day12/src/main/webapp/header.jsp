<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="cpath" value="${pageContext.request.contextPath }"/>

<c:set var="dao" value="${MemberDAO.getInstace() }"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
<style>
	header{
		border: 2px solid red;
		width: 400px;
		height: 400px;
		margin: auto auto;
	}
	.sb{
		justify-content: space-between;
		
	}
	.frame{
		width:900px;
		
	}
	h3{
	text-align: center;
	padding: 50px;
	}

</style>
</head>
<body>
	<header class="frame">
		<h3><a href="join.jsp">회원가입</a></h3>
		
	 	<h3><a href="login.jsp">로그인</a></h3>
	 	
	</header>	
	
	
		
	 	
</body>
</html>