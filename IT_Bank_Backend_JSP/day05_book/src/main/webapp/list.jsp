<%@page import="book.BookDTO"%>
<%@page import="book.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
<h1>도서 목록</h1>
<hr>

<p>
	<a href="add.jsp"><button>도서 추가</button></a>
</p>

<table border="1" cellpadding="10" cellspacing="0">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>저자</th>
			<th>출판사</th>
			<th>출판일자</th>
		
		</tr>
	
	</thead>
	<tbody>
		<%
			BookDAO dao = (BookDAO) application.getAttribute("dao");
			// 애플리케이션에서 dao객체를 가져와서 dao에 저장
			if(dao == null){	// dao가 비었으면
				dao = new BookDAO();	// BookDAO객체 생성
				application.setAttribute("dao", dao);	
				// dao라는 이름의 dao를 애플리케이션에 추가
				
				
				
				
			}
			for(BookDTO dto : dao.selectList()){
				%>
				<tr>
					<td><%=dto.getIdx() %></td>
					<td>
						<a href="view.jsp?idx=<%=dto.getIdx() %>"> 
						<%-- 인덱스번호가 일치하면 view.jsp(상세보기)를 가져옴--%>
							<%=dto.getTitle() %>
						</a>
					</td>
					<td><%=dto.getAuthor() %></td>
					<td><%=dto.getPublisher() %></td>
					<td><%=dto.getPublishDate() %></td>
				</tr>
		<% 		
			}
		%>
	
	
	</tbody>
</table>
</body>
</html>