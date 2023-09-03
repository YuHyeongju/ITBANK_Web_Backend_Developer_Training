<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<fieldset class="inputForm">
	<legend>signUp</legend>

	<form method="POST">
		<p>
			<label>아이디</label> <input name="userid" required>
		</p>
		<p>
			<label>비밀번호</label> <input name="userpw" type="password" required>
		</p>
		<p>
			<label>닉네임</label> <input name="nick" required>
		</p>
		<p>
			<label>이메일</label> <input name="email" type="email" required>
		</p>
		<button>가입</button>

	</form>
</fieldset>

</body>
</html>