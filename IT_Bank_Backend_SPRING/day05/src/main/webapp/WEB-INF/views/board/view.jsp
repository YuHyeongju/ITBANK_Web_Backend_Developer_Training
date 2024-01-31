<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.jsp" %>

<style>
	h3{
		text-align: center;
	}
	table{
		border-collapse:  collapse;
		width: 800px;
		margin: 20px auto;
	}
	td, th{
		padding: 10px;
	}
	tr:nth-child(1){
		background-color: lime;
	}
	
	tr {
	  border-bottom: 1px solid grey;
	}
	
	 tr > td:nth-child(1) { width:10%;
	}
	 tr > td:nth-child(2) { width:50%;
	}
	 tr > td:nth-child(3) { width:10%;
	}
	 tr > td:nth-child(4) { width:15%;
	}
	tr > td{
		text-align:  center;
	}
	

</style>

<h3>게시글 조회</h3>

<table>
	<tr>
		<td style="${dto.isNotice == 1? 'color:red':'color:inherit' }">${dto.isNotice == 1? '[공지]': dto.idx } | ${dto.title }</td>
		<td>작성자: ${dto.writer } | ${dto.writeDate }</td>
		
	</tr>
	
	<tr>
		<td>
			<pre>${dto.content }</pre>
		</td>
	
	</tr>

</table>
	<div style="display: flex; width:800px; margin: 20px auto; justify-content: space-between;">
		<a href="${cpath }/board/list"><button>게시글 목록으로 이동</button></a>
		<div>
		<a href="${cpath }/board/modify/${dto.idx}"><button <%-- ${login.userid == dto.writer || login.userid == 'root'? '':'disabled' } --%>>수정</button></a>
		<a href="${cpath }/board/delete/{idx}"><button <%-- ${login.userid == dto.writer || login.userid == 'root'? '':'disabled' }--%> >삭제</button></a>	
		</div>
	</div>
	
</body>
</html>