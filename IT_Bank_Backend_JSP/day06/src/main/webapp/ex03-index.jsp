<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ex03-header.jsp" %>

<h3>대문 페이지</h3>
<p>${arr[4] }</p>

<%
	// String[] arr = {};
	// Duplicate local variable arr
	// 지역변수 arr가 중복된다.
	// ex03-index.jsp 에서는 생성하지 않았으나
	// ex03-header.jsp에서 이미 arr라는 이름을 사용하기때문에
	// 두 개의 파일이 하나로 합쳐진 후 컴파일 되기때문에 
	// 같은 이름을 사용하면 안된다.

%>
<%-- 모양 뿐만 아니라 자바코드도 공유가능함. --%>
</body>
</html>