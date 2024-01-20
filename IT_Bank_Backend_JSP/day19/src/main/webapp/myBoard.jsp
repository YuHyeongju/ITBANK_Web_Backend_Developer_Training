<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<main>
	<h2 style="display: flex; justify-content: center;">내가 쓴 글</h2>
	<table class="board" cellpadding="0" cellspacing="10" border="1"
		style="border-collapse: collapse; width: 900px; margin: 20px auto;">
		<thead>
			<tr>
				<th>번호</th>
				<th width="200px">제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>날짜</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="boardCount" value="${board2DAO.selectCount2(login.userid) }" />
			<c:set var="paramPage" value="${empty param.page? 1: param.page }" />
			<c:set var="paging" value="${Paging.newInstance(paramPage, boardCount) }" />
			<c:set var="list"
				value="${board2DAO.selectListByWriter(login.userid,paging) }" />
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.idx }</td>
					<td width="200px" style="text-align: center;"><a
						href="${cpath}/view.jsp?idx=${dto.idx}">${dto.title }</a> ${not empty dto.image ? '💾':''}
					</td>
					<td>${dto.writer }</td>
					<td>${dto.viewCount }</td>
					<td>${dto.writeDate }</td>
					<td><a
						href="${cpath }/myBoard-delete.jsp?idx=${dto.idx}&deleted=${dto.deleted}"><button>${dto.deleted == 0?'삭제하기':'복원하기' }</button></a>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div style="width: 900px; display: flex; justify-content: space-between; margin: 0 auto;">
		<div>
			<a href="${cpath }/index.jsp"><button>index.jsp로 이동</button></a>
		</div>

		<div>
			<c:if test="${paging.prev }">
				<a href="${cpath }/myBoard.jsp?page=${paging.begin - 10}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${paging.begin}" end="${paging.end}">
				<a class="${paging.page == i ? 'bold': '' }"
					href="${cpath }/myBoard.jsp?page=${i}">[${i }] </a>
			</c:forEach>

			<c:if test="${paging.next }">
				<a href="${cpath }/myBoard.jsp?page=${paging.end + 1}">[다음]</a>
			</c:if>
		</div>
		<div></div>
	</div>
</main>

</body>
</html>