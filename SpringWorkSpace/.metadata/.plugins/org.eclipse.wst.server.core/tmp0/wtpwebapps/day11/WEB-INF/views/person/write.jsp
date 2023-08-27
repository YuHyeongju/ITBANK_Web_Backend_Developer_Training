<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>

	<fieldset class="inputForm">
		<legend>Person</legend>
	
		<form method ="POST">
		
			<p>
				<label>이름</label>
				<input name="name" value="${row.name}" ${readonly}>
			</p>
			
			<p>
				<label>신장</label>
				<input name="height" type="number" step="0.1" value="${row.height}" >
			</p>
			
			<p>
				<label>생년월일</label>
				<input name="birth" type="date" value="${row.birth}">
			</p>
			<button>등록</button>
		</form>
	</fieldset>
	
	
	
</body>
</html>