<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bugs.*"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%--어디서나ㅡ 문서 최상위 경로(webapp)에 접근 할 수 있도록 한다. --%>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>

<%--어디서나 dao 객체에 바로 접근 할 수 있도록 한다. --%>
<c:set var="dao" value="${BugsDAO.getInstance() }"/>

 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
<style>
body{
	background-color: #eee;
	padding:0;
	margin:0;
}
header,section{
	background-color: white;
	margin: 0 auto;
	width: 1100px; 
	padding: 20px;
	box-sizing: border-box;
}
header{
	position: fixed;
	top: 0;
	left:50%;
	transform: translate(-50%, 0);
	height: 100px;
	z-index: 5;
	box-sizing: border-box;

}
div{
	box-sizing: border-box;
}
section{
	position: absolute;
	top: 100px;
	left: 50%;
	transform: translate(-50%,0);
}
h1,h3{
	margin: 0;
}
table {
	border: 2px solid black;
	border-collapse: collapse;
	margin: 0 auto;
}

tr {
	border-bottom: 1px solid grey;
}

th, td {
	border: 2px solid grey; 
	padding: 10px;
	text-align: center;
}

thead {
	background-color: #dadada;
}

tbody>tr:hover {
	background-color: #eee;
	color: black;
	cursor: pointer;
}
.sb{
	display: flex;
	justify-content: space-between;
	align-items: center;
}
.view{
	display:flex;
	background-color: #0000ff33;
}
.view > div{
	padding: 10px;
}
.search{
	

}


</style>
</head>
<body>

<header>
	<h1><a href="${cpath }">day11-Bugs</a></h1>
</header>

</body>
</html>