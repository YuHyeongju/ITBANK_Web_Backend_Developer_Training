function itemListClickHandler(event) {	// 이벤트 핸들러
	document.querySelectorAll('.menu > .item').forEach(item => {
	item.classList.remove('selected')
	})
		event.target.classList.add('selected')

}

function getDateStringFromLong(sDate){
	const date =  new Date(sDate)
	const days = ['일','월','화','수','목','금','토']
	let yyyy = date.getFullYear()
	let mm = date.getMonth() + 1 
	let dd = date.getDate()
	let day = date.getDay()
	
	
	if(mm < 10) mm = '0' + mm
	if(dd < 10) dd = '0' + dd

	// return yyyy + '년' + mm + '월' + dd + '일' + day +'요일'
	return `${yyyy}년 ${mm}월 ${dd}일 ${days[day]}요일` 
	

}


function getHTMLfromJson(json){
	let tag = ''
	tag +=`<table>`
	tag +=`		<thead>`
	tag +=`			<tr>`
	tag +=`				<th>번호</th>`
	tag +=`				<th>날짜</th>`
	tag +=`				<th>내용</th>`
	tag +=`				<th>삭제</th>`
	tag +=`			</tr>`
	tag +=`		</thead>`
	tag +=`		<tbody>`
	json.forEach(dto => {
		tag +=`<tr>`
	tag +=`		<td>${dto.idx}</td>`
	tag +=`		<td>${getDateStringFromLong(dto.sDate)}</td>`
	tag +=`		<td>${dto.memo}</td>`
	tag +=`		<td><button class="delete" idx = ${dto.idx}>삭제</button></td>`
	tag +=`</tr>`
	})
	tag += `	</tbody>`
	tag += `</table>`
	return tag  
}
// 백틱을 사용하면 문자열 안에서 자바스크립트 변수를 넣을수 있다. 넣을 수 없다면 '<div>'+ dto.idx + '</div>'
// 이렇게써야함
// 단 jsp에서는 백틱 문법이 EL태그 문법과 겹쳐서 못쓴다.


async function menuClickHandler(event){
			// 0) 반복문의 인덱스 대신, 이벤트 대상이 menu > item의 몇 번 째인지 찾아낸다.
	const arr = Array.from(document.querySelectorAll('.menu > .item'))
	const index = arr.indexOf(event.target) // 클릭한 아이템을 가리킴
	
	
	
	// 1) 어떤 주소로 요청을 보낼 것인가 결정
	const url = urls[index]
	console.log(url)
	const opt = {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json;charset=utf-8',
			
		}
	}

	// 2) 주소로 요청하여 json데이터를 받아온다.
	const json = await fetch(url).then(resp => resp.json())
	// 3) 받아온 json을 HTML 태그 문자열로 변환한다.
	const tag = getHTMLfromJson(json)
			/*
			 * .then(json =>{ return json // 반환을 하면 프로미스 타입으로 묶여서 반환 // 프로미스는 원본
			 * 데이터를 당장 가져갈 수 없다. // 프로미스는 서약서 같은거라서 await를 걸면 서약서에 // 작성된 내용을
			 * 끝내기 전까지는 실행할 수 없다. // 함수별로 작업이 분리되기 때문에 모듈화 할 수 있다. })
			 */
	/*
	 * console.log(json) console.log(tag)
	 */
	
	// 4) 태그를 삽입할 HTMLElement를 찾아서 태그를 넣는다.
	const content = document.querySelector('#root > .content')
			content.innerHTML = tag
			
	const deleteList = document.querySelectorAll('.delete')
	deleteList.forEach(e => e.onclick = deleteHandler)
	
}
		
async function submitHandler(event){
		event.preventDefault()
		
		const ob = {
			sDate : event.target.querySelector('input[name="sDate"]').value,
			memo : event.target.querySelector('input[name="memo"]').value	
		}

		const url = cpath + '/schedules'
		
		const opt = {
				method:'POST',
				body:JSON.stringify(ob),
				headers:{
					'Content-Type':'application/json; charset = utf-8'
				}
		}

		const result =	await fetch(url,opt).then(resp => resp.text())
						
		if(result == 1){
			document.querySelector('.menu > .item').dispatchEvent(new Event('click'))
		}else{
			alert('등록 실패')
			document.querySelector('input').select
		}
		
		
		document.getElementById('close').dispatchEvent(new Event('click'))
		
}

function deleteHandler(event){
	
		const idx = event.target.getAttribute('idx')
		const deleteUrl = cpath +'/schedules/'+ idx
		
		fetch(deleteUrl,{
			method:'DELETE',
			headers:{
				'Content-Type':'application/json; charset = utf-8'
			}
				
		})
		.then(resp => resp.text())
		.then(text =>{
			if(text == 1){
				const ce = new Event('click')
				document.querySelector('.menu > .item').dispatchEvent(event)
			}else{
				alert('삭제 실패')
			}
		})
		
	
}




 