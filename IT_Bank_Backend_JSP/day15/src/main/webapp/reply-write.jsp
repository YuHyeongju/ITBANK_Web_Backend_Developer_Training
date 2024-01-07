<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<jsp:useBean id="dto" class="reply.ReplyDTO"/>
<jsp:setProperty property="*" name="dto"/>

<c:set var="row" value="${replyDAO.insert(dto) }"/>
<c:redirect url="/view.jsp?idx=${dto.board_idx }#reply"/> <%-- 최근 달린 댓글로 스크롤 --%>
<%--board.jsp 에서 댓글을 작성할 떄 hidden타입으로 보드의 idx를 보냈음.--%>


</body>
</html>