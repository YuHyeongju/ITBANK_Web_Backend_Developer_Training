<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>


<main>
	<h2 style="width:900px; margin: 0 auto; display: flex; justify-content: center;">대문</h2>
	<div style="width:900px; margin:0 auto; display: flex; justify-content: space-between; margin-top:10px;">
		<a href="${cpath }/login.jsp">로그인</a>
		<c:if test="${!empty login }">
			<a href="${cpath }/logout.jsp">로그아웃</a> 
		</c:if>
		<c:if test="${empty login }">
			<a href="${cpath }/join.jsp">회원가입</a>
		</c:if>
		${login.userid } ${!empty login?'로그인 중':'-'}
	</div>
	
	<table class="board" cellpadding="0" cellspacing="10" border="1" style="border-collapse: collapse; width:900px; 
	margin:20px auto;">
		<thead>
			<tr>
				<th>번호</th>
				<th width="200px">제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:set var="list" value="${board2DAO.selectList(param.search) }" />
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.idx }</td>
					<td width="200px" style="text-align: center;">
						<a href = "${cpath}/view.jsp?idx=${dto.idx}" >${dto.title }</a>
						${not empty dto.image ? '💾':''}
					</td>
					<td>${dto.writer }</td>
					<td>${dto.viewCount }</td>
					<td>${dto.writeDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="sb frame" style="margin: 0 auto;">
		<div>
			<form>
				<input type="search" name="search"  placeholder="검색어 입력" >		
				<input type="submit" value="검색">
 				</form>
		</div>
		<div><a href="${cpath }/write.jsp"><button>새 글 작성</button></a></div>
	</div>
	
</main>

</body>
</html>