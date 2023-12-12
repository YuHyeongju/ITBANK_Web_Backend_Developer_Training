<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex03.jsp</title>
</head>
<body>
<%

	pageContext.setAttribute("test", "짱구");
 	request.setAttribute("test", "루피");
 	session.setAttribute("test", "코난");
 	application.setAttribute("test","페이커");
 	
%>
<jsp:useBean id="pro" class="java.util.Properties" scope="session"/>
<%-- 기본생성자로 만들 수 있는 map, Properties pro1 = new Properties 랑 같은 의미이다. --%>

<%-- static 메서드: 객체를 생성하지않고도 클래스에 접근하여 호출 할 수 있다. --%>

<c:set var="test2" value="침착맨" scope="requset"/>

<h3>\${test }: ${test }</h3>  <%-- scope를 지정하지않으면 순서대로 찾아감. --%>
<h3>\${pageScope.test }: ${pageScope.test }</h3>
<h3>\${request.test }: ${request.test }</h3>
<h3>\${session.test }: ${session.test }</h3>
<h3>\${application.test }: ${application.test }</h3>
<br>
<h3>\${test2 }: ${test2 }</h3>
<h3>\${request.test2 }: ${request.test2 }</h3>
</body>
</html>