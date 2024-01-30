package com.itbank.repository;

import java.util.List;



import com.itbank.model.BoardDTO;

public interface BoardDAO {
	
	
	List<BoardDTO> selectList();

	BoardDTO selectOne(int idx);
	// BoardDTO : resultType
	// selectOne : id
	// int : parameterType

	int insert(BoardDTO dto);

	int delete(int idx);

	BoardDTO modify(int idx);

	int modify(BoardDTO dto);
	
	

}
