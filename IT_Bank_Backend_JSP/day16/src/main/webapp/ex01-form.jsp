<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01 - form.jsp</title>
</head>
<body>


<h1>ex01 - form.jsp</h1>
<hr>

<h3>파일을 첨부하여 form 제출하기</h3>

<h3>application/x-www-form-urlencoded(method : POST 일 때 기본 전송 형식,GET은 사용불가(파일을 주소창에 넣어서 전송할 수 없음))</h3>
<h3>multipart/form-data(파일을 포함하는 경우 변경해주는 전송 형식)</h3>

<ul>
	<li>input[type="file"] 요소는 value를 지정할 수 없다.</li>
	<li>파일이 하나라도 포함되어 있으면 multipart/form-data 형식을 지정해야한다.</li>
	<li>multipart/form-data는 jsp내장객체 request로 파일을 추출 할 수 없다.</li>
</ul>

<fieldset>
	<form method="POST" enctype="multipart/form-data" action="ex01-action.jsp">
		<p><input type="text" name="test1" value="colmdownman.jpg"></p>
		<p><input type="file" name="profileImg" value="colmdownman.jpg"></p> 
		<%-- value는 지정할 수 없음, 보안상의 이유로 첨부파일을 조작할 수 없게 만듦--%>
		<p><input type="submit"></p>
	</form>
	<%--application/x-www-form-urlencoded를 enctype지정하면 서버가 값을 알아차리지만 
		multipart/form-data를 사용하면 알아차리지 못한다.
	--%>
</fieldset>
</body>
</html>