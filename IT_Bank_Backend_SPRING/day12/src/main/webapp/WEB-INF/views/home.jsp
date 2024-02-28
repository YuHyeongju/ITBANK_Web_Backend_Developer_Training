<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${cpath }/resources/css/style.css">
<script src="${cpath }/resources/js/script.js"></script>
</head>
<body>
	<h1>day12</h1>
	<hr>

	<div id="modal" class="hidden">
		<div class="content">
			<form id="addForm">
				<h3>일정 추가하기</h3>
				<p>
					<input type="date" name="sDate" required>
				</p>
				<p>
					<input type="text" name="memo" placeholder="메모하셈" required>
				</p>
				<input type="submit" value="등록"> <span>
				<input id="close" type="button" value="돌아가기"></span>

			</form>
		</div>
		<div class="overlay"></div>
	</div>

	<div class="buttons">
		<button id="open">일정 추가</button>
	</div>



	<div id="root">
		<div class="menu">
			<div class="item">형주</div>
			<div class="item">원지</div>
			<div class="item">승호</div>
			<div class="item">민서</div>
			<div class="item">재영</div>
		</div>
		<div class="content">
			<div class="item">1</div>
			<div class="item">2</div>
			<div class="item">3</div>
			<div class="item">4</div>
			<div class="item">5</div>
		</div>
	</div>






	<script>
		// 데이터 불러오기
		
	
		// 이벤트 대상
	 const menuItems = document.querySelectorAll('.menu > .item')
	 const contentItems = document.querySelectorAll('.content > .item')
	
	 menuItems.forEach(menuItemsHandler)
	 // CORS: cross origin resource sharing: 교차 출처 자원 공유 
	 // 서로 다른 출처에서 온 자원을 공유하는 것을 막아놓음
	 // -> 내가 나의것을 가져오는건 상관없는데 남의 것을 들고 오면 보안 정책상 위배된다.
	 // ip 주소를 기준으로 내꺼 남에 꺼를 구분한다.
</script>
	
	<script>
		const modal = document.getElementById('modal')
		const open = document.getElementById('open')
		const close = document.getElementById('close')
		const overlay = document.querySelector('#modal > .overlay')
		const addForm = document.getElementById('addForm')
		
		open.onclick = event => modal.classList.remove('hidden')
		
		close.onclick = event => modal.classList.add('hidden')
		
		overlay.onclick = event => modal.classList.add('hidden') // 모달 바깥을 클릭하면 닫기
		
		addForm.onsubmit = submitHandler
		
		window.onload = e =>{
			const event = new Event('click')
			document.querySelector('.menu > .item').dispatchEvent(event)// 처음부터 데이터가 불러와져있다. 원래 눌러야했다.
		}	
	</script>
	<!-- 싱글페이지 아키텍쳐: 단일페이지에서 추가 삭제 등이 이루어진다.
		restful server: 간단한 crud를 해주는 서버  -->
</body>
</html>