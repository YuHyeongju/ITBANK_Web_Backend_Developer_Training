<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<style>
	p{
		align-items: center;
	}


</style>

<c:if test="${pageContext.request.method == 'GET' }">

	<form method="post"
		style="width: 600px; height: 400px; border: 1px solid red; margin: auto auto;">
		<div style="margin: 0 auto;">
			<h4>회원가입</h4>
			<p>
				<input type="text" name="userid" placeholder="ID" required autofocus>
			</p>
			<p>
				<input type="password" name="userpw" placeholder="PW" required>
			</p>
			<p>
				<input type="text" name="userName" placeholder="이름" required>
			</p>
			<p>
				<input type="email" name="email" placeholder="이메일" required>
			</p>
			<p>
				<label><input type="radio" name="gender" value="남성" required>남성</label>
				<label><input type="radio" name="gender" value="여성" required>여성</label>
			</p>
			<input type="submit" value="회원가입">
		</div>
	</form>
	<div style="width:600px; margin:0 auto; padding:10px;">
		<a href="${cpath }/index.jsp"><button >대문</button></a>
	</div>
	
</c:if>
<c:if test="${pageContext.request.method == 'POST' }">
	<jsp:useBean id="dto" class="member.MemberDTO" />
	<jsp:setProperty property="*" name="dto" />
	<c:set var="row" value="${memberDAO.insert(dto) }" />
	<c:redirect url="login.jsp" />
</c:if>

</body>
</html>