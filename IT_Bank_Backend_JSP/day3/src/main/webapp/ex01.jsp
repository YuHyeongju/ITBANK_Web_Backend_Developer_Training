<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>
</head>
<body>
	<h1>파라미터 입력을 활용한 업다운 게임 구현하기</h1>
	<hr>

	<%@page import="java.util.Random"%>
	
	<%!
		private Random ran = new Random(); // 매번 새로 생성할 필요가 없기떄문에 선언부에 씀
		private int count = 0;			   // 진행하는 동안 횟수가 유지되어야하기 때문에 선언부에 작성
		private int cpu = ran.nextInt(100) + 1;	 // 입력마다 값이 바뀌면 안되기 때문에 선언부에 작성(유지되어야한다.)
		
		// String test = request; // 안됨, 스크립틀릿 안에서만 접근이 가능함. 선언부에서는 request, response에 접근 불가
	
	%>
	
	<%
	
	if(request.getParameter("reset") != null ){
		count = 0;
		cpu = ran.nextInt(100) + 1; // cpu의 값을 랜덤으로 할당
	}
	
	
	String input = request.getParameter("user");  // 입력값은 매번 새로 바뀜.
	int user;									  // 사용자 입력값은 매번 변경되기도하고, request로 받아와야 함. 
	String msg="";
	
	if(input != null ){
		count++;
		user = Integer.parseInt(input);
		if(user == cpu){
			msg = String.format("정답. %d회만에 정답을 맟춤",count);
		}else if(user < cpu){
			msg = String.format("UP(%d회 도전중)", count);
		}else{ // if(user > cpu)
			msg = String.format("DOWN(%d회 도전중)", count);
		}
	}
	// while문이 없다 : 프로그램을 사용자가 입력할 때 마다 매번 새로 실행하는 구조이기때문에 반복을 돌릴 필요가 없다.
	// 실행할 동안 유지 되어야할 값은 선언부에 작성해주고 나머지는 스크립틀릿에 작성해준다.
	%>

	<form>

		<p>
			<input type="number" name="user" min="1" max="100" required autofocus>
			<input type="submit">
			<a href = "ex01.jsp?reset = true"><input type="button" name = "reset" value="다시"></a> <%--파라미터 추가 --%>
	</form>
	<form>
	
	
		<h3><%=msg %></h3>
	
	</form>
</body>
</html>