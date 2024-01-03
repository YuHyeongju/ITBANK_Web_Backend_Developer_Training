<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<c:if test="${pageContext.request.method == 'GET' }">
	<c:if test="${empty login }">
		<script>
			alert('먼저 로그인후 글을 작성할 수 있습니다.')
			location.href = '${cpath}/login.jsp'
		</script>
	</c:if>
	<form method="POST">
		<div
			style="border: 1px solid red; width: 600px; height: 400px; margin: auto auto; display: flex;">
			
			<div style="margin: auto auto;">
				<p>
					<input type="text" name="title" placeholder="게시글제목 입력" required
						autofocus>
					<input type="hidden" name="writer" value="${login.userid }">
				</p>
				<p>
					<textarea name="content" placeholder="내용" rows="8" cols="60"
						required></textarea>
				</p>
				<p>
					<input type="submit" value="작성하기">
					
				</p>
			</div>

		</div>

	</form>
	<p style="width:600px; margin:0 auto; padding-top:10px;" ><a href="${cpath }/board.jsp" ><button>목록</button></a></p>
</c:if>
<c:if test="${pageContext.request.method == 'POST' }">
	<jsp:useBean id="dto" class="board.BoardDTO"/>
	<jsp:setProperty property="*" name="dto"/>
	<c:set var="row" value="${boardDAO.insert(dto) }"/>
	<c:redirect url="board.jsp"/> 
</c:if>
</body>
</html>