<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>

<article class="board">

	<table>

		<tr>
			<th>작성자</th>
			<th>${row.writer}</th>
			<th>조회수</th>
			<th>${row.vcount }</th>
			<th>작성일</th>
			<th>${row.wdate }</th>
		</tr>
		<tr>
			<td colspan="6">${row.idx }.${row.title }</td>
		</tr>
		<tr>
			<td colspan="6"><pre>${row.contents }</pre></td>
		</tr>
	</table>
	<br>
	<div>
		<a href="${cpath }/board/update/${row.idx}"><button>수정</button></a> <a
			href="${cpath }/board/delete/${row.idx}"><button>삭제</button></a>
	</div>

	<hr>

	<form class="reply" method="POST">
		<input name="writer" type="hidden" value="${user.nick }">
		<textarea name="contents" placeholder="바른말을 사용합시다."></textarea>
		<button>작성</button>
	</form>

	<c:forEach var="rep" items="${replys }">
		<div class="replyView">
			${rep.idx }.${rep.writer } | ${rep.wdate } <br> ${rep.contents}

		</div>


	</c:forEach>


</article>


</body>
</html>