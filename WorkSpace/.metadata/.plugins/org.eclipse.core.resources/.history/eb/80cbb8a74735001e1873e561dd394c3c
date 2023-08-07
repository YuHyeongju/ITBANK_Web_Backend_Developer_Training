package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/quiz")
public class QuizController extends HttpServlet {

	private static final long serialVersionUID = -6074042048828957059L;
	
	protected void doGET(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/quiz_result.jsp");
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		int num_sum = num1 + num2
}
