<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 추가</title>
</head>
<body>

<section>
	<h3>상품 추가</h3>
	<form method="POST" enctype="multipart/form-data">
		<p><input type="text" name="name" placeholder="등록할 상품이름 입력" required autofocus></p>
		<p><input type="file" name="upload" placeholder="그림 이름 입력" required></p>
		<p><input type="number" name="price" placeholder="가격 입력" required></p>
		<p><input type="number" name="count" placeholder="수량 입력" required></p>
		<input type="submit" value="상품 추가">
	</form>



</section>


</body>
</html>