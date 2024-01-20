<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board2.jsp</title>
</head>
<body>

	${list }
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
	
	<div style="padding:0 20px;">
		<form>
			<input type="search" name="search" placeholder="검색어 입력"> <input
				type="submit" value="검색">
		</form>
	</div>
	
	<div style="display: flex; justify-content: center;">
		<c:if test="${paging.prev }">
			<a
				href="${cpath }board2?page=${paging.begin - 10 }&search=${param.search }">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${paging.begin}" end="${paging.end}">
			<a class="${paging.page == i ? 'bold': '' }"
				href="${cpath }board2?page=${i}&search=${param.search }">[${i }]
			</a>
		</c:forEach>

		<c:if test="${paging.next }">
			<a
				href="${cpath }board2?page=${paging.end + 1}&search=${param.search }">[다음]</a>
		</c:if>

	</div>
</body>
</html>