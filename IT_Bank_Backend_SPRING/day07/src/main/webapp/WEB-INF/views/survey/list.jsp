<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>

<section>
	<h3>설문 목록</h3>
	<table border="1" cellpadding="10" cellspacing="0">
		<c:forEach var="dto" items="${list }">
			<thead>
				<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${dto.idx }</td>
					<td><a href="${cpath}/survey/view/${dto.idx}">${dto.title }</a></td>
					<td>${dto.writer }</td>
				</tr>
			</tbody>


		</c:forEach>



	</table>
</section>

</body>
</html>