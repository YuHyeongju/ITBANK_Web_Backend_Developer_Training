<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>


<main>
	<h2
		style="width: 900px; margin: 0 auto; display: flex; justify-content: center;">대문</h2>
	<div
		style="width: 900px; margin: 0 auto; display: flex; justify-content: space-between; margin-top: 10px;
		background-color: Pink; padding:10px; font-weight: bold;">
		<a href="${cpath }/login.jsp">로그인</a>
		<c:if test="${!empty login }">
			<a href="${cpath }/logout.jsp">로그아웃</a>
			<a href="${cpath}/myPage.jsp">${login.userid }님이 로그인 중</a>
		</c:if>
		<c:if test="${empty login }">
			<a href="${cpath }/join.jsp">회원가입</a>
			-
		</c:if>

	</div>
	<details open class="frame" style="margin:0 auto; padding-top:10px;">
		<summary>paging info</summary>
		<c:set var="boardCount" value="${board2DAO.selectCount1(param.search) }" />
		<c:set var="paramPage" value="${empty param.page? 1: param.page }" />
		<c:set var="paging" value="${Paging.newInstance(paramPage, boardCount) }" />
		<c:set var="list" value="${board2DAO.selectList(param.search, paging) }" />
		<ul 
			style="display: flex; justify-content: space-around; list-style: none; border: 3px solid red; padding: 10px;
			background-color: aqua; font-weight: bold; color:red;">
			<li>게시글 개수: ${boardCount }</li>
			<li>요청 받은 페이지:${paramPage }</li>
			<li>paging.offset: ${paging.offset }</li>
			<li>paging.fetch:${paging.fetch }</li>
			<li>paging.begin:${paging.begin }</li>
			<li>paging.end:${paging.end }</li>
		</ul>
	</details>
	<table class="board" cellpadding="0" cellspacing="10" border="1"
		style="border-collapse: collapse; width: 900px; margin: 20px auto;">
		<thead>
			<tr>
				<th>번호</th>
				<th width="200px">제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.idx }</td>
					<td width="200px" style="text-align: center;"><a
						href="${cpath}/view.jsp?idx=${dto.idx}">${dto.title }</a> ${not empty dto.image ? '💾':''}
					</td>
					<td>${dto.writer }</td>
					<td>${dto.viewCount }</td>
					<td>${dto.writeDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<div class="sb frame" style="margin: 0 auto;">
		<div>
			<form>
				<input type="search" name="search" placeholder="검색어 입력"> <input
					type="submit" value="검색">
			</form>
		</div>

		<div style="display: flex; justify-content: center;">
			<c:if test="${paging.prev }">
				<a href="${cpath }?page=${paging.begin - 10 }&search=${param.search }">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${paging.begin}" end="${paging.end}">
				<a class="${paging.page == i ? 'bold': '' }" 
					href="${cpath }?page=${i}&search=${param.search }">[${i }]
				</a>
			</c:forEach>

			<c:if test="${paging.next }">
				<a href="${cpath }?page=${paging.end + 1}&search=${param.search }">[다음]</a>
			</c:if>

		</div>

		<div>
			<a href="${cpath }/write.jsp"><button>새 글 작성</button></a>
		</div>
	</div>

</main>

</body>
</html>