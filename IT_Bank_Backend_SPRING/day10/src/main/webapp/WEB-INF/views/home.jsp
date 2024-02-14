<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border-collapse: collapse;
	border: 1px solid black;
}
td{
	padding: 5px 10px;
	border: 1px solid grey;
}
</style>
</head>
<body>
<h1>day10</h1>
<hr>

	<ul>
		<li><a href="ex01">ex01 - ajax(1, 정수 반환)</a></li>
		<li><a href="ex02">ex02 - ajax(2, 문자열 반환)</a></li>
		<li><a href="ex03">ex03 - ajax(3, Map 반환)</a></li>
		<li><a href="ex04">ex04 - ajax(4, List&lt;DTO>반환)</a></li>
	</ul>

	<div id="root"></div> <!-- 스크립트에서 테이블을 구현하여 div태그 안에 넣어 주었다. -->
	
	
	<script>
	 let url = 'https://apis.data.go.kr/6260000/BusanRainfalldepthInfoService/getRainfallInfo'
	 
	 const param = {
			 serviceKey: 'IR2BW6s721w4X5%2Faw2H9BbrtrUf4BoBG7Wvh7YN5J17Xyx3DymV6mk%2FI%2Fvpcj8ezYB7iYXafiG0KABUcoEjtjA%3D%3D',
			 pageNo: '1',
			 numOfRows: '25',
			 resultType: 'json',	 
	 }
	 
	 url +='?'
	 for(let key in param){
		 url += key + '=' + param[key] + '&' 
	 }	
	 
	 // https://apis.data.go.kr/6260000/BusanRainfalldepthInfoService/getRainfallInfo?서비스키 :...,페이지넘버: 1, 줄수: ...
	 //		 ,결과타입: .... 이렇게 한문장을 만들어서 다른 서버에게 전달 
	 
	 
	 // fetch: 요청 (text파일을 반환받는 것이 아니라 json형식의 데이터를 요청하고 데이터를 받음)
	 
	 				fetch(url)							// 지정한 주소로 요청을 보낸다
	 					.then(resp => resp.json())		// 요청이후 돌아오는 응답을 JSON 객체로 변환한다.
	 					.then(json => {					// 변환된 JSON객체를 이용하여, {} 블럭 내부 코드 수행
	 						// console.log(json.getRainFallInfo.body.items.item)
	 						const arr = json.getRainfallInfo.body.items.item.map(e => {
	 							const ob = {}
	 							ob.clientName = e.clientName
	 							ob.level6 = e.level6
	 							return ob
	 						})
	 						// console.log(arr)
	 						const tr1 = document.createElement('tr')  // 지역이름을 배치할 첫번째 줄
	 						const tr2 = document.createElement('tr')  // level6의 값을 배치할 두번째 줄
	 						
	 						for(let i in arr){ // arr 배열안에 
	 							const td1 = document.createElement('td') // td라는 객체를 만들어서 td1에 넣었다.
	 							td1.innerText = arr[i].clientName //clientName의 내용을 td1에 text형태로 집어넣기
	 							tr1.appendChild(td1) // 자식요소 추가, tr1 > td1
	 							
	 							const td2 = document.createElement('td') // td라는 객체를 만들어서 td2에 넣었다.
	 							td2.innerText = arr[i].level6			 //level6의 내용을 td2에 text형태로 집어넣기
	 							tr2.appendChild(td2)					// 자식요소 추가, tr2 > td2
	 						}
	 						const table = document.createElement('table')
	 						table.appendChild(tr1)
	 						table.appendChild(tr2)
	 						
	 						const root = document.getElementById('root')
	 						root.appendChild(table)
	 						
	 					})				
	</script>


</body>
</html>