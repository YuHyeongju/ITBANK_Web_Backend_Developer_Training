<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String adult = age >=20 ? "성인": "미성년자";
	
	String msg = String.format("%s님은 %d살이고, %s입니다.", name, age ,adult);
	
	request.setAttribute("msg", msg); 
	
	// request.getRequestDispatcher("ex05-result.jsp").forward(request,response);
	// 밑에서 forward 태그로 대체

%>
<%-- 출력하고 싶은 코드만 여기에 작성해서 ex05-result.jsp로 포워드 --%>
<jsp:forward page="ex05-result.jsp"/>

</body>
</html>