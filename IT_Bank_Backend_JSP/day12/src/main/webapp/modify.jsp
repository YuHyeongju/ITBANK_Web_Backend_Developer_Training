<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify.jsp</title>
</head>
<body>
	<form action="modify-action.jsp">
		<p><input type ="password" name="userpw" placeholder="수정할 비밀번호 입력" required>${dto.userpw }</p>
		<p><input type = "text" name = "userName" 	placeholder = "수정할 이름 입력" required>${dto.userName }</p>
		<p>
			<label><input type = "radio" name ="gender" value = "1" ${dto.gender == 1? 'checked':'' } required>남성</label>
			<label><input type = "radio" name ="gender" value = "0" ${dto.gender == 0? 'checked':'' } required>여성</label>
		</p>
		<p><input type="email" name="email"  placeholder="수정할 이메일 입력"></p>
		<p><input type="submit" value="수정하기"></p>
	</form>
</body>
</html>