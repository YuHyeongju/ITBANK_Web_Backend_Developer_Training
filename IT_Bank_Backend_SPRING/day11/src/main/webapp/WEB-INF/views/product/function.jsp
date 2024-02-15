<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>  
<%@include file="../header.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pos기 메인</title>
<style>
	.flex{
		display: flex;
		
	}
	.sb{
		justify-content: space-between;
	}
	body{
		width:100%;
		height:100%;
		padding:0;
		margin:0;
	}
	.main{
		border: 2px solid black;
		width:900px;
		height:300px;
		border-radius: 20px;
		margin: auto auto;
		margin-top:10px;
		flex-flow:wrap;
	}
	.main > div{
		margin:20px;
		width: 400px;
		height: 250px;
		border: 2px solid red;	
		background-color: red;
		border-radius: 30px;
		
		
	}
	.main > div > a {
		margin:auto auto;
		color: white;
		text-decoration: none;
		width: 300px;
		height: 300px;
		text-align: center;
		
	}
	

</style>
</head>
<body>
<div class="main flex">
	<div id="insert" class="flex"><a href="${cpath }/product/insert">상품추가</a></div>
	<div id="select" class="flex"><a href="${cpath }/product/list" >상품목록</a></div>
	
</div>
</body>
</html>