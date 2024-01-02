<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>



<jsp:useBean id="dto" class="reply.ReplyDTO"/> 
<%-- reply 패키지의 ReplyDTO클래스를 dto라는 이름으로 가져옴 --%>
<jsp:setProperty property="*" name="dto"/> <%--댓글 writer와 댓글 idx가 들어감 --%>
<%-- dto의 setter를 사용하기 위해 지정한다. --%>
<jsp:setProperty property="writer" name="dto" value="${login.userid }"/>
<%--본인이 맞을 때만 삭제를 할 수 있게 하기 위해 writer프로퍼티 안에 로그인 정보를 넣어 dto라는 이름으로 전달한다.--%>

${replyDAO.delete(dto) }  <%-- writer까지 들어가 있음. 본인이 아니면 지울 수 없도록 코드를 변경--%> 

<%-- 댓글을 삭제한다(삭제하기위해서는) reply의 pk값에 해당하는 idx값이 필요하다. --%>
<c:redirect url="/view.jsp?idx=${param.board_idx }"/>		
<%--삭제가 끝나면 게시글 보기 페이지로 이동(이동하기위해서는 board의 idx가 필요하다.) --%>




</body>
</html>