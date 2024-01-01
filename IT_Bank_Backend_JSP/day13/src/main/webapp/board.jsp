<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
</head>
<body>
	<h4>게시판</h4>
	<table border="1" cellpadding="10" cellspacing="0" style="width:800">
	
		
		<c:set var="list" value="${boardDAO.selectList() }" />
		<c:forEach var="dto" items="${list }">
			
			<tr>
				<td>${dto.idx }</td>
				<td width="500">
					<a href="${cpath }/view.jsp?idx=${dto.idx}" style="text-decoration: none; color:inherit;">
						${dto.title }
					</a>
				 </td>
				<td>${dto.writer }</td>
				<td>${dto.writeDate }</td>
			</tr>
		</c:forEach>

	</table>
	
	<div style="display: flex; width:550px; margin:10px auto; ">
	
		<div>
		
		</div>
		<div>
			<a href="${cpath }/write.jsp"><button>작성</button></a>
		</div>
	
	</div>
</body>
</html>