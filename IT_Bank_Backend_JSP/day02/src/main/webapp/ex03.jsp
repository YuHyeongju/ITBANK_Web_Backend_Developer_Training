<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
</head>
<body>
	<h1>파라미터를 활용한 처리</h1>
	<hr>

	<form>
		<p>
			<input type="text" name="name" placeholder="이름" required autofocus>
		</p>
		<p>
			<input type="number" name="age" min="0" max="100" placeholder="나이"
				required>
		</p>
		<p>
			<input type="submit"> <a href="<%=request.getRequestURL()%>">
				<input type="button" value="초기화"></a>

		</p>
		
		<%--데이터와 함께 보내고싶다.  p태그
			새로운 링크만 : a태그 --%>

		<%
		String name = request.getParameter("name");
		String age = request.getParameter("age"); // 파일을 제외한 나머지 유형은 String으로 받으면 된다.
		String msg = "";

		if (name != null) {
			String adult = Integer.parseInt(age) >= 20 ? "성인" : "미성년자";
			msg = String.format("%s님의 나이는 %s살이고, %s입니다.", name, age, adult);
		}
		%>
		<h3><%=msg%></h3>

	</form>
</body>
</html>