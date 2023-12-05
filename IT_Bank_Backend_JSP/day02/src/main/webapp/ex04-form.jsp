<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex04-form.jsp</title>
</head>
<body>

<h1>ex04-form.jsp</h1>
<hr>
	
	<form action="ex04-result.jsp"> <%--폼태그에 의해 ex04-result.jsp로 넘어감  --%>
		<p>							<%--모양을 만드는 코드에는 자바코드가 필요없다. --%>
			<input type="text" name="name" placeholder="이름" required autofocus>
		</p>
		<p>
			<input type="number" name="age" min="0" max="100" placeholder="나이"required></p>
		<p>
			<input type="submit">

		</p>
	</form>	
</body>
</html>