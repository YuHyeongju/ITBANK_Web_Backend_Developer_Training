<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<c:if test="${pageContext.request.method == 'GET' }">
	<form method="POST" style="border: 1px solid red; width: 500px; height:300px;display:flex; justify-content: center;
	margin: auto auto;">
		<div style="margin: 0 auto; margin-top:10px; padding: 10px; ">
			<h2
				style=" display: flex; justify-content: center;">로그인</h2>
			<p> 
				<input type="text" name="userid" placeholder="아이디 입력" required
					autofocus>
			</p>
			<p>
				<input type="password" name="userpw" placeholder="비밀번호 입력" required>
			</p>
			<input type="submit" value="로그인">
		</div>
	</form>
</c:if>
<c:if test="${pageContext.request.method == 'POST' }">
	<jsp:useBean id="dto" class="member.MemberDTO" />
	<jsp:setProperty property="*" name="dto" />
	<c:set var="login" value="${memberDAO.login(dto) }" scope="session" />
	<c:redirect url="index.jsp" />
</c:if>


</body>
</html>