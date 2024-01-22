<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
</head>
<body>	
		<h1 style="text-align: center; color:red;">게시판</h1>
		<table border="1" cellspacing="0" cellpadding="10" style="width:900px; margin:auto auto;"> 
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.idx }</td>	
					<td>${dto.title }</td>	
					<td>${dto.writer }</td>
					<td>${dto.writeDate }</td>	
					<td>${dto.viewCount }</td>	
				
				</tr>
			
			
			</c:forEach>	
		
		
		</table>
	
</body>
</html>