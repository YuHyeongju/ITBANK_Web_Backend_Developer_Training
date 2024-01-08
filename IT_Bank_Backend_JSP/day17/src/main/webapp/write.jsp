<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<c:if test="${pageContext.request.method == 'GET' }">
	<c:if test="${empty login }">
		<script>
			alert('먼저 로그인후 글을 작성할 수 있습니다.')
			location.href = '${cpath}/login.jsp'
		</script>
	</c:if>
	<form method="POST" enctype="multipart/form-data">
		<h2>글 작성</h2>
		<p><input type="text" name="title" placeholder="제목"></p>
		<p><textarea  name="content" placeholder="내용"></textarea></p>
		<p><input type="file" name="uploadFile"></p>
		<p><input type="submit" value="작성완료"></p>
		
		<input type="hidden" name="writer" value="${login.userid }" >
		<input type="hidden" name="ipaddr" value="${pageContext.request.remoteAddr}">
		<!--  ip주소를 불러옴 -->
	</form>
</c:if>
<c:if test="${pageContext.request.method == 'POST' }">
	<c:set var="dto" value="${fileUtil.getDTO(pageContext.request) }"/>
	<c:set var="row" value="${board2DAO.modify(dto) }"  />
	<c:redirect url="index.jsp" />
</c:if>


</body>
</html>