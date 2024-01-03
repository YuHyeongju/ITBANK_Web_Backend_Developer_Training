<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<c:if test="${pageContext.request.method == 'GET' }">
	<form method="POST" >
		<input type="hidden" name="userid" value="${login.userid }"/>
		<input type="password" name="userpw" placeholder="지울 계정의 비밀번호 입력" required autofocus>
		<input type="submit" value="탈퇴하기">
	</form>
</c:if>

<c:if test="${pageContext.request.method == 'POST' }">
	<jsp:useBean id="dto" class="member.MemberDTO"/>
	<jsp:setProperty property="*" name="dto"/>
	<c:set var="row" value="${memberDAO.delete(dto) }"/>
	<c:redirect url="/logout.jsp"/>
</c:if>

</body>
</html>