<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<section>
		<div style="border: 2px solid red; width:600px; padding:10px; border-radius: 20px;
		margin:auto auto;">
			<div>${dto.idx }</div>
			<div><img src="${cpath }/upload/${dto.img}" style="margin:auto auto; display: flex;
			width:400px; height:400px;"></div>
			<div style="text-align: center;">${dto.name }</div>
			<div >
				<a href="${cpath }/product/modify/${dto.idx}" ><button>수량 변경</button></a>
				<a href="${cpath }/product/delete/${dto.idx}" ><button>상품삭제</button></a>
			</div>
		</div>
		
	</section>
</body>
</html>