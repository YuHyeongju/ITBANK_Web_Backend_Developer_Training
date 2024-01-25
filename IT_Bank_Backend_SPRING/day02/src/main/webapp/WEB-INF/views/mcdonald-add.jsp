<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mcdonald-add.jsp</title>
</head>
<body>
	<form method="POST">
		<h1>항목추가</h1>
		<div>
			<p>
				<label><input type="radio" name="category" value="버거"
					required>버거</label> <label><input type="radio"
					name="category" value="음료" required>음료</label>
			</p>
			<p>
				<input type="text" name="name" placeholder="상품이름" required>
			</p>
			<p>
				<input type="number" name="price" placeholder="상품 가격" required>
			</p>
			<p>
				<input type="text" name="imgname" placeholder="그림 파일 이름" required>
			</p>
			<p>
				<textarea name="memo" placeholder="상세 설명" required></textarea>
			</p>
			<p>
				<input type="submit">
			</p>
		</div>
		
	</form>
	<div><a href="${cpath }"><button>목록으로 이동</button></a></div>
</body>
</html>