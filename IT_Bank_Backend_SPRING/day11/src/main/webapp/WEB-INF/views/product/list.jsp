<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품리스트</title>
<style>
	.main{
		width:900px;
		height:800px;
		border: 2px solid red;
		display: flex;
		margin:auto auto;
		padding-top:10px;
		border-radius: 20px; 
	}
	.item{
		margin:10px;
		
		
	}
	#img{
		width:200px;
		hieght:200px;
		margin:10px;
	
	}

</style>
</head>
<body>
<section>
	<div class="main">
		<c:forEach var="dto" items="${list }">
			<div class="item">
				<div>${dto.idx }</div>
				<a href="${cpath}/product/view/${dto.idx}"><img src="${cpath }/upload/${dto.img}" id = "img"></a>
				<div style="text-align: center;">${dto.name }</div>
				<div style="text-align: center;">수량: ${dto.count }</div>
			</div>
		</c:forEach>
	
	
	</div>


</section>
</body>
</html>