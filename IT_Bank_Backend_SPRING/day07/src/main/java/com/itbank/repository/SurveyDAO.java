package com.itbank.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.itbank.model.ResultDTO;
import com.itbank.model.SurveyDTO;

@Repository
public interface SurveyDAO {
	
	int insert(SurveyDTO dto);

	List<SurveyDTO> selectList();

	SurveyDTO selectOne(int idx);

	int insertResult(ResultDTO dto);

}
