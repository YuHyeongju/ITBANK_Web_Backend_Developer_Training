package com.itbank.model;

import java.util.List;


import org.apache.ibatis.annotations.Select;

public interface BoardDAO {
	
	@Select("select * from board order by idx desc")
	List<BoardVO> selectAll();

	
	@Select("select * from board where idx = #{idx}")
	BoardVO selectOne(int idx);
	
}
