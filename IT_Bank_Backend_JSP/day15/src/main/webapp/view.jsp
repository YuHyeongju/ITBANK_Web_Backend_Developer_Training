<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>

<h3 style="text-align: center">게시글 상세보기</h3>

<fieldset style="border: 1px solid red;">

	<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
	<h4>${dto.title } | ${dto.writer } | ${dto.writeDate }</h4>
	<pre>${dto.content }</pre>

</fieldset>

<p>
	<a href="${cpath }/board.jsp"><button>목록</button></a> <a
		href="${cpath }/board-modify.jsp?idx=${dto.idx}"><button
			${dto.writer != login.userid? 'disabled':''}>수정하기</button></a>
</p>


<form action="reply-write.jsp">
	<h3 style="margin: 0 20px;">댓글 작성</h3>
	<c:if test="${empty login }">
		<c:set var="replyComment" value="로그인 후 댓글 작성 가능" />
	</c:if>
	<c:if test="${!empty login }">
		<c:set var="replyComment" value="바르고 고운 댓글 작성 부탁드립니다." />
	</c:if>
	<div style="display: flex; align-items: center;">
		<textarea name="content" rows="10" cols="100"
			placeholder="${replyComment }" ${empty login ? 'disabled':'' }
			style="resize: none; height: 100px; padding: 10px; margin: 20px; box-sizing: border-box;"></textarea>
		<input type="submit" value="댓글 작성하기" />
	</div>
	<input type="hidden" name="board_idx" value="${param.idx }" /> 
	<input type="hidden" name="writer" value="${login.userid }" />
</form>

<div id="reply">
	<c:forEach var="reply" items="${replyDAO.selectList(param.idx)}">
		<div class="replyItem" style="border: 1px solid grey; margin: 20px; padding: 10px; box-sizing: border-box;">
			<div style="display: flex; justify-content: space-between;">
				<div>${reply.writer }</div>
				<div>
					<fmt:formatDate value="${dto.writeDate }"
						pattern="yyyy-MM-dd a hh:mm" />
				</div>
			</div>
			
			<div>
				<pre>${reply.content }</pre>
			</div>
			<div style="display: flex; justify-content: right;">
				<a href="${cpath }/reply-delete.jsp?idx=${reply.idx }&board_idx=${param.idx}">
					<button ${reply.writer != login.userid? 'disabled':''}>댓글 삭제</button></a>
			</div>
		</div>
	</c:forEach>
</div>

<a href="${cpath }/board.jsp" style="margin: 20px;"><button>목록</button></a>
</body>
</html>