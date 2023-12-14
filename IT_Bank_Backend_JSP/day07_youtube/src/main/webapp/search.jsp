<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>



<div class="frame">
	<c:set var="list" value="${dao.search(param.title) }"/>
	
	<div class="box">
		<c:forEach var="dto" items="${list }">
			<div class="item">
				<div class="img">
					<a href="${cpath }/view.jsp?idx=${dto.idx }"> 
						<img src="${dto.thumbnail }"height="120" >
					</a>
				</div>
				<div class="title">${dto.title }</div>
				<div class="name">${dto.name }</div>
			</div>
		</c:forEach>
	</div>
</div>


</body>
</html>