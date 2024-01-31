<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>


<section>
	<h3>${dto.username } 회원님의 상세 정보</h3>
	<table border="1" cellspacing="0" cellpadding="10">
		
		<tr>
			<td>ID</td>	
			<td>${dto.userid }</td>
		</tr>
		<tr>
			<td>PW</td>
			<td>********</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${dto.username }</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${dto.gender }</td>
		</tr>
		<tr>
			<td>메일</td>
			<td>${dto.email }</td>
		</tr>
	</table>
	<p>
		
		<a href="${cpath }/member/modify/${dto.idx}"><button ${login.userid == dto.userid?'':'disabled'}>정보 수정</button></a>
		<a href="${cpath }/member/list"><button>회원 목록으로 이동</button></a>
	</p>

</section>
</body>
</html>