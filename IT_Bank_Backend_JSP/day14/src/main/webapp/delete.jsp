<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<jsp:useBean id="dto" class="board.BoardDTO"/>
<jsp:setProperty property="*" name="dto"/>

<c:set var="row" value="${replyDAO.deleteAll(param.idx) }"/>
<c:set var="row" value="${boardDAO.delete(param.idx) }"/>

<c:redirect url="board.jsp"/>

</body>
</html>