<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
	<h3>글 작성</h3>
	
	<article class="write">
	
		<form method ="POST">
			
			<table>
				<tr>
					<td>제목</td>
					<td><input name="title" required></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input name="writer" required value="${row.title }"></td>
				
				</tr>
				<tr>
					<td colspan="2"><textarea name="contents">${row.contents }</textarea></td>
				</tr>
			</table>
			
			<br>
			
			<button>작성</button>
		</form>
		
	</article>
	
	
</body>
</html>