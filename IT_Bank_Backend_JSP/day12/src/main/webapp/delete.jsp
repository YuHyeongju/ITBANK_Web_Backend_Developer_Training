<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<jsp:useBean id="dto" class="member.MemberDTO"/>
<c:set var="dao" value="${dao.delete(userid,userpw) }"/>

<c:redirect url="list.jsp"/>

</body>
</html>