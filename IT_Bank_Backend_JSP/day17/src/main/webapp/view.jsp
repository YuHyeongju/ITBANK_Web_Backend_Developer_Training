<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<h2 style="display: flex; justify-content: center;">글 상세 보기</h2>
<section>
	<table class="view_table" border="1" cellpadding="0" cellspacing="10"
		style="border: 1px solid red; width: 900px; height: 600px; margin: auto auto; border-collapse: collapse;">
		<c:set var="dto" value="${board2DAO.selectOne(param.idx) }" />
		<tr>
			<td>글 번호:${dto.idx }</td>
		</tr>
		<tr>
			<td>글 제목:${dto.title }</td>
		</tr>
		<tr>
			<td>작성자: ${dto.writer }</td>
		</tr>
		<tr>
			<td>작성일:${dto.writeDate }</td>
		</tr>
		<tr>
			<td>작성자 ip:${dto.ipaddr }</td>
		</tr>
		<tr>
			<td>
				<c:if test="${!empty dto.image }">
					<img src="${cpath }/reviewImage/${dto.image}"
						style="width: 100px; height: 100px;">
				</c:if> 
				<c:if test="${empty dto.image }">
					<img src="${cpath }/reviewImage/default.png"
						style="width: 100px; height: 100px;">
				</c:if>
			</td>
		</tr>
		<tr>
			<td>내용:${dto.content }</td>
		</tr>
	</table>
</section>
<div style="width: 900px; margin: 0 auto; padding: 10px; display: flex;">
	<div style="padding-right: 10px;">
		<a href="index.jsp"><button>목록</button></a>
	</div>
	<div>
		<a href="${cpath }/modify.jsp?idx=${dto.idx}"><button>수정</button></a> 
		<a href="${cpath }/delete.jsp?idx=${dto.idx}"><button>삭제</button></a>
	</div>
</div>

</body>
</html>