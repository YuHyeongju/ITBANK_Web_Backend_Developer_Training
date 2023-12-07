<%@page import="ex06.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex07-show.jsp</title>
</head>
<body>
	<h1>ex07-action에서 선택한 값 출력</h1>
	<hr>
	
	<img src="<%=((MemberDTO)request.getAttribute("dto")).getImgPath() %>" height="150">
	
	<img src="${requestScope.dto.imgPath }" height="150">
	<img src="${dto.imgPath }" height="150">
	<%-- EL태그는 내장객체에서 Attribute를 꺼내서 출력하기위해 사용함. --%>
	<%-- 
		 getAttribute의 반환형은 Object이고,
	     getParameter의 반환형은 String이다. 
	     
	     getAttribute의 반환형이 Object형이기 때문에 값을 가져올려면 형 변환이 필요하다. 
	     
	--%>
	
	<h3>이름: ${dto.name }</h3>
</body>
</html>