<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<fieldset class="inputForm">
		<legend>find</legend>
	
		<form method="POST">
			<p>
				<label>이메일</label>
				<input name="email" required>
			</p>

			<button>ID 찾기</button>
		</form>
		
		<hr>
		
		<form action="findPw" method="POST">
			<p>
				<label>ID</label>
				<input name="userid" required>
			</p>
			<p>
				<label>이메일</label>
				<input name="email" required>
			</p>

			<button>PW 찾기</button>
		</form>
	</fieldset>

</body>
</html>