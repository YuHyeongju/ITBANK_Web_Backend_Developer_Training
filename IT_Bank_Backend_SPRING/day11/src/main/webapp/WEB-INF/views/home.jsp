<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>day11</h3>
<hr>
<h3>오늘은 <fmt:formatDate value="${today }" pattern="yyyy년 MM월 dd일"/>입니다.</h3>

<ul>
	<li style="list-style: none;">
		<a href="${cpath }/product/function" style="text-decoration: none; color:red; font-weight: bold;">CRUD POS</a>
	</li>
</ul>

</body>
</html>