package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Ex02Controller extends HttpServlet {

	private static final long serialVersionUID = -1937070278525017122L;
	// 서버로 넘길떄 직렬화 번호가 없으면 식별이 어렵다.

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd a hh:mm:ss");
		String time = sdf.format(date);

		request.setAttribute("time", time);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ex02.jsp");
		rd.forward(request, response); //클라이언트가 알아차리지 못홤
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String name  = request.getParameter("name");
		int age  = Integer.parseInt(request.getParameter("age"));
		
		String msg = (age >= 20) ? "성인" : "미성년자" ;
		msg +=" 입니다~";
		
		request.setAttribute(msg, msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/ex02_result.jsp");
		rd.forward(request, response);
		
		
	}

}
