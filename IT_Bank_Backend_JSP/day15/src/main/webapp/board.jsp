<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>


<section>
	<h2 style="text-align: center;">게시판</h2>
	<table border="1" cellpadding="10" cellspacing="0" style="width:500px; margin: 0 auto;">
		<tr style="background-color: #dadada">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>삭제</th>
		</tr>
		<c:set var="list" value="${boardDAO.selectList() }"/>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx}</td>
				<td><a href="${cpath}/view.jsp?idx=${dto.idx }" style="text-decoration: none; color: inherit;">${dto.title }</a>
		              
		              <c:if test="${dto.replyCount != 0 }">
		              	<span style="color:red;">[${dto.replyCount }]</span>
		              </c:if>		
				</td>
				<td>${dto.writer }</td>
				<td>${dto.writeDate }</td>
				<td><a href="${cpath }/board-delete.jsp?idx=${dto.idx}"><button ${dto.writer != login.userid? 'disabled':''} >삭제</button></a></td>
				
			</tr>
		</c:forEach>	
	</table>
	<div  style="width:500px; margin: 0 auto; display: flex; justify-content: right; ">
		<div></div>
		<div ><a href="${cpath }/board-add.jsp"><button style="margin-top:20px;">글쓰기</button></a></div>
	</div>
	
</section>

</body>
</html>