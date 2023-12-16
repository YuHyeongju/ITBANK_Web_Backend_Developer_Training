<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<jsp:useBean id="dao" class="product.ProductDAO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>베스킨라빈스</title>
<style>
	.box{
		border: 2px solid red;
		display: flex;
		justify-content: center;
		align-items: center;
		flex-flow: wrap;
	
	}
	.items{
		box-sizing: border-box;
		width:200px;
		margin: 10px;
		border: 2px solid red;
		border-radius: 20px;
		padding: 10px;
		text-align: center;
		
	}
	.items > a{
		text-decoration: none;
		
	}
	


</style>
</head>
<body>
<h4>베스킨라빈스에 오신걸 환영합니다.</h4>
<hr>



</body>
</html>