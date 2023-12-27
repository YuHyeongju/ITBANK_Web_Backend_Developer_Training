<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>close.jsp</title>
</head>
<body>

<%

	String makeCookie = request.getParameter("makeCookie");

	if(makeCookie != null){
		Cookie cookie = new Cookie("donotpopup","과자"); // 값이 뭐든 상관 없다.
		cookie.setMaxAge(30);
		response.addCookie(cookie);
	}


%>

<script>
	window.close()
</script>


</body>
</html>