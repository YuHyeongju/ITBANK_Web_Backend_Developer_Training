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
		
		<c:set var="page" value="${map['page'] }"/>
		
		<c:if test="${param.search != null and param.search != ''}">
			<c:set var="path" value="?type=${param.type }&search=${param.search }"/>
		</c:if>	
		
		
		
		<ul class="page">
			<c:if test="${page.prev }">
			<li><a href="${cpath }/board/view/${page.begin - 1 }/${path}">이전</a></li>
			</c:if>
			
			<c:forEach var="i" begin="${page.begin }" end="${page.end }">
			<li>
				<a href="${cpath }/board/view/${i }/${path}">
				${i }
				</a>
			</li>
			</c:forEach>
			<c:if test="${page.next }">
			<li><a href="${cpath }/board/view/${page.end + 1 }">다음</a></li>
			</c:if>
		</ul>
		
		<div class="search">
			<a href="${cpath }/board/write">
				<button>글 작성</button>
			</a>
			
			<form>
				<div>
					<select name="type">
						<option value="title">제목</option>
						<option value="writer">작성자</option>
						<option value="contents">내용</option>
					</select>
					<input name="search">
					<button>검색</button>
				</div>
			</form>
		</div>
	</article>

</body>
</html>