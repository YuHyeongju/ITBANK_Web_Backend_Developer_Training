<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<c:set var="dao" value="${dao.delete(param.idx) }"/>

<c:redirect url="/list.jsp"/>

<%-- 리다이렉트는 태그의 형태이지만 실행되는 자바코드이다.
안에 cpath가 내장되어있어 표기할때  ${cpath}를 빼야한다. --%>

</body>
</html>