<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="header.jsp" %>    
<h3>Ajax로 메일 보내기</h3>
<hr>

<div class="mailSend box">
	<form>
		<h3>인증번호 발송</h3>
		<p><input type="email" name="address" placeholder="email"></p>
		<button>인증번호 보내기</button>
		<p class="message"></p>
	</form>
</div>


<div class="auth box hidden">
	<form>
		<h3>인증번호 확인</h3>
		<p>
			<input type="text" name="authNumber" placeholder="인증번호를 입력하소">
			<button>인증 확인하기</button>
				
		</p>
		<p class="message"></p>
	</form>
</div>

<script>
	const mailSendForm = document.forms[0]
	const authForm = document.forms[1]
	
	mailSendForm.onsubmit = async function(event){
		event.preventDefault()
		const url = '${cpath}/ajax/sendMail'
		const opt = {
				method:'POST',
				body: JSON.stringify({
					address: event.target.querySelector('input').value
					
				}),
				headers: {
					
					'Content-Type': 'application/json;charset=utf-8'
				} //  plain/text 단순 텍스트
					//application/json json형식의 객체
		}
		const result = await fetch(url,opt).then(resp=>resp.text())
		const message = event.target.querySelector('p.message')
		if(result == 1){
			
			message.innerText = '메일을 전송했습니다.'
			message.style.color = 'blue'	
			
			document.querySelector('.auth').classList.remove('hidden')
		}else{
			message.innerText = '메일을 보낼수 없습니다.'
				message.style.color = 'red'	
		}
	}
	
	authForm.onsubmit = async function(event){
		event.preventDefault()  // 기본 작동 막기
		const InputNumber = event.target.querySelector('input').value // 인증확인하기에 입력한 값을 가져와서
		const url = '${cpath}/ajax/authNumber/' + InputNumber
		const result = await fetch(url).then(resp => resp.text())
		const message = event.target.querySelector('p.message') 
		
		if(result == 1){
			message.innerText = '인증 성공'
			message.style.color = 'blue'
		}else{
			
			message.innerText = '인증 실패'
			message.style.color = 'red'
		}
	}
</script>



</body>
</html>