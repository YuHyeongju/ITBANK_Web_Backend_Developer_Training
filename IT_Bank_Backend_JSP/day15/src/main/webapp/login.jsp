<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<c:if test="${pageContext.request.method == 'GET' }">
	<form method="POST">
		<div style="margin: auto auto; width: 500px; height:300px; display: flex; border:1px solid red;">
			<div style="margin:auto auto;">
				<input type="text" name="userid" placeholder="ID" required autofocus>
				<input type="password" name="userpw" placeholder="PW" required>
				<input type="submit" value="로그인하기">
			</div>
		</div>
	</form>
</c:if>

<c:if test="${pageContext.request.method == 'POST' }">
	<jsp:useBean id="dto" class="member.MemberDTO" />
	<jsp:setProperty property="*" name="dto" />
	<c:set var="login" value="${memberDAO.login(dto) }" scope="session" />
	<c:redirect url="/" />


</c:if>
</body>
</html>