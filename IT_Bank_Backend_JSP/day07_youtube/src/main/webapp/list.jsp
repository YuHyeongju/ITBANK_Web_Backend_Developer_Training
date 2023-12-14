<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>


<section class="frame">
	<div>
		<a href="${cpath }/add.jsp"><button>추가</button></a>
	</div>
	
	<c:set var="list" value="${dao.selectList() }" />
	<div class="box">
		<c:forEach var="dto" items="${list }">
			<div class="item">
				<div class="img">
					<a href="${cpath }/view.jsp?idx=${dto.idx }"> 
						<img src="${dto.thumbnail }"height="120" style="border-radius: 20px; ">
					</a>
				</div>
				<div class="title">${dto.title }</div>
				<div class="name">${dto.name }</div>
			</div>
		</c:forEach>
	</div>
</section>
</body>
</html>