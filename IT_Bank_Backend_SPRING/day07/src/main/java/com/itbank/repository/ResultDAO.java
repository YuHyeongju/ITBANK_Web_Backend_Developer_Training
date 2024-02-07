package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.SurveyDTO;

@Repository
public interface ResultDAO {

	List<SurveyDTO> selectList();

	int getCount(int idx);

	

}
