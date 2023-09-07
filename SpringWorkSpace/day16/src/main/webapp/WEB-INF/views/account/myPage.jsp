<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<form action="update" method="POST">
	<article class="board">
		<table>
			<tr>
				<th>아이디</th>
				<td>${user.userid }</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input name = "userpw" type = "password" required></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${user.nick }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input name = "email" type="email" required value="${user.email }"></td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>${user.jdate }</td>
			</tr>
		</table>
		
		<input name="userid" type="hidden" value="${user.userid }">
		
		<ul class="menu">
			<li>
				<button>수정</button>
			</li>
			<li>
				<button type="button">탈퇴</button>
			</li>
		</ul>
	</article>
	<script>
		var delBtn = document.querySelectorAll('button')[1];
		
		delBtn.onclick = function() {
			var isDel = confirm('탈퇴하시겠습니까?');
			
			if(isDel){
				location.href = '${cpath}/account/delete/${user.userid}';
			}
		};
			
	</script>
</form>
</body>
</html>