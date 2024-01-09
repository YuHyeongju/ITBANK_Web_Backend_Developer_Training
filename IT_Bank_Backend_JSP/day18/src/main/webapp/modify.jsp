<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<c:if test="${pageContext.request.method == 'GET' }">
	<c:if test="${empty login }">
		<script>
			alert('먼저 로그인후 글을 수정 할 수 있습니다.')
			location.href = '${cpath}/login.jsp'
		</script>
	</c:if>	
		<h2 style="display: flex; justify-content: center;">수정하기</h2>
		<c:set var="dto" value="${board2DAO.selectOne(param.idx) }"/>
		<form method="POST" enctype="multipart/form-data">
			<p>
				<input type="text" name="title" placeholder="제목" value="${dto.title }">
			</p>
			<p>
				<textarea name="content" placeholder="내용" >${dto.content }</textarea>
			</p>
			<p>
				<input type="file" name="uploadFile" multiple = "multiple">
			</p>
			<p>
				<input type="submit" value="수정완료">
			</p>

			<input type="hidden" name="writer" value="${login.userid }">
			<input type="hidden" name="ipaddr"
				value="${pageContext.request.remoteAddr}">
			<!--  ip주소를 불러옴 -->
		</form>
		<a href ="${cpath }/view.jsp?idx=${dto.idx}"><button>상세보기로 돌아가기</button></a>
</c:if>
<c:if test="${pageContext.request.method =='POST' }">
	<c:set var="dto" value="${fileUtil.getDTO(pageContext.request) }"/>
	<c:set var="row" value="${board2DAO.modify(dto) }"  />
	<c:redirect url="view.jsp?idx=${param.idx }" />

</c:if>

</body>
</html>