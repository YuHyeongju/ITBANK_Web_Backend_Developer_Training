<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<c:set var="row" value="${board2DAO.delete(param.idx) }"/>
<script>
	const row = '${row}'
	const deleted = '${param.deleted}'
	if(row != 0 && deleted == 0){
		alert('삭제성공')
		location.href = '${cpath}/myBoard.jsp'
	}
	if(row != 0 && deleted == 1){
		alert('복원성공')
		location.href = '${cpath}/myBoard.jsp'
	}if(row != 1){
		alert('복원 실패')
		history.back()
	} 
</script> 
</body>
</html>