<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<section class="frame">
	<div>
		<a href="${cpath}/add.jsp"><button>목록 추가</button></a>
	</div>

	<c:set var="list" value="${dao.selectAll() }" />
	<div class="box">
		<c:forEach var="dto" items="${list }">
			<div class="items">
				<a href ="${cpath}/view.jsp?idx=${dto.idx } ">
					상품 이름: ${dto.name }<br>
					상품 가격: ${dto.price }
				</a>
				
			</div>
		</c:forEach>
	</div>
</section>

</body>
</html>