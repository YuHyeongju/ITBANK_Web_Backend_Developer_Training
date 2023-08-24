package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface BoardDAO {
	
	@Select("select * from board")
	List<BoardVO> selectAll();
	
}
