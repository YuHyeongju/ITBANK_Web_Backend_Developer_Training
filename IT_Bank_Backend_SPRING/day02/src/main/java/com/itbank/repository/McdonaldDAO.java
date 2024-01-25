package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.mcdonald.McdonaldDTO;

@Repository
public interface McdonaldDAO {

//	@Select("select * from mcdonald order by idx")
//	List<McdonaldDTO> selectList();
//	
//	@Select("select * from mcdonald where category = #{category} order by idx")
//	List<McdonaldDTO> selectListByCategory(String category);
	
	
	
	@Select("<script>"
			+ "			select * from mcdonald "
			+ "			<if test=\"category = null\">"
			+ "						where category = #{category}"
			+ "			</if>"
			+ "			order by idx"
			+ "</script>")
	List<McdonaldDTO> selectList(String category);
	
	@Select("select * from mcdonald where idx = #{idx}")
	McdonaldDTO selectOne(int idx);
	
	@Select("select * from mcdonald "
			+ "where name like '%' || #{search} || '%' "
			+ "order by idx")
	List<McdonaldDTO> selectSearchList(HashMap<String, String> paramMap);
	
	@Insert("insert into mcdonald (category,name,price,imgname,memo) values(#{category}, #{name}, #{price}, #{imgname}, #{memo})") 
	int insert(McdonaldDTO dto);
	
	@Delete("delete mcdonald where idx = #{idx}")
	int delete(int idx);
	
	@Update("update mcdonald set category = #{category}, name = #{name}, price = #{price}, imgname = #{imgname}, memo= #{memo} "
			+ "where idx = #{idx}")
	int modify(McdonaldDTO dto);

	

	
	

	
	
	
}
