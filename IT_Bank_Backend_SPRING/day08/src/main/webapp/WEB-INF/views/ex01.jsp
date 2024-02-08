<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>두 정수의 사칙 연산</h1>
<hr>

<form method="POST">
	<p>
		<input type="number" name="n1" min="0" max="100" required autofocus>
		<select name="operator">
			<option value="">== 연산자 선택 ==</option> <!-- value값이 없기 떄문에 선택 안 한 것으로 간주함 -->
			<option value="PLUS">+</option>  <!-- 보여지는건 기호지만 실제로 전달되는 값은 value안에 있는 값이다. -->
			<option value="MINUS">-</option>
			<option value="MULTI">*</option>
			<option value="DIVIDE">/</option>
		</select>
		<input type="number" name="n2" min="0" max ="100" required autofocus>
		<input type="submit" value="=">
	
	
	</p>

</form>
</body>
</html>