<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="member.*, board.*, reply.*"%> <%-- dao dto를 가져오기위한 import --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%-- 포맷에 관련된 라이브러리 --%>
<c:set var="cpath" value="${pageContext.request.contextPath }"/> <%--cpath라는 이름으로 contextPath를 요청하면 
																이 페이지로 이동 --%>   
<c:set var="memberDAO" value="${MemberDAO.getInstance()}"/>	<%-- 어디에서나 사용 가능하게 선언 --%>
<c:set var="boardDAO" value="${BoardDAO.getInstance()}"/>	<%-- 어디에서나 사용 가능하게 선언 --%>
<c:set var="replyDAO" value="${ReplyDAO.getInstance()}"/> <%-- 어디에서나 사용 가능하게 선언 --%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setCharacterEncoding("UTF-8"); %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day14 - board</title>
</head>
<body>
	<header>
	
		<h1><a href="${cpath }">day14 - board</a></h1>
		<div style="text-align: right; padding-right:20px; height:30px;">
			${login.userid } ${!empty login ?'로그인 중':'' } <%-- 로그인 중이면 표시 --%>
		</div>
		<nav>
			<ul style="display: flex; list-style:none;  justify-content:space-around;">
				<li><a href="${cpath }/login.jsp" style="text-decoration: none; color:inherit;">로그인</a></li>
				<li><a href="${cpath }/logout.jsp" style="text-decoration: none; color:inherit;">로그아웃</a></li>
				<li><a href="${cpath }/join.jsp" style="text-decoration: none; color:inherit;">회원가입</a></li>
				<li><a href="${cpath }/board.jsp" style="text-decoration: none; color:inherit;">게시판</a></li>
			</ul>
		
		
		</nav>
	</header>
</body>
</html>