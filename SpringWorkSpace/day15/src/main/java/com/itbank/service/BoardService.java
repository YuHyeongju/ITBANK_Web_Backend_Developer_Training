package com.itbank.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.Paging;
import com.itbank.model.BoardDAO;
import com.itbank.model.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public Map<String, Object> getBoards(int page, String type, String search){
		
		
		
		
		
		Map<String,Object> param = new HashMap<>();
		
		
		
		Paging p = new Paging(page,dao.totalBoard(param));
		
		param.put("offset", p.getOffset());
		param.put("perCount", p.getPerCount());
		
		//DAO에 한꺼번에 담아서 전달할 MAP
		
		
		Map<String,Object> result = new HashMap<>();
		result.put("list", dao.selectAll(param));
		result.put("page",p);
		
		
		
		return result;
		
	}

	public BoardVO getBoard(int idx) {
		
		
		dao.vcountUp(idx);
		
		
		return dao.selectOne(idx);
	}

	public int addBoard(BoardVO input) { 
		
		return dao.insert(input);
	}

	public int delBoard(int idx) {
		
		return dao.delete(idx);
	}

	public int updateBoard(BoardVO input) {
		
		return dao.update(input);
	}
	
	
	
}
