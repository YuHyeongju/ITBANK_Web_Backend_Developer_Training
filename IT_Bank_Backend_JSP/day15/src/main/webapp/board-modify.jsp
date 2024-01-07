<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<c:if test="${pageContext.request.method == 'GET' }">
	<form method="POST">
		<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
		<div class="midify-form"
			style="border: 1px solid red; width: 500px; height: 500px; margin: auto auto; display: flex;">
			<div style="margin: auto auto;">
				<h1>게시글 수정</h1>
				<p>
					<input type="hidden" name="idx" value="${dto.idx }">
				</p>

				<p>
					<input type="text" name="title" placeholder="수정할 게시글제목 입력" value="${dto.title }" required
						autofocus>
				</p>
				<p>
					<input type="text" name="writer" value="${login.userid }" readonly>
				</p>
				<p>
					<textarea name="content" rows="8" cols="60" placeholder="수정할 내용"required >${dto.content }</textarea>
				</p>
				<p>
					<input type="submit" value="수정하기">
				</p>
			</div>
		</div>
	</form>
	<p style="width:500px; margin:0 auto; padding-top:10px;">
	<a href="${cpath }/board.jsp"><button>목록</button></a>
	</p>
</c:if>
<c:if test="${pageContext.request.method == 'POST' }">
	<jsp:useBean id="dto" class="board.BoardDTO" />
	<jsp:setProperty property="*" name="dto" />
	<c:set var="row" value="${boardDAO.modify(dto) }" />
	<c:redirect url="view.jsp?idx=${param.idx }" />
</c:if>


</body>
</html>