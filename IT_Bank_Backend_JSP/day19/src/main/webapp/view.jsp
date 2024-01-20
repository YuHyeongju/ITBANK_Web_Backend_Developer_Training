<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<h2 style="display: flex; justify-content: center;">글 상세 보기</h2>
<section>
	<table class="view_table" border="1" cellpadding="0" cellspacing="10"
		style="border: 1px solid red; width: 900px; height: 600px; margin: auto auto; border-collapse: collapse;">
		<c:set var="row" value="${board2DAO.updateViewCount(param.idx) }" />
		<c:set var="dto" value="${board2DAO.selectOne(param.idx) }" />
		<tr>
			<td>글 번호:${dto.idx }</td>
		</tr>
		<tr>
			<td>글 제목:${dto.title }</td>
		</tr>
		<tr>
			<td>조회수:${dto.viewCount }</td>
		</tr>
		<tr>
			<td>작성자: ${dto.writer }</td>
		</tr>
		<tr>
			<td>작성일:${dto.writeDate }</td>
		</tr>
		<tr>
			<td>작성자 ip:${dto.ipaddr }</td>
		</tr>
		<tr>
			<td>작성일자:<fmt:formatDate value="${dto.writeDate }"
					pattern="yyyy년 MM월 dd일 a hh시 mm분" />
			</td>
		</tr>
		<tr>
			<td><c:if test="${!empty dto.image }">
					<img src="${cpath }/reviewImage/${dto.image}"
						style="width: 100px; height: 100px;">
				</c:if> <c:if test="${empty dto.image }">
					<img src="${cpath }/reviewImage/default.png"
						style="width: 100px; height: 100px;">
				</c:if></td>
		</tr>
		<tr>
			<td>내용:${dto.content }</td>
		</tr>
	</table>
</section>
<div style="width: 900px; margin: 0 auto; padding: 10px; display: flex;">
	<div style="padding-right: 10px;">
		<a href="index.jsp"><button>목록</button></a>
	</div>
	<div>
		<c:if test="${dto.writer == login.userid }">
			<a href="${cpath }/modify.jsp?idx=${dto.idx}"><button>수정</button></a>

			<a class="deleteBtn" href="${cpath }/delete.jsp?idx=${dto.idx}"><button>삭제</button></a>
		</c:if>
	</div>

</div>
<div>
	<div id="reply" style="width:900px; margin:0 auto;">
		<div id="replyWrite">
			<form method="POST" id="replyWriteForm" style="border: 2px solid black; padding:10px;">
				<textarea name="content" rows="5" cols="80" required></textarea>
				<input type="hidden" name="writer" value="${login.userid }"> <input
					type="hidden" name="board_idx" value=${dto.idx }> <input
					type="hidden" name="parent_idx" value="0"> 
					<input type="hidden" name="reply_depth" value="0"> 
					<input type="submit" value="댓글등록">
			</form>
			<c:if test="${pageContext.request.method =='POST' }">
				<jsp:useBean id="reply" class="board2.ReplyDTO" />
				<jsp:setProperty property="*" name="reply" />
				<c:set var="row" value="${board2DAO.insertReply(reply) }" />
				<c:redirect url="/view.jsp?idx=${dto.idx }" />
			</c:if>
		</div>
		
		<div><hr style="border: 2px dashed red;"></div>
		<div id="replyList" style="border: 2px solid black; padding:10px;">
			<c:forEach var="reply" items="${board2DAO.selectReplyList(param.idx) }">
				<div class="replyItem" idx="${reply.idx }" reply_depth = "${reply.reply_depth }" 
				style="border:1px solid black;
				padding:10px;
				margin: -1px;
				margin-left:${reply.reply_depth * 30}px">
					<p>${reply.writer }</p>
					<pre>${reply.content }</pre>
					<button class="replyBtn" style="margin-bottom:10px;">답글달기</button>
				</div>
			
			</c:forEach>
			
		
		</div>
	</div>
	
</div>
<script>
	const replyBtnList = document.querySelectorAll('button.replyBtn')
	const replyBtnHandler = function(){
		const form  = document.getElementById('replyWriteForm')
		const reply	= event.target.parentNode
		
		form.querySelector('input[name="parent_idx"]').value = reply.getAttribute('idx')
		form.querySelector('input[name="reply_depth"]').value = +reply.getAttribute('reply_depth') + 1
		
		
		//document.querySelectorAll('.replyItem').forEach(e => e.style.border = 0)
		reply.style.border = '2px solid skyblue'
		reply.appendChild(form)
		form.querySelector('textarea').focus()
	}

	replyBtnList.forEach(e => e.onclick = replyBtnHandler)
	
	const replyItemList = document.querySelectorAll('div.replyItem')
	replyItemList.forEach((div, index) => {
		const depth= div.getAttribute('reply_depth')
		if(depth == 0){
			div.style.marginTop = '10px'
			div.style.background = '#eee'
		}
		else if(index != 0){
			const prevDiv = replyItemList[index - 1]
			const prevDepth = prevDiv.getAttribute('reply_depth')
			if(depth - prevDepth == 1){
				const line = document.createElement('div')
				line.innerText ='└─'
				div.style.position = 'relative'
				line.style.position = 'absolute'
				line.style.top = '0'
				line.style.left = '-35px'
				div.appendChild(line)
			}
		}
	})

</script>




<script>
	//문서 전체에서  a태그 중에서  클래스 이름이 deleteBtn인 모든 요소를 nodeList형태로 불러온다.
	const deleteBtnList = document.querySelectorAll('a.deleteBtn') 
	// const : 상수 - final의 성격을 띤다.
	// 이벤트 함수를 정의함.
	const deleteHandler = function(event){
		event.preventDefault() // a.태그의 기본 동작을 막는다.
		let target = event.target	// 이번트 대상을 target에 저장.
		// let: 값을 변경해야할때 사용한다. 
		
		// 클릭된 요소의 클래스에 deleteBtn이 포함되어 있지 않다면 반복을 수행한다.
		while(target.classList.contains('deleteBtn') == false){
			target = target.parentNode// 현재 target의 상위 요소(부모노드)를 target에 저장한다.
		}
		// console.log(target)
		const idx = target.getAttribute('idx') // target의 idx 저장
		const url = target.href// target의 href를 저장한다.
		const flag = confirm(idx + '번 게시글을 삭제 하시겠습네까?') // 사용자에게 묻기
		if(flag){
			location.href = url //브라우저의 주소창을  <a href="">의 값으로 변경한다.(페이지이동)
								// 우리가 주소창에 주소를 쳐서 이동하는 것과 동일하다.
		}
		
	}
	// deleteBtnList의 모든 요소를 element라고 할 때, element를 클릭하면 deleteHandler가 실행되도록 연결한다. 
	deleteBtnList.forEach(element => element.onclick = deleteHandler)
	
	// js는 변수에 메서드를 저장할 수 있음. 
</script>
</body>
</html>