<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<jsp:setProperty property="*" name="dto"/>

<c:set var="login" value="${dao.login(param.userid,param.userpw) }"/>  



<c:redirect url="list.jsp"/>
</body>
</html>