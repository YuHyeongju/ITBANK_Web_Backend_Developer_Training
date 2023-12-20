<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add-action.jsp</title>
</head>
<body>

<jsp:useBean id="dto" class="bugs.BugsDTO"/>
<jsp:setProperty property="*" name="dto"/>

<c:set var="row" value="${dao.insert(dto) }"/>
<c:redirect url="/view.jsp?id=${id }"/>

<h3>추가 실패</h3>
<a href="add.jsp"><button>추가 페이지로 이동</button></a>
</body>
</html>