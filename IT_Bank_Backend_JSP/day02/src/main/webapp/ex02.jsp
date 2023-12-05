<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02.jsp</title>
</head>
<body>
<h1>request.getParameter(String name)</h1>
<hr>

<h3>주소의 쿼리스트링 형태로 파라미터를 추가할 수 있다.</h3>
<a href="<%=request.getRequestURL()%>?guest=손님"><button>손님링크</button></a>
<%--?전까지가 자원의 경로 이후가 쿼리스트링 --%>
<%
	String guest = request.getParameter("guest");
%>

<h3>form태그에 입력한 값이 파라미터로 전송될 수 있다. 이떄 input의 name을 맟춰야한다.</h3>

<form>

	<p><input type="text" name="guest" placeholder="손님 이름 입력"></p>
	<p><input type="submit" value="제출"></p>
</form>

<h3>guest : <%=guest %></h3>
</body>
</html>