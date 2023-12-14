<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<jsp:useBean id="dto" class="youtube.YoutubeDTO"/>
<jsp:setProperty property="*" name="dto"/>

<c:set var="row" value="${dao.insert(dto) }"/>

<c:if test="${row != 0 }">
	<c:set var="idx" value="${dao.selectCurrSeq() }"/>
</c:if>

<c:redirect url="/view.jsp?idx=${idx }"/>
<script >
	alert('추가 실패')
	history.back()
</script>


</body>
</html>