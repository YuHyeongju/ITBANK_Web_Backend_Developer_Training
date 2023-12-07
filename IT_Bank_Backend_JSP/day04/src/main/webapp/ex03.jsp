<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
<style>
#root {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: #f5f6f7;
	display: flex;
	flex-flow: column;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>


	<div id="root">
		<h3>Page Not Found</h3>
		<img src="image/흰둥이.png">
		<h3>잘못된 주소입네다.</h3>
	</div>
	<%-- ex02의 에러처리와 ex03의 차이 
	
		ex02에서는 특정페이지의 에러에 대해서만 에러를 처리하지만
		ex03에서는 day04전체에서의 에러가 났을때 이동할 경로를 지정
	 --%>

</body>
</html>