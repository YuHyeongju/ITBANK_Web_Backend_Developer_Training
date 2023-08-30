package com.itbank.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BoardDAO {
	
	
	@Select("select * from board where idx = #{idx}")
	BoardVO selectOne(int idx);

	@Select("select count(*) from board")
	int totalBoard();  //총 게시글 수 

	@Delete("delete from board where idx = #{idx}")
	int delete(int idx); //삭제 

	@Update("update board set vcount = vcount + 1 where idx = #{idx}")
	void vcountUp(int idx); //조회수 증가
	
	int insert(BoardVO input); //board.xml에 작성됨
	int update(BoardVO input);

	
	List<BoardVO> selectAll(Map<String,Object> param);


	
	
}
