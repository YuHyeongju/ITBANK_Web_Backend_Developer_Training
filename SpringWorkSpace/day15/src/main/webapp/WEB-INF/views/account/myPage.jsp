<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<article class="board">
		<table>
			<tr>
				<th>아이디</th>
				<td>${user.userid }</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${user.nick }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${user.email }</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>${user.jdate }</td>
			</tr>
		</table>
		
		<ul class="menu">
			<li><a href="${cpath }/account/update/${user.userid }">
				<button>수정</button>
			</a></li>
			<li><a href="${cpath }/account/delete/${user.userid }">
				<button>탈퇴</button>
			</a></li>
		</ul>
	</article>

</body>
</html>