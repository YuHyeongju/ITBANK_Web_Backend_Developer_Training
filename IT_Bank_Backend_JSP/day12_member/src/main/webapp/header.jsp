<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8");%>	
<%response.setCharacterEncoding("UTF-8");%>	

<c:set var="cpath" value="${pageContext.request.contextPath }"/>

<c:set var="dao" value="${MemberDAO.getInstance() }"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
<style>
	header{
		text-align: center;
	}
	section{
		border: 2px solid red;
		height: 400px;
	 	text-align:center;
	 	margin:0 auto;
	}
	table{
		border: 1px solid black;
		border-collapse: collapse;
		margin:auto auto;
		margin-top: 100px
		 
	}
	
	td,th{
		border: 2px solid grey;
		padding:10px;
	}
	.flex{
		display: flex;
	}
	.sb{
		justify-content: space-between;	
	}
	a{
		text-decoration: none;
		color: inherit;
	}
	#loginInfo{
		height:23px;
	}
	.frame{
		width:600px;
		margin: 0 auto;
		font-size: 30px;
		
	}
	.frame > p{
		padding:20px;
	
	}
	
	
	.loginSection{
		margin: 0 auto;
	}
	.login > input{
		margin: 20px;
	}
	.buttons{
		margin:0 auto;
	}
</style>
</head>
<body>
	<header>
		<h1><a href="index.jsp">로그인 및 회원가입 예제</a></h1>
		<div id="loginInfo" class="flex">
			<c:if test="${not empty login }">
				<h4 align="right">현재 접속자:${login.userName}</h4>
			</c:if>
		</div>
	</header>		
</body>
</html>