package com.itbank.action;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.board.Board2DAO;
import com.itbank.board.Board2DTO;
import com.itbank.board.Paging;

public class BoardAction implements CommandAction{

	//boardDAO에서 데이터 호출
	private Board2DAO board2DAO = Board2DAO.getInstance();
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String paramPage = request.getParameter("page");
		String search = request.getParameter("search");
		if(search == null) {
			
			search="";
		}
		int page = paramPage == null? 1: Integer.parseInt(paramPage);
		int boardCount = board2DAO.selectCount1(search);
		Paging paging = Paging.newInstance(page, boardCount);
		List<Board2DTO> list = board2DAO.selectList(search,paging);
		
		
		request.setAttribute("list", list); // DAO에서 불러온 list를 JSP에게 념겨주기 위해 setAttribute 전달
		request.setAttribute("paging", paging);
		
		
		
		return "board"; // /WEB-INF/views/board.jsp로 이동
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
