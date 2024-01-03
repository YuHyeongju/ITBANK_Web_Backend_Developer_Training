<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*, board.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<c:set var="memberDAO" value="${MemberDAO.getInstance() }"/>
<c:set var="boardDAO" value="${BoardDAO.getInstance() }"/>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day15 - header.jsp</title>
<style>
	.flex{
		display: flex;
	}
	.sb{
		justify-content: space-between;
	}
	.nav_list{
		list-style: none;
	}
	

</style>

</head>
<body>
<header>
	<h1 style="text-align:center; "><a href = "${cpath }" style="text-decoration: none; color:inherit;">형주의 카페</a></h1>
	<div style="text-align: right; width:1400px;">
		${login.userid } ${!empty login?'로그인 중':'-'}
	</div>
	<div class="nav">
		<ul class="flex sb nav_list">
			<li><a href="${cpath }/login.jsp" style="text-decoration: none; color:inherit;">로그인</a><li>
			<li><a href="${cpath }/logout.jsp" style="text-decoration: none; color:inherit;">로그아웃</a><li>
			<li><a href="${cpath }/join.jsp" style="text-decoration: none; color:inherit;">회원가입</a><li>
			<c:if test="${!empty login }">
				<li><a href="${cpath }/member-delete.jsp" style="text-decoration: none; color:inherit;">회원탈퇴</a></li>
			</c:if>
			<li><a href="${cpath }/board.jsp" style="text-decoration: none; color:inherit;">게시판</a><li>
			
		</ul>
	</div>
</header>
	
</body>
</html>