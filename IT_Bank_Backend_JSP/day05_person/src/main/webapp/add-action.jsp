
<%@page import="java.net.URLEncoder"%>
<%@page import="person.PersonDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="paramDTO" class="person.PersonDTO"/> <%--paramDTO라는 객체생성 --%>
<jsp:setProperty property="*" name="paramDTO"/>	<%-- personDTO에 멤버필드랑 파라미터를 담아서 --%>

${personList.add(paramDTO) }  <%--personList에 추가 --%>




	<%
		//ArrayList<PersonDTO> personList = (ArrayList<PersonDTO>)application.getAttribute("personList");
		//personList.add(paramDTO); 위의 코드와 동일함.
		
		
		
		
		//response.sendRedirect("list.jsp"); // 전체목록으로 리다이렉트(각 각체를 고유식별할 값이 없을 경우)
	
		
		String name = URLEncoder.encode(paramDTO.getName(), "UTF-8");
		// URLEncoder의 인코드메서드로 UTF-8 형식으로 인코딩
		response.sendRedirect("view.jsp?name=" + name);
		// 이름으로 각 각체를 고유 식별할 수 있음으로 단일 조회로 이동가능(상세정보를 볼 수 있음.)
		// 중복되는 이름이 없어야함.
	%>
</body>
</html>