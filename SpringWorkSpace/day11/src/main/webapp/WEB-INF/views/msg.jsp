<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메시지</title>
</head>
<body>
	<script>
		var row = ${row};
		alret('${msg}');
		
		if(row != 0){
			location.href ='${cpath}' + '${path}';
		}else{
			history.go(-1);//음수:뒤로버튼
		}
	</script>
</body>
</html>