<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view.jsp</title>
<style>
	.box{
		width: 600px;
		margin: 0 auto;
		padding: 10px;
		border: 1px solid red;
	}
	.box > .button{
		width: 600px;
		margin: 0 auto;
	}
	pre{
		font-weight: bold;
		font-size: 18px;
		font-family: "Malgun Gothic";
	}
</style>
</head>
<body>

<jsp:useBean id="dao" class="bugs.BugsDAO"/>
<c:set var="dto" value="${dao.selectOne(param.id) }"/>
<h1>상세보기</h1>
<hr>
<div class="box">
	<h3>노래이름: ${dto.name }</h3>
	<h3>아티스트이름: ${dto.artist_name }</h3>
	<pre>가사: ${dto.lyrics }</pre>
	
	<div class="button">
		<a href="list.jsp"><button>목록으로 이동하기</button></a>
	</div>
	
</div>


</body>
</html>