<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete.jsp</title>
</head>
<body>
<jsp:useBean id="dao" class="bugs.BugsDAO" />
<jsp:useBean id="dto" class="bugs.BugsDTO"/>
<c:set var="dao" value="${dao.delete(param.id) }"/>



<c:redirect url="/list.jsp"/>

</body>
</html>