package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.SurveyDTO;
import com.itbank.repository.ResultDAO;

@Service
public class ResultService {
	
	@Autowired private ResultDAO dao;

	public List<SurveyDTO> getResultList() {
		
		
		return dao.selectList();
	}

	

	

	

	

	

}
