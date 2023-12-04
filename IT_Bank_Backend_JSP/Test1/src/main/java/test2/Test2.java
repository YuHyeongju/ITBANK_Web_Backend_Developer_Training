package test2;

import java.io.IOException;
import java.io.PrintWriter;				// 지시자 directive
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test2 extends HttpServlet {

	/**
	 * 
	 */														
	private static final long serialVersionUID = 1L;		// 선언부 declaration 
	// 바이너리 데이터를 보낼 때 가지고 있는 데이터를 1바이트 단위로 쪼개서 보내야하는데 
	// 그걸 받는 쪽에서 받아서 조립을할 때 시리얼 값을 보고 조립하여 사용한다. 설계도와 유사한 개념이다.

	@Override // Server에서 실행될 프로그램의 service함수는 역할상 main함수와 동일하다.
	//메서드 이름을 service로 변경해도 동일하게 작동함.
	protected void doGet(HttpServletRequest requset, HttpServletResponse response) // 스크립틀릿 scriptlet
			throws ServletException, IOException { // jsp함수는 애초에 함수가 예외처리를 하게끔 생겨먹었다.
												   // 따라서 편안하게 함수를 작성할 수 있다.

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		String now = sdf.format(new Date());

		requset.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter pw = response.getWriter(); /* 응답의 주요내용 - 반환할 내용을 pw에 저장하여 보냄*/

		String html = "";
		html += "<!DOCTYPE html>";
		html += "<html lang=\"ko\">";
		html += "<head>";
		html += "	<title>MyServlet</title>";		// "" + ob  + "" ->  표현식 expression 
		html += "	<meta charset=\"UTF-8\">";		// html 코드 사이에 자바 변수 넣을 때 사용
		html += "</head>";
		html += "<body>";
		html += "	<h1>My Servlet</h1>";
		html += "	<hr>";
		html += "	<h3>" + now + "</h3>";
		html += "<body>";
		html += "</html>";

		pw.write(html);
		pw.flush();
		pw.close();

	}

}
