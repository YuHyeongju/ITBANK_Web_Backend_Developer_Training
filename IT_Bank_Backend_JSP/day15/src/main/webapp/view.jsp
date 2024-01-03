<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="header.jsp"%>

<h3 style="text-align:center">게시글 상세보기</h3>

<fieldset style="border: 1px solid red;">

	<c:set var="dto" value="${boardDAO.selectOne(param.idx) }"/>
	<h4>${dto.title } | ${dto.writer } | ${dto.writeDate }</h4>
	<pre>${dto.content }</pre>
	
</fieldset>

<p><a href="${cpath }/board.jsp"><button>목록</button></a></p>

</body>
</html>