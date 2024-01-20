package servlet_e;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board2.Board2DAO;
import board2.Paging;

@WebServlet("/board2")
public class Board2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String prefix = "/WEB-INF/views/";
	private final String suffix = ".jsp";

	private Board2DAO board2DAO = Board2DAO.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String search = req.getParameter("search");
		if (search == null) {
			search = "";
		}

		int count = board2DAO.selectCount1(search);
		String paramPage = req.getParameter("page");
		int page = Integer.parseInt(paramPage == null ? "1" : paramPage);
		Paging paging = Paging.newInstance(page, count);
		req.setAttribute("list", board2DAO.selectList(search, paging));
		req.setAttribute("paging", paging);

		req.getRequestDispatcher(prefix + "board2" + suffix).forward(req, resp);
	}
}
