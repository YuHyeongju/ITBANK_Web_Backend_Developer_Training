<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../header.jsp" %>  
    
	<h3>Person 테이블 목록</h3>
	
	
	<table class= "board">
		<tr> 
			<th>이름</th>
			<th>신장</th>
			<th>생년월일</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var="row" items="${list }">
		
		<tr>
			<td>${row.name }</td>
			<td>${row.height }</td>
			<td>${row.birth }</td>	
			<th>
				<a href="${cpath }/person/update/${row.name }">
				클릭
				</a>
			</th>
			<th>
			
				<a href="${cpath }/person/delete/${row.name }">
				x
				</a>
			</th>
		</tr>
		</c:forEach>
	</table>
	
	<a href= "${cpath }/person/write">
	
			<button>추가</button>
	</a>
	
</body>
</html>