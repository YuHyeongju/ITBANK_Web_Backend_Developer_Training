<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify.jsp</title>
</head>
<body>

	<c:set var="dto" value="${dao.selectOne(param.userid)}"/>
	
<section>
	<h3>${param.userid }의 정보 수정</h3>
	<form action="modify-action.jsp" method="POST">
		<p>
			<input type="text" name="userid" value="${dto.userid}" readonly/>
		</p>
		<p>
			<input type="password" name="userpw" placeholder="비밀번호 입력" value="${dto.userpw }" required autofocus>
		</p>
		<p>
			<input type="text" name="userName" placeholder="이름 입력" value="${dto.userName }" required>
		</p>
		<p>
			<label><input type="radio" name="gender" value="남성" ${dto.gender == '남성'? 'checked' : '' } required>남자</label>
			<label><input type="radio" name="gender" value="여성" ${dto.gender == '여성'? 'checked' : '' } required>여자</label>
		</p>
		<p>
			<input type="email" name="email" placeholder="이메일 입력" value="${dto.email }"required>
		</p>
		<p>
		
			<input type="submit" value="수정">
			<a href="${cpath }/list.jsp">목록</a>
		</p>
		
	</form>

</section>	
	
</body>
</html>