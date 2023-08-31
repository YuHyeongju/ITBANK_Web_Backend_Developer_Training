package com.itbank.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BoardDAO {

	@Select("select * from board where idx = #{idx}")
	BoardVO selectOne(int idx);

	@Delete("delete from board where idx = #{idx}")
	int delete(int idx);

	@Update("update board set vcount = vcount + 1 where idx = #{idx}")
	int vcountUp(int idx);

	int totalBoard(Map<String, Object> param);
	
	int insert(BoardVO input);
	int update(BoardVO input);
	
	List<BoardVO> selectAll(Map<String, Object> param);

}
