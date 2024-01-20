<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<div
	style="width: 80%; border: 2px solid red; width: 300px; height: 300px; margin:auto auto; ">
	<div style="text-align: center;"> 
		<h2>개인정보 수정하기</h2>
	</div>
	<div style="display: flex;">
		<table style="margin: auto auto;">
			<tr>
				<td>ID</td>
				<td>${login.userid }</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="userpw"
					value="${login.userpw }"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="userName"
					value="${login.userName }"></td>
			</tr>

		</table>
	</div>
</div>

</body>
</html>