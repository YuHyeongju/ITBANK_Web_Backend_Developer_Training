package com.itbank.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDAO;
import com.itbank.model.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public Map<String, Object> getBoards(int page){
		
		int perCount = 10; //페이지당 게시글
		int offset = (page -1) * perCount;	//(사용자의 요청페이지 -1) * 페이지당 게시글
		int totalCount = dao.totalBoard(); //DB에서 전체 게시글 수 불러오기
		int perPage = 10;	//화면당 표시할 페이지 수
		int totalPage = totalCount / perCount; //전체페이지수 = 전체게시글 / 페이지당 게시글
		
		totalPage += (totalCount % perCount == 0)? 0:1;
		
		int index = (page - 1) /perPage;
		int begin = index * perPage + 1;
		int end = (index + 1) * perPage;
		
		end = (end > totalPage)? totalPage : end; 
		
		
		Map<String,Object> param = new HashMap<>();
		param.put("offset", offset);
		param.put("perCount", perCount);
		//DAO에 한꺼번에 담아서 전달할 MAP
		
		Map<String,Object> result = new HashMap<>();
		result.put("list", dao.selectAll(param));
		result.put("begin",begin);
		result.put("end",end);
		//구한 결과를 view로 보내줄 Map
		
		
		return result;
		//메서드 이름은 정해진 것 아님
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
