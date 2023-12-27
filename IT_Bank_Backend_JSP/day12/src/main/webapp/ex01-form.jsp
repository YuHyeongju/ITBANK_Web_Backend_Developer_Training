<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01-form.jsp</title>
</head>
<body>


<h1>ex01-form.jsp</h1>
<hr>

<fieldset>
	<legend>POST</legend>
	<ul>
		<li>form에서 문자열 입력값을 보여주고 싶지 않으면 input의 type="password"를 사용한다.</li>
		<li>form에서 method를 지정하지 않으면, GET 메서드가 기본값이다.</li>
		<li>GET은 전송이 빠르고 직관적이다. 대신 파라미터가 주소창에 노출된다.</li>
		<li>GET은 주로 검색어 같은 보여도 상관 없는 것들을 전달할 때 사용함.</li>
		<li>용량이 많거나, 주소차엥 노출시키고 싶지 않거나, 문자열로 표현 불가능한 값은 POST로 전달한다. </li>
		<li>POST는 입력값을 쿼리스티링으로 전달하지 않음.</li>
		<li>POST는 GET에 비해 처리속도가 다소 느리지만, 더 많은 데이터를 전송하는데 사용한다.</li>
	</ul>
</fieldset>


<form action="ex01-action.jsp" method="post">
	<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="Password" required></p>
	<p><input type="submit" value="로그인"></p>
</form>
</body>
</html>