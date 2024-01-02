<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>    

<c:if test="${pageContext.request.method == 'GET' }">
	<form method = "POST">
		<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
		<p><input type="password" name="userpw" placeholder="PW" required ></p>
		<p><input type="submit" value="로그인"></p>
	
	</form>

</c:if>
<c:if test="${pageContext.request.method == 'POST' }">
		<jsp:useBean id="dto" class="member.MemberDTO"/>
		<jsp:setProperty property="*" name="dto"/>
		<c:set var="login" value="${memberDAO.login(dto) }" scope="session"/>
		<c:redirect url="/"/>
		<!-- action 안쓰고 login에서 한번에 처리 -->

</c:if>
</body>
</html>