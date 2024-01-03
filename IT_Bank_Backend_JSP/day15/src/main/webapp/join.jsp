<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<c:if test="${pageContext.request.method =='GET' }">
	<h4 style="text-align: center;">회원가입</h4>
	<form method="POST">
		<div
			style="border: 1px solid red; width: 400px; height: 400px; margin: auto auto; display: flex;">
			<div style="margin:auto auto;">
				<p>
					<input type="text" name="userid" placeholder="ID" required
						autofocus>
				</p>
				<p>
					<input type="password" name="userpw" placeholder="PW" required>
				</p>
				<p>
					<input type="text" name="userName" placeholder="NAME" required>
				</p>
				<p>
					<label><input type="radio" name="gender" value="남성"
						required>남성</label> <label><input type="radio"
						name="gender" value="여성" required>여성</label>
				</p>
				<p>
					<input type="email" name="email" placeholder="foo@bar.com" required>
				</p>
				<p>
					<input type="submit" value="회원가입하기">
				</p>
			</div>
		</div>
	</form>
</c:if>

<c:if test="${pageContext.request.method =='POST' }">
	<jsp:useBean id="dto" class="member.MemberDTO" />
	<jsp:setProperty property="*" name="dto" />
	<c:set var="row" value="${memberDAO.insert(dto) }" />
	<c:if test="${row != 0 }">
		<c:redirect url="/login.jsp" />
	</c:if>
	<c:redirect url="/" />
	<script>
		alert('회원가입이 되지않았습니다.')
		history.go(-1)
	</script>
</c:if>

</body>
</html>