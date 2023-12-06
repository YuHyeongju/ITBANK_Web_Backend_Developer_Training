<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-form.jsp</title>
</head>
<body>
<h1>업다운 게임 입력 / 출력</h1>
<hr>
<%-- 1 --%>
<form action="ex02-action.jsp"> <%-- a태그와 똑같은 역할을 수행함. --%>
	<input type="number" name = "user" required autofocus> 
	<input type="submit">
	<a href="ex02-action.jsp?reset=true"><input type="button" value="다시"></a>
	<%-- 
	
		버튼 태그는 폼 안에 있을때 submit역할을 수행함.
		따라서 입력을 버튼타입으로 하여 제출로 취급되지 않게 함.
	
	 --%>
</form>


<h3><%=request.getParameter("msg") %></h3> <%-- 4 --%>
<%--여기서는 입출력만 담당하고 ex02-action.jsp는 처리를 담당하기
    때문에 당연히 파라미터가 넘어올것이라 생각하고 처리를 함. 
    그래서 코드가 짧아짐. 
--%>

<%--main역할 --%>
</body>
</html>