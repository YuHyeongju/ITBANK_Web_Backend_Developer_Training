<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<c:set var="isLogin" value="${not empty user }"/>

	<h3>account 테이블 목록</h3>
	
	<p>로그인 : ${isLogin ? user.nick : 'x' }</p>
	
	<article class="board">
		<table>
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>닉네임</th>
				<th>이메일</th>
				<th>가입일</th>
			</tr>
			
			<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.userid }</td>
				<td>
					${fn:substring(row.userpw, 0, 10) } 
				</td>
				<td>${row.nick }</td>
				<td>${row.email }</td>
				<td>${row.jdate }</td>
			</tr>
			</c:forEach>
		</table>
		
		<c:set var="login" value="${isLogin ? 'logout' : 'login' }"/>
		<c:set var="signUp" value="${isLogin ? 'myPage' : 'signUp' }"/>
		<ul class="menu">
			<li><a href="${cpath }/account/${login }">
				<button>${login }</button>
			</a></li>
			<li><a href="${cpath }/account/${signUp }">
				<button>${signUp }</button>
			</a></li>
		</ul>
		
	</article>

</body>
</html>