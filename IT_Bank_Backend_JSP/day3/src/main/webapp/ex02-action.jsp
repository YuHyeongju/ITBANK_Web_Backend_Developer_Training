<%@page import="java.net.URLEncoder"%>
<%--
	주소창에 특수문자가 들어갔을 때 문제가 생기면 URLEncoder 사용
	주소창에 입력할 수 있는 형태의 16진수 형태로 만들어준다.
	다시 원래대로 돌리려면 URLDecoder를 사용하면된다.
 --%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



	<%!// 선언부, 미리 준비된 변수와 함수, 유지된다.
		Random ran = new Random();
		int cpu = ran.nextInt(100) + 1;
		int count = 0;
	%>

	<%-- 2 --%>

	<%	
		// service()
	
		if(request.getParameter("reset") != null){
			count = 0;
			cpu = ran.nextInt(100) + 1;
			response.sendRedirect("ex02-form.jsp"); // 302, 자원이 이동되었으니 이동해라
			return; // 이후 코드를 수행하지 않음.
		}
	
	
		// 입력받은 상태를 가정하고 코드를 진행할 수 있음.
		int user = Integer.parseInt(request.getParameter("user"));
		count ++;
		String msg = "";
		
		if(user == cpu)	msg = String.format("정답. %d회만에 정답을 맞춤",count);
		
		else if(user < cpu) msg = "UP(" + count + "회)";
			
		else	msg = "DOWN(" + count + "회)";
		
		
		String location = "ex02-form.jsp?msg=" + URLEncoder.encode(msg,"UTF-8");;
		
		
		
		
		// 클릭하지 않아도 대상 페이지로 이동하도록 브라우저에게 명령하기(리다이렉트) 
		// 화면에 출력할 내용이 있지만, 자바코드가 HTML보다 먼저 수행되기때문에
		// 사용자를  HTML코드를 볼 수 없다.
		// -> 처리를 전담하는 JSP는 사실 HTML 구문이 필요 없다.
		response.sendRedirect(location);
		// 3
		
	%>
	
	<%--a 태그의 역할을 위의  sendRedirect가 대신 자동으로 수행 --%>
	<a href="ex02-form.jsp?msg=<%=msg %>">
		<button>입력으로 이동</button>
	</a>

	
	<%--handler 역할--%>
	