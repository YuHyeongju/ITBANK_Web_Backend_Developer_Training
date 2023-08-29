<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%--여기에 board 테이블 전체를 출력 --%>
<h3>board 테이블 목록</h3>
<article id="view" class="board">
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.idx }</td>
				<td><a href="${cpath}/board/view/${row.idx }"> ${row.title }
				</a></td>
				<td>${row.writer }</td>
				<td>${row.vcount }</td>
				<td>${row.wdate }</td>
			</tr>
		</c:forEach>
	</table>
	<ul class="page">
		<c:forEach var="i" begin="1" end="5">
			<li>${i }</li>
		</c:forEach>
	</ul>

	<div class="search">
		<a href="${cpath }/board/write">
			<button>글 작성</button>
		</a>

		<form>
			<div>
				<select name="type">
					<option>제목</option>
					<option>작성자</option>
					<option>내용</option>
				</select> <input name="search">
				<button>검색</button>
			</div>
		</form>
	</div>
</article>
</body>
</html>