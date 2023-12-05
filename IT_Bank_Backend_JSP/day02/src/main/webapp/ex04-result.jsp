<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex04-result.jsp</title>
</head>
<body>
	<h1>ex04-result.jsp</h1>
	<hr>

	<% //넘어온 데이터를 처리하고 결과를 띄우기 위해서 자바코드를 사용함.
	String name = request.getParameter("name");
	String age = request.getParameter("age"); // 파일을 제외한 나머지 유형은 String으로 받으면 된다.
	String msg = "";

	if (name != null) {
		String adult = Integer.parseInt(age) >= 20 ? "성인" : "미성년자";
		msg = String.format("%s님의 나이는 %s살이고, %s입니다.", name, age, adult);
	}
	%>
	<h3><%=msg%></h3>
	<a href="ex04-form.jsp"><button>다시 입력</button></a> 
	<%--a 태그의 ex04-form.jsp에 의해 폼 태그로 이동 
		a태그는 새로운 요청을 만들 수 있다. 서버는 그 요청을 처리해야한다.--%>
</body>
</html>