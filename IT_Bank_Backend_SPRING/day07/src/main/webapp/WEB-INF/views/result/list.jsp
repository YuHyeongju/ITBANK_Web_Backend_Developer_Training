<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>

<style>
table {
	border: 1px solid red;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
}

thead>tr {
	background-color: #dadada;
}
</style>

<h3>설문 결과</h3>

<table>
	<thead>
		<tr>
			<th>설문 번호</th>
			<th>설문 제목</th>
			<th>0번 응답 비율</th>
			<th>1번 응답 비율</th>
			<th>설문 응답 개수</th>
		</tr>
	</thead>
	<c:forEach var="dto" items="${list }">
		<tbody>
			<tr>
				<td>${dto.idx }</td>
				<td>${dto.title }</td>
				<td><fmt:formatNumber value="${dto.response1_rate }"
						pattern="###.##"></fmt:formatNumber></td>
				<td><fmt:formatNumber value="${dto.response2_rate }"
						pattern="###.##"></fmt:formatNumber></td>
				<td>${dto.survey_count }</td>
			</tr>
		</tbody>
	</c:forEach>


</table>

</body>
</html>