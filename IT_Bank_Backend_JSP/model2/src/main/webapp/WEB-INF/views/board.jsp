<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
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
	<div
		style="width: 900px; display: flex; justify-content: space-between; margin: 0 auto;">
		<div class="searchbar">
			<form>
				<input type="search" name="search" placeholder="검색어 입력"
					id="searchArea"> <input type="submit" value="검색"
					id="searchBtn">
			</form>
		</div>

		<div>
			<c:if test="${paging.prev }">
				<a href="${cpath }/board?page=${paging.begin - 10}">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${paging.begin}" end="${paging.end}">
				<a class="${paging.page == i ? 'bold': '' }"
					href="${cpath }/board?page=${i}">[${i }] </a>
			</c:forEach>

			<c:if test="${paging.next }">
				<a href="${cpath }/board?page=${paging.end + 1}">[다음]</a>
			</c:if>
		</div>
		<div></div>
	</div>
</body>
</html>