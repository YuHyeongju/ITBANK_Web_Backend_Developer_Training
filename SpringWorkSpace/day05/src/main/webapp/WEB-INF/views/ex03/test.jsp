<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	<h3>DTO 객체</h3>
	
	<form method= "post">
	
		<p><input name="name" type="text" placeholder ="이름" required></p>
		<p><input name="age" type="number" placeholder ="나이" required></p>
		
		<button>전송</button>
	
	</form>
</body>
</html>