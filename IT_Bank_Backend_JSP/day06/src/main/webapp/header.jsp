<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="cpath" value="${pageContext.request.contextPath }"/> <%-- 내가 값을 지정할 수 있을 때 c:set  --%>
							<%-- 요청받은 자원의 최상위 폴더경로를 문자열로 반환, jsp프로젝트의 webapp 경로에 해당 --%>
<jsp:useBean id="dao" class="phonebook.PhoneBookDAO" />	<%-- 기본생성자로 객체를 생성하고싶을 때  useBean--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::: PhoneBook :::</title>
</head>
<body>

<h1><a href="${cpath }">PhoneBook</a></h1>
<div>
	<ul>
		<li><a href="list.jsp">목록</a></li>
		<li><a href="add.jsp">추가</a></li>
	
	</ul>
</div>
<hr>
