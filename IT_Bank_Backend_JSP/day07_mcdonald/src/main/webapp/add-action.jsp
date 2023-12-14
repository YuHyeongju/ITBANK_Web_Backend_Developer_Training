<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>


<jsp:useBean id="dto" class="mcdonald.McdonaldDTO" />
<jsp:setProperty property="*" name="dto"/>

<c:set var="row" value="${dao.insert(dto) }"/>

<c:if test="${row !=0 }">
	<c:set var="idx" value="${dao.selectCurrSeq() }"/>
</c:if>

<c:redirect url="/view.jsp?idx=${idx } "/>
<%-- 현재 인덱스에 해당하는 상세보기로 리다이렉트 --%>
<script >
	alert('추가 실패')
	history.back()
</script>

</body>
</html>