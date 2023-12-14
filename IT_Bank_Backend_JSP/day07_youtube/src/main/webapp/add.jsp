<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<section class="frame add">
	<form action="add-action.jsp">
	<p><input type="text" name="title" placeholder="영상제목"required></p>
	<p><input type="text" name="name" placeholder="채널이름"required></p>
	<p><input type="text" name="thumbnail" placeholder="영상썸네일"required></p>
	<p><input type="text" name="tag" placeholder="영상태그"required></p>
	<p><input type="submit"></p>
	</form>	
</section>

</body>
</html>