<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<section class="frame">
	<c:set var="dto" value="${dao.selectOne(param.idx) }" />
	<div class="detail">
		<div><img src="${dto.thumbnail }"></div>
		<div>${dto.title }</div>
		<div>${dto.name }</div>
	</div>
	<div class = "sb">
		<div>
			<a href="${cpath }/list.jsp"><button>목록</button></a>
		</div>
		<div>
			<a href="${cpath }/modify.jsp?idx=${dto.idx }"><button>수정</button></a>
			<a href="${cpath }/delete.jsp?idx=${dto.idx }"><button id="deleteBtn">삭제</button></a>
		</div>
	
	</div>


</section>

<script>
	deleteBtn.onclick = function(){
		const flag = confirm('정말 삭제하시겠소?')
		if(flag){
			location.href = '${cpath}/delete.jsp/idx=${dto.idx}'			
		}
	}


</script>

</body>
</html>