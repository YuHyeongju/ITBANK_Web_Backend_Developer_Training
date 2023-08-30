<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<h3>board 테이블 목록</h3>
	
	<article class="board">
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			
			<c:set var="list" value="${map['list'] }"/>
			
			<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.idx }</td>
				<td class="title">
					<a href="${cpath }/board/viewOne/${row.idx }">
						${row.title }
					</a>
				</td>
				<td>${row.writer }</td>
				<td>${row.vcount }</td>
				<td>${row.wdate }</td>
			</tr>
			</c:forEach>
		</table>
		
		<c:set var="begin" value="${map['begin'] }"/>
		<c:set var="end" value="${map['end'] }"/>
		
		<ul class="page">
			<li><a href="${cpath }/board/view/${begin - 1 }">이전</a></li>
		
			<c:forEach var="i" begin="${begin }" end="${end }">
			<li>
				<a href="${cpath }/board/view/${i }">
				${i }
				</a>
			</li>
			</c:forEach>
			
			<li><a href="${cpath }/board/view/${end + 1 }">다음</a></li>
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
					</select>
					<input name="search">
					<button>검색</button>
				</div>
			</form>
		</div>
	</article>

</body>
</html>