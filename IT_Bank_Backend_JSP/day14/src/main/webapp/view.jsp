<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<h3 style="text-align:center">게시글 상세 보기</h3>

<fieldset>
	<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
	<h4>${dto.title }| ${dto.writer } | ${dto.writeDate }</h4>
	<pre>${dto.content }</pre>
</fieldset>

<br>

<form action="reply-write.jsp">
	<h3 style="margin:0 20px;">댓글 작성</h3>
	<c:if test="${empty login }">
		<c:set var="replyComment">로그인 후에 댓글 작성 가능합니다.</c:set>
	</c:if>
	<c:if test="${not empty login }">
		<c:set var="replyComment">바르고 고운말을 사용합시다.</c:set>
	</c:if>
	<div style="display: flex; align-items: center;">
		<textarea name="content" rows ="5" cols="80" placeholder="${replyComment }" ${empty login ? 'disabled':'' }
		style="resize: none;
				height: 100px;
				padding: 10px;
				margin: 20px;
				box-sizing: border-box;"></textarea>
		<input type="submit" value="댓글쓰기">
	</div>
	<input type="hidden" name="board_idx" value="${param.idx}">
	<input type="hidden" name="writer" value="${login.userid}">
</form>

<div id="reply">
	<c:forEach var="reply" items="${replyDAO.selectList(param.idx)}"> <%-- 단일 댓글이 reply로 정의됨 --%>
		<div class="replyItem" style="border: 1px solid grey; margin: 20px; padding: 10px; box-sizing: border-box;">
			<div style="display: flex; justify-content: space-between;">
				<div>${reply.writer }</div>
				<div>
					<fmt:formatDate value="${dto.writeDate }"
						pattern="yyyy-MM-dd a hh:mm" />
				</div>

			</div>

			<div>
				<pre>${reply.content}</pre>
			</div>
			<div style="display: flex; justify-content: right;">
				<a href="${cpath }/reply-delete.jsp?idx=${reply.idx }&board_idx=${param.idx}" ><button ${reply.writer != login.userid? 'disabled':''}>댓글 삭제</button></a>
			</div>
		</div>
	</c:forEach>

</div>


<a href="${cpath }/board.jsp" style="margin:20px;"><button>목록</button></a>
</body>
</html>