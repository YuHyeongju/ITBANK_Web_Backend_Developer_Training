<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${cpath }/resources/css/style.css">
<script src="${cpath }/resources/js/function.js"></script>

<script>
	// HTML 문서를 불러오지 않아도 설정할 수 있는 전역 변수 및 함수 정의(document.querySelectorAll,getElementById 이런거 안쓴다.)
	// 위에 있는 것이 조금이라도 불러오는 것이 빠르다.
	
	/* function itemListClickHandler(event) {	//이벤트 핸들러
		document.querySelectorAll('.menu > .item').forEach(item => {
			item.classList.remove('selected')
		})
			event.target.classList.add('selected')
	
	}
	
	function itemListForEachCallback(e){
		// e.onclick = itemListClickHandler 
		// 
		
		
		e.addEventListener('click', itemListClickHandler) 
		// 추가, 여러 이벤트 핸들러를 지정할 수 있다.
	}  
	function getHTMLfromJson(json){
		return  ''  // 문자열을 tag에 전달
	} */
	
	
	
	
	// itemList.forEach(itemListForEachCallback) itemList가 없어서 실행 불가
	// 그러면 불러오면 되지 않나?
	//	const itemList = document.querySelectorAll('.menu > .item')  
	// 이 코드를 불러오는시점에 html코드를 불러오지 못했기 때문에 실행 불가
	// html의 위치보다 스크립트의 위치가 더 위에 있기 때문에 먼저 실행됨.
	

	const cpath = '${cpath}'

	const urls = [
				'http://192.168.23.1:8080/day13/schedules', 
				//'http://192.168.112.19:8080/day13/schedules',
				'http://192.168.112.30:8080/day13/schedules',
				'http://192.168.112.23:8080/day13/schedules',
				'http://192.168.112.21:8080/day13/schedules',
				'http://192.168.112.14:8080/day13/schedules',
				 // 스크립트는 마지막에 쉼표 사용 가능
			]
	
</script>
</head>
<body>
	<h1>day13</h1>
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
				<input type="submit" value="등록"> <span> <input
					id="close" type="button" value="돌아가기"></span>
				<!-- 
					id를 지정한 HTML요소는 getElementById로 불러오지 않아도 참조 가능 
					단 권장하진 않는다.
				-->

			</form>
		</div>
		<div class="overlay"></div>
	</div>

	<div class="buttons">
		<button id="open">일정 추가</button>
	</div>



	<div id="root">
		<div class="menu">
			<div class="item selected">형주</div>
			<div class="item">원지</div>
			<div class="item">승호</div>
			<div class="item">민서</div>
			<div class="item">재영</div>
		</div>
		<div class="content">
			<img src="${cpath }/resources/image/earth-turn.gif" height="200px"
				style="border-radius: 100px;">
		</div>
	</div>

	<script>
	// html코드에서 만든 것을 가져다가 스크립트를 실행
	//const itemList = document.querySelectorAll('.menu > .item')  //이벤트 대상
	
	// const itemListForEachCallback = e => e.onclick = itemListClickHandler
	
	
	
	/* const itemListClickHandler = e => event => {	//이벤트 핸들러
			itemList.forEach(item => item.classList.remove('selected'))
			event.target.classList.add('selected')
	} */
	
	// itemList.forEach(itemListForEachCallback)
	
	// 문서가 모두 불러지면 특정 요소를 호출하여 이벤트를 연결하는 함수
	function loadHandler(){
		// 상단 메뉴를 클릭 했을 때 스타일 옮겨가는 함수 
		const itemList = document.querySelectorAll('.menu > .item')
		itemList.forEach(e => e.addEventListener('click', itemListClickHandler))
		
		//상단 메뉴를 클릭했을 때 fetch로 데이터를 불러와서 #root > .content에 내용 띄우기 
		itemList.forEach(element => element.addEventListener('click', menuClickHandler)
			 // 데이터를 불러왔으니 json 데이터를 html 데이터로 변경해서 화면에 띄우는 작업을 한다.
		)
		
		
		// 열기 / 닫기 버튼에 모달 작동 연결하기
		//const modal = document.getElementById('modal')
		const btns = [
				document.getElementById('open'),
				document.getElementById('close'),
				document.querySelector('.overlay'),
			]
		btns.forEach(b => b.onclick = event => modal.classList.toggle('hidden'))
		
		
		// form을 제출하면 자신의 서버에 POST로 등록하기
		const form = document.forms[0] // 첫번째 폼
		form.onsubmit = submitHandler
		 /* function submitHandler(event){
			event.preventDefault()
			
			const ob = {
				sDate : event.target.querySelector('input[name="sDate"]').value,
				memo : event.target.querySelector('input[name="memo"]').value	
			}
			
			const url = `${cpath}/schedules`
			
			const opt = {
					method:'POST',
					body:JSON.stringify(ob),
					headers:{
						'Content-Type':'application/json; charset = utf-8'
					}
			}
					fetch(url,opt) // async await를 안쓰면 .then을 남발한다.
						.then(resp => resp.text())
						.then(text => {
							if(text == 1){
								
								document.querySelector('.menu > .item').dispatchEvent(new Event('click'))
							}else{
								alert('등록 실패')
								document.querySelector('input').select
							}
							
					})
							document.getElementById('close').dispatchEvent(new Event('click'))
					
					
			}
			
			*/
			
		} 
		
		// 있던거 js 파일로 이사감
	
	
	window.addEventListener('DOMContentLoaded', loadHandler)
	// DOMContent: 문서를 불어온 이후
	// 문서를 불어온 이후에 실행해야되니까 이 코드를 사용한다.
	
	/* async function deleteSchedule(idx){
		const response = await fetch(`${cpath}/schedules/${idx}`, {
			method:'DELETE',
		})
		const schedule = await response.json()
		console.log(schedule)
	}
	
	const deleteBtns = document.querySelectorAll('.delete')
	deleteBtns.forEach(btn => {
		btn.addEventListener('click', async(event) => {
			const idx = event.target.getAttribute('idx')
			await deleteSchedule(idx)
		})
	}) */
	
	
</script>
</body>
</html>