<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>

	<article class="board">
	
		<table>
		  
		  	<tr>
		  		<th>작성자</th>
		  		<th>${row.writer}</th>
		  		<th>조회수</th>
		  		<th>${row.vcount }</th>
		  		<th>작성일</th>
		  		<th>${row.wdate }</th>
		  	</tr>
		  	<tr>
		  		<td colspan = "6">${row.idx }.${row.title }</td>
		  	</tr>
		  	<tr>
		  		<td colspan="6"><pre>${row.contents }</pre></td>
		  	</tr>
		</table>
		<br>
		<div>
			<a href = "${cpath }/board/update/${row.idx}"><button>수정</button></a>
			<a href = "${cpath }/board/delete/${row.idx}"><button>삭제</button></a>
		</div>
		
	</article>>


</body>
</html>