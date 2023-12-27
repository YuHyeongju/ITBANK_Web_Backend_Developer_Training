<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>list.jsp</title>
</head>
<body>

	<form>
		<table>
			<thead>
				<tr>
					<th>USERID
					<th>
					<th>USERNAME
					<th>
					<th>GENDER
					<th>
					<th>EMAIL
					<th>
					<th>수정/삭제</th>
				</tr>
			</thead>
			<tbody>
				<jsp:useBean id="dao" class="member.MemberDAO"/> 
				<tr>
					<td>${dto.userid }</td>
					<td>${dto.userName }</td>
					<td>${dto.gender }</td>
					<td>${dto.email }</td>
					<td>
						<a href="modify.jsp?userid=${dto.userid }"><button>수정</button></a> 
						<a href="delete.jsp?userid=${dto.userid }"><button>삭제</button></a> 
					</td>
				</tr>
				
			</tbody>


		</table>


	</form>

</body>
</html>