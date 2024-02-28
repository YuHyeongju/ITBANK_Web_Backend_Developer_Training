const	longToDateString = function(num){
		const d = new Date(num)
		let yyyy = d.getFullYear()
		let mm = d.getMonth() + 1 
		let dd = d.getDate()
		
		if(mm < 10) mm = '0' + mm
		if(dd < 10) dd = '0' + dd
		return yyyy + '년' + mm + '월' +  dd + '일'		
}
const ipaddr = [
			'192.168.4.20',// 노트북 와이파이 ip
		 	//'192.168.112.19', // 강의실 컴퓨터 ip
		 	'192.168.112.30',
		 	'192.168.112.23',
		 	'192.168.112.21',
		 	'192.168.112.14'
		 ]
		 
const menuItemsHandler = (element,index) => {
		 // element.onclick = clickHandler1
		 		element.addEventListener('click',function(event) { // 이벤트 핸들러
			 
				 menuItems.forEach(menuItems => menuItems.classList.remove('selected'))
				 contentItems.forEach(contentItems => contentItems.classList.remove('selected'))
				 // event.target.classList.add('selected') 클릭된 자기자신만 가능
				 
				 // 같은 인덱스로 서로 다른 배열(nodeList)를 제어할 수 있게 됨.
				 menuItems[index].classList.add('selected')
				 contentItems[index].classList.add('selected')
				 
				 const url = 'http://' + ipaddr[index] + ':8080/day12/schedules'
				 fetch(url).then(resp => resp.json())
				 	.then(json =>{
				 		console.log(json)
				 		contentItems[index].innerHTML = ''
				 		let tag = ''
				 		tag += '	<table>'
				 		tag += '		<thead>'
				 		tag += '			<tr>'
				 		tag += '				<th>날짜</th>'
				 		tag += '				<th>메모</th>'
				 		tag += '			</tr>'
				 		tag += '		</thead>'
				 		tag += '	<tbody>'
				 		
				 		json.forEach(dto => {
				 			tag +='		<tr>'
				 			tag +='			<td>' +longToDateString(dto.sDate) +  '</td>'
				 			tag +='			<td>' +dto.memo +  '</td>'
				 			if(index == 0){
				 				tag += '<td><button class="delete" idx="' + dto.idx + '">삭제</button></td>'
				 			}
				 			tag +='		</tr>'
				 		})	
				 		
				 		tag +='		</tbody>'		
				 		tag +='		</table>'
				 		contentItems[index].innerHTML = tag
				 		
				 		if(index == 0){
				 			contentItems[index].querySelectorAll('.delete').forEach(e => e.onclick = event => {
				 				const idx = event.target.getAttribute('idx')
				 				
				 				fetch(url + '/' +  idx, {
				 					method: 'delete'
				 				}).then(resp => resp.text())
				 				.then(text => {
				 					if(text == 1){
				 						const de = new Event('click')
				 						document.querySelector('.menu > .item').dispatchEvent(de)
				 					}
				 				})
				 				
				 			})
				 		}
				 	})
		 
		 })// 이벤트 리스너
		 
}	 
	 
	 
	 
const submitHandler = event => {
			event.preventDefault() // 원래 버튼이 가지고 있는 기능을 막기
			const ob = {
					sDate: event.target.querySelector('input[name="sDate"]').value,
					memo: event.target.querySelector('input[name="memo"]').value,
			}
			const url = 'http://' + ipaddr[0] + ':8080/day12/schedules'
			const opt = {
					method : 'POST',
					body : JSON.stringify(ob),
					headers:{
						'Content-Type':'application/json; charset=utf-8'
					}
			}
			fetch(url, opt)
			.then(resp => resp.text())// 1, 0
			.then(text => {
					if(text == 1){
						// 이벤트 강제 발생 시키기
						const event = new Event('click')
						document.querySelector('.menu > .item').dispatchEvent(event)
						close.dispatchEvent(event)
					}
					else{
					 	alert('정상적으로 등록하지 못했습니다.')
					 	// document.querySelector('input').focus()
					 	document.querySelector('input').select()
					}
			})
	}	

	 	 