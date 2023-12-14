<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
 
<c:set var="dto" value="${dao.selectOne(param.idx) }"/>

<section class="modify">
	<h3>항목 수정</h3>
	<form action="modify-action.jsp">
		<input type="hidden" name="idx" value="${dto.idx }">
		
		<p><input type="text" name="title" placeholder="영상 제목" value="${dto.title }"></p>
		<p><input type="text" name="name" placeholder="채널 이름" value="${dto.name }"></p>
		<p><input type="text" name="thumbnail" placeholder="영상 썸네일 주소" value="${dto.thumbnail }"></p>
		<p><textarea name="tag" placeholder="동영상 주소" required>${dto.tag }</textarea></p>
		<p><input type="submit"></p>
	</form>

</section>
</body>
</html>