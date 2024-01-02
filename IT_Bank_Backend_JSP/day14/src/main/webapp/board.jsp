<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
</head>
<body>
	<h4 style="text-align:center;">게시판</h4>
	<table border="1" cellpadding="10" cellspacing="0" style="width: 800; margin:0 auto;">
		<tr style="background-color: #dadada">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>삭제</th>
		</tr>

		<c:set var="list" value="${boardDAO.selectList() }" /> 
		<%-- boardDAO에서 selectList()를 실행하여 그 결과를 list라는 이름으로 저장 --%>
		<c:forEach var="dto" items="${list }"><%--dto라는 이름의 list를 반복시킴 --%>
	
			<tr>
				<td>${dto.idx }</td>
				<td width="500">
					<a href="${cpath }/view.jsp?idx=${dto.idx}"
						style="text-decoration: none; color: inherit;"> ${dto.title } 
					</a>
					
					<c:if test="${dto.replyCount != 0 }"> <%-- 댓글이 있으면 댓글 갯수 표시 --%>
						<span style="color: red;">[${dto.replyCount }]</span>
					</c:if>
					
				</td>
				<td>${dto.writer }</td>
				<td>${dto.writeDate }</td>
				<td>
					
					<a href="${cpath }/delete.jsp?idx=${dto.idx}">
						<button ${dto.writer != login.userid? 'disabled':''}>삭제</button>
					</a>
				</td>
			</tr>
		</c:forEach>

	</table>

	<div style="width:810px; display: flex; justify-content: space-between; margin: 20px auto;">
		<div></div>
		<div>
			<a href="${cpath }/write.jsp"><button>작성</button></a>
		</div>

	</div>
</body>
</html>