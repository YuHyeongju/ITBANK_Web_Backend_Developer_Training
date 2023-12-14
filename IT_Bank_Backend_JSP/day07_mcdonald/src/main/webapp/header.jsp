<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 모든페이지에서 자바코드를 자유롭게 사용하게 할 것이다. --%>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<%-- <%=request.getContextPath()%> --%>
<jsp:useBean id="dao" class="mcdonald.McdonaldDAO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마그도날도</title>
<style>
	a{
		text-decoration: none;
		color: inherit;
	}
	a:hover {
	text-decoration: none;
	}
	.frame{
		
	}
	header{
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	nav > ul{
	
		display: flex;
		width: 300px;
		list-style: none;
		padding: 0;
	
	}
	nav > ul > li{
		flex: 1;
	}
	div.box{ 
		display: flex;
		flex-flow: wrap;
		margin: auto;
	}
	div.item{
	
		box-sizing: border-box;
		width: 200px;
		margin: 10px;
		padding: 10px;
		text-align: center;
	}
	div.detail{
		display: flex;
		flex-flow: column;
		justify-content: center;
		align-items: center;
		text-align: center;
	}
	div.sb{
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.add{
		display: flex;
		flex-flow: column;
		justify-content: center;
		align-items: center;
	
	}
	.frame > form > p > textarea{
		width: 300px;
		height: 120px;
	}
</style>
</head>
<body>

<header class="frame">
	<h1><a href="${cpath }">마그도나르도</a></h1>
	<nav>
		<ul>
			<li><a href="${cpath }/list.jsp">전체</a></li>
			<li><a href="${cpath }/list.jsp?category=버거">버거</a></li>
			<li><a href="${cpath }/list.jsp?category=음료">음료</a></li>
			<%-- 이렇게 처리하지 않으면 나중에 배포했을때 서버에서 링크가 깨짐 --%>
		</ul>
	</nav>
</header>