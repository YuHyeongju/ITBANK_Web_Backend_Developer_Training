<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ex01 - 두 정수의 덧셈</h1>
<hr>

<input type="number" name="n1" min="0" max="20" placeholder="n1" >
+
<input type="number" name="n2" min="0" max="20" placeholder="n2" >
<button id="btn">=</button>
<span id="result"></span>

<script >

	const btn = document.getElementById('btn')
	const clickHandler = function(){
		const n1 = document.querySelector('input[name="n1"]').value
		const n2 = document.querySelector('input[name="n2"]').value
		const url = '${cpath}/ex01Ajax?n1=' + n1 +'&n2=' + n2
				
				fetch(url)
					.then(resp => resp.text())
					.then(text =>{ // 실행할 내용(응답 내용을 반환하면 된다.)
						const result = document.getElementById('result')
						result.innerText = text
					})
					
	}
	btn.onclick = clickHandler
</script>

<!-- 벡엔드가 작업을 했음에도 불구하고 페이지 전환이 일어나지 않았다. => 
	페이지 전환을 하지 않고도 벡엔드 적인 작업을 처리할 수 있다.
	사용자가 처리하는 작업을 방해하지않고 작업을 처리할 수  있다.
	이래서 AJAX를 사용한다. -->

</body>
</html>