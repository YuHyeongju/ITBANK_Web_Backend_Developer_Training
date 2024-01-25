<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>alert.jsp</title>
</head>
<body>
	<script>
		const msg = '${msg}'
		const url = '${url}'
		const cpath = '${cpath}'
		
		if(msg.includes("성공")){
			alert(msg)
			location.href = cpath + url
		}
		else{
			
			alert(msg)
			history.go(-1)
		}
	</script>
</body>
</html>