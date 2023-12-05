<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz01.jsp</title>
</head>
<body>
<h1>quiz01.jsp - 두 수의 덧셈 결과</h1>
<hr>





<% 
	// request.getParameter(String name) 의 반환형은 String이다.
	// primitive type에는 null못넣음
	// Integer.parseInt()는 인자로 null을 받아서 처리불가
	// 변수를 선언했을때 출력한다면, 분기문에 상관없이 값이 할당 되어 있어야한다.(변수의 초기화)
	// 제어문 내부에서 선언한 변수는 제어문 바깥에서 접근할 수 없다.(지역변수)
	// 함수 내부에서 선언한 변수는 함수 바깥에서 접근할 수 없다.(지역변수)
	
	
String n1 = request.getParameter("n1");
String n2 = request.getParameter("n2");

String result ="";
int num1, num2, sum = 0;

if(n1 != null && n2 != null && !"".equals(n1) && !"".equals(n2)){ //조건을 상세하게 걸던가 위에 태그에서 required를 걸어준다.
	/* result = String.format("%s + %s = %s", Integer.parseInt(n1),
				Integer.parseInt(n2),
				Integer.parseInt(n1) + Integer.parseInt(n2)); */
	num1 = Integer.parseInt(n1);
	num2 = Integer.parseInt(n2);
	sum = num1 + num2;
	
}

%>

<h3>코드의 순서와 상관없이 무조건 자바코드가 먼저 실행된다.</h3>
<h3>JAVA코드는 웹서버에서 실행되고 html은 클라이언트의 브라우저에서 실행되기 때문에 자바코드는 서버에서 먼저 처리된다.</h3>

<form>
	<input type="number" name="n1" placeholder="n1" min = "0" max="99">
	+
	<input type="number" name="n2" placeholder="n2" min = "0" max="99">
	<input type= "submit" value="=">
	<%= sum %>
</form>



</body>
</html>