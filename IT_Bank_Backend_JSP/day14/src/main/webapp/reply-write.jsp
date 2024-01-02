<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>    

<jsp:useBean id="dto" class="reply.ReplyDTO"/>
<jsp:setProperty property ="*" name="dto" />

<c:set var="row" value="${replyDAO.insert(dto) }"/>
<c:redirect url="/view.jsp?idx=${dto.board_idx }#reply"/> <%-- 댓글을 작성하면 그 댓글로 스크롤됨 --%>


</body>
</html>