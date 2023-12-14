<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>



<p>${param.idx }번 데이터를 삭제</p> <%-- 
										필요없으나 남겨놓음 
										밑에 리다이렉트 코드가 없으면 이 문장이 출력되고 
										리다이렉트 안됨
								 --%>

<c:set var="row" value="${dao.delete(param.idx) }"/>

<c:redirect url="/list.jsp"/>

</body>
</html>