<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<jsp:useBean id="userid" class="member.MemberDAO"/>
<jsp:setProperty property="*" name="userid"/>

<c:set var="login" value="${dao.login(userid) }" scope="session"/>

<c:redirect url="list.jsp"/>

</body>
</html>