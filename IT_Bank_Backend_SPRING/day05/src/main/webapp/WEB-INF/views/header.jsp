<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day05-header.jsp</title>
<style>
	body{
	background-color: lightgrey;
	}
	header,section
	{
		width:900px;
		margin: auto;
		
	
	}
	a{
		text-decoration: none;
		color: inherit;
	}

</style>
</head>
<body>
	<header style="width:900px; margin:auto;">
		<h1 ><a href="${cpath }" style="color:red; text-decoration: none;">Member CRUD - day04</a></h1>
		<div id="login" style="height:60px; display:flex; justify-content: right;">
			<c:if test="${!empty login }">
				<p>	${login.username } 님 로그인 중 
					<a href="${cpath }/member/logout"><button>로그아웃</button></a>
				</p>
			
			</c:if>
		</div>
		<nav>
			<ul style="display: flex; podding:0; list-style: none; justify-content: space-around;">
			
				<li ><a href="${cpath }/member/list">회원목록</a></li> <!-- 주소도 계층형으로 구성하는게 좋다.${cpath }/list 별로다 -->
				 
				<li ><a href="${cpath }/member/login">로그인</a></li>
				<li><a href="${cpath }/board/list">게시판</a></li>
			
			</ul>
		
		</nav>
	</header>
</body>
</html>