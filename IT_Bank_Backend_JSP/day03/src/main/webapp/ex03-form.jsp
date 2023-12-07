<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03-form.jsp</title>
</head>
<body>
<h1>업다운 게임 입력 / 출력</h1>
<hr>


<%--main (view) --%>
<%--
		만약에 컨트롤러를 거치지않고 바로 model로 가면 
		검토를 거치지 않고 데이터가 넘어가는 경우가 생긴다.
		-> 악용될 가능성이 있다. 
 --%>

<%-- 1 --%>
<form action="ex02-action.jsp"> <%-- a태그와 똑같은 역할을 수행함. --%>
	<input type="number" name = "user" required autofocus> 
	<button>제출</button>
	<a href="ex02-action.jsp?reset=true">
	<input type="button" value="다시"></a>
	<%-- 
	
		버튼 태그는 폼 안에 있을때 submit역할을 수행함.
		따라서 입력을 버튼타입으로 하여 제출로 취급되지 않게 함.
	
	 --%>
</form>


<h3><%=request.getParameter("msg") %></h3> <%-- 4 --%>

</body>
</html>