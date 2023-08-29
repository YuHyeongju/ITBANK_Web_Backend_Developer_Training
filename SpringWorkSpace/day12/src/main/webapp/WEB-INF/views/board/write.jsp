<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>
	<h3>글 작성</h3>
	
	<article>
	
		<form method ="POST">
			
			<p><input name="title" placeholder="제목" required></p>
			<p><input name="writer" placeholder="작성자" required></p>
			<p><textarea name="contents" placeholder="내용"></textarea></p>
		
		</form>
		
	</article>
	
	
</body>
</html>