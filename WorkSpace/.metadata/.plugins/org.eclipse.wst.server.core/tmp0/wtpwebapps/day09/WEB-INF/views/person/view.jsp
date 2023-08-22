<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h3>person 테이블 목록</h3>
	
	<table border ="1" cellspacing="0" cellpadding="10"> 
	
		<tr>
		 <th>이름</th>
		 <th>신장</th>
		 <th>생년월일</th>
		</tr>
		
		<c:forEach var ="row" items= "${list }">
		<tr>
			<td>${row.name }</td>  <!-- ${} 태그는 private 접근가능-->
			<td>${row.height }</td> <!-- getter setter 통해서 -->
			<td>${row.birth }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>