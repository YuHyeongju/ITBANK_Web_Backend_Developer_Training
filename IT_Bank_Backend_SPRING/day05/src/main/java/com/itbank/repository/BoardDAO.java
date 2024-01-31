package com.itbank.repository;

import java.util.List;



import com.itbank.model.BoardDTO;

public interface BoardDAO { // 추상메서드: 함수의 바디가 없는 형태
	 
	
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
