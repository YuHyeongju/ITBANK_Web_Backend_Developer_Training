<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="cpath" value="${pageContext.request.contextPath }"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ex02 단순 파일 업로드- 파일이름과 크기 출력</h1>
<hr>

<c:if test="${not empty fileName }">
	<p>fileName: ${fileName }</p>
	<p>fileSize: ${fileSize }</p>
	<p><img src="${cpath }/upload/${fileName}" height="300"></p> 

</c:if>





<form method="POST" enctype="multipart/form-data">
	<div><input type="file" name="upload"></div>
	<div style="margin-top:10px;"><input type="submit"></div> 

</form>

</body>
</html>