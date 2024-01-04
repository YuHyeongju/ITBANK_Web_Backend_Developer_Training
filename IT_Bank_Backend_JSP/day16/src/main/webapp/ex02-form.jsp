<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ex02.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-form.jsp</title>
</head>
<body>

<h1>ex02-form.jsp</h1>
<hr>

<form method="POST" action="ex02-action.jsp" enctype="multipart/form-data">
	<p><input type="text" name="title" placeholder="제목"></p>
	<p><input type="file" name="image" accept="image/*"></p> <!-- accept: 첨부할 수 있는 파일 종류를 지정(권장사항)--> 
	<p><input type="date" name="eventDate"></p>					<!-- 압축파일: application/zip 
																	servers안에 web.xml안에 원하는 확장자 이름을 검색하면	-->							
	<p><input type="submit"></p>								<!-- accept에 넣을 것이 밑에 나온다. -->


</form>
<style>
	#root{
		width: 860px;
		margin: 20px auto;
		display: flex;
		flex-flow: wrap;
		
	}
	.item{
		width: 320px;
		padding:10px;
		margin:20px;
		border: 1px solid grey;
		text-align: center;
		overflow:hidden;
	}


</style>

<c:set var="fileUtil" value="${FileUtil.getInstance() }"/>
<c:set var="fileNames" value="${fileUtil.getFileNames() }"/>

<div id="root">
	<c:forEach var="name" items="${fileNames }">
		<div class="item">
			<img src="upload/${name }" height="150px">
		</div>
	</c:forEach>
</div>

</body>
</html>