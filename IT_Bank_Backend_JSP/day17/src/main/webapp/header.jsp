<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.*,board2.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="memberDAO" value="${MemberDAO.getInstance() }"/>  
<c:set var="board2DAO" value="${Board2DAO.getInstance() }"/> 
<c:set var="fileUtil"  value="${FileUtil.getInstance() }"/>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setCharacterEncoding("UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day17 - board</title>
<style>
	.frame{
		width: 900px;
	}
	.sb{
		display: flex;
		justify-content: space-between;
	}
	header{
		width:900px;
		margin:0 auto;
		display: flex;
		justify-content: center;
	}
	td,th{
		padding:10px;
	}
	.board > thead{
		background-color: black;
		color: white;
	}
	.board > tbody > tr{
	
		border-bottom: 1px solid lightgray;
		
	}
	.board > tbody > tr:hover{
		background-color: lightpink;
		transition-duration: 1s; 
	}
	.board  > thead > tr > th:nth-child(1) {width:10%;}
	.board  > thead > tr > th:nth-child(2) {width:50%;}
	.board  > thead > tr > th:nth-child(3) {width:10%;}
	.board  > thead > tr > th:nth-child(4) {width:10%;}
	.board  > thead > tr > th:nth-child(5) {width:20%;}

	.board  > tbody > tr > td:nth-child(2){text-align: left;}
	
	a{
		text-decoration: none;
		color: inherit;
	}
	a:hover{
		text-decoration: underline;
	}
	.board a{
		display: inline-block;
		
	}
	.board a:hover{
		text-decoration: none;
	}
	
</style>
</head>
<body>
	<header>
		<h1><a href=${cpath }>형주의 게시판</a></h1>
		
	</header>
	
	
</body>
</html>