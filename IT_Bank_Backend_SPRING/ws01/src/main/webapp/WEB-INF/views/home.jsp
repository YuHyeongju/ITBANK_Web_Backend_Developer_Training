<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set  var="cpath"  value="${pageContext.request.contextPath }"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ws01</title>
<style>
	#notepad{
		box-sizing: border-box;
		width: 700px;
		height: 400px;
		padding: 10px;
		margin: 10px 0;
		border: 2px solid black;
		font-size: 17px;
		overflow-y: auto; 
	}
	
	form > p{
		box-sizing: border-box;
		width: 700px;
		display: flex;
		justify-content: space-between;
		
		
	}
	
	input[name="input"]{
		padding:5px;
		font-size: 20px;
		flex: 5;
		margin-left: 5px;
	}
	input[name="submit"]{
		
		flex: 1;
		
	}
	
</style>
<!-- 
	ws(웹소켓): 브라우저와 서버간의 연결을 유지한 상태에서 양방향 소통이 가능하게하는 기술
	-> 상호간의 실시간 데이터 교환이 가능한 환경을 구축할 수 있음.
	http: 브라우저가 서버에 요청을 보내면 서버가 응답하여 데이터 통신
	
	웹소켓은 서버가 브라우저에 데이터를 보내고 그에 따른 응답을 브라우저로 부터 받아오는 것도 가능함. 
 -->
<!-- Contents Delivery Network (cdn): 게임 클라이언트나 콘텐츠를 효율적으로 전달하기 위해 여러 노드를 가진 네트워크에 데이터를 저장해 사용자에게 제공하는 시스템 -->
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
</head>
<body>
<h1>webSocket을 이용한 메모장(sockJS)</h1>
<hr>
<div id="notepad"></div>

<form>
	<p>
		<input type="text" name="input" placeholder="글을 입력하세요">
		<input type="submit"> 
	</p>
</form>

<script >
	const cpath = '${cpath}'
	const form = document.forms[0]
	const ws = new SockJS(cpath + '/chat') // 웹 소켓을 열려고 시도 -> 새로고침 할 때 마다 연결을 생성함.
	const notepad = document.getElementById('notepad')
	
	
	
	
	// 함수정의
	 function messageHandler(event){
		notepad.innerHTML += '<p>' + event.data + '</p>'
		notepad.scroll({
			top: notepad.scrollHeight,
			behaivior:'smooth',
		})
	}
	
	function submitHandler(event){
		event.preventDefault()
		const input  = event.target.querySelector('input[name="input"]')
		
		ws.send(input.value)
		input.value = ''
		input.focus()
	}

	// 이번트 연결
	ws.onmessage  = messageHandler
	ws.onopen = function(msg){}
	ws.onclose = function(msg){}
	ws.onerror = function(msg){}
	form.onsubmit = submitHandler

</script>

</body>
</html>