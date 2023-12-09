<%@page import="person.PersonDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list-show.jsp</title>
</head>
<body>
	<h1>person 목록</h1>
	<hr>

	<p>
		<a href="add-form.jsp"><button>추가</button></a>
	</p>
	<table border="1" cellpadding="10" cellspacing="0">
		<thead>

			<tr>
				<th>이름</th>
				<th>나이</th>
			<tr>
		</thead>
		<tbody>
			<%
			List<PersonDTO> list = (List<PersonDTO>)request.getAttribute("list");
			for(PersonDTO dto : list){ %>

			<tr>
				<td><a href="view.jsp?name=<%=dto.getName()%>"><%=dto.getName() %></a></td>
				<%-- dto에서 가져온 이름과 누른이름이 같으면 view.jsp로 이동 --%>
				<td><%=dto.getAge() %></td>
			</tr>


			<% } %>

		</tbody>


	</table>


</body>
</html>