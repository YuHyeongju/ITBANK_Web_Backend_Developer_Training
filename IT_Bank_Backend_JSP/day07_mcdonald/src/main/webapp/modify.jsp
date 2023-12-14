<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<c:set var="dto" value="${dao.selectOne(param.idx)}" /> 
<%-- 단일 조회할 때의 함수를 이용하여 먼저 단일 객체를 불러온다. --%>


<%-- 항목 추가할 때 form을 불러오고, dto의 값을 이용하여 자동완성 형식으로 채워준다.  --%>
<%-- form의 action은 "add-action.jsp" 에서  "modify-action.jsp"로 수정하였다. --%>
<section class="frame">
	<h3>항목 수정</h3>
	<form action="modify-action.jsp">
		<input type="hidden" name="idx" value="${dto.idx }">
		<%-- 실행에 필요한 값이 전달되지 않는다면 hidden 형태로 추가로 전달하면 된다. --%> 
		<p>
			<label><input type="radio" name="category" 
			${dto.category =='버거' ? 'checked': ''} value="버거" required >버거</label>	
			<label><input type="radio" name="category"
			${dto.category =='음료' ? 'checked': ''} value="음료" required>음료</label>	
		</p>
		<p><input type="text" name="name" placeholder="상품이름" value="${dto.name }" required></p>
		<p><input type="number" name="price" placeholder="상품 가격" value="${dto.price }" required></p>
		<p><input type="text" name="imgName" placeholder="그림 파일 이름"  value="${dto.imgName}" required></p>
		<p><textarea name="memo" placeholder="상세 설명"required>${dto.memo }</textarea></p>
		<p><input type="submit"></p>
		<!-- dto에 맟추어서 칸을 준비했다. -->
 	</form>
</section>
</body>
</html>