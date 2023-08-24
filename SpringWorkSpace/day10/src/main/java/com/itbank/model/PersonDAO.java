package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface PersonDAO {
	
	@Select("select * from person")
	List<PersonVO> selectAll();

}
