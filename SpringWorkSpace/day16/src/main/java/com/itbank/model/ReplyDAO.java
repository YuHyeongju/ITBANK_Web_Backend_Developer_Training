package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ReplyDAO {

	
	@Insert("insert into "
			+ "reply(board_idx, contents, writer)"
			+ "values(#{board_idx}, #{contents}, #{writer})")
	int insert(ReplyVO input);

	
	@Select("select * from reply "
			+ "where board_idx = #{idx} "
			+ "order by idx desc")
	List<ReplyVO> selectAll(int idx);
	
}
