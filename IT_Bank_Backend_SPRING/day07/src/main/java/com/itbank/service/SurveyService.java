package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.ResultDTO;
import com.itbank.model.SurveyDTO;
import com.itbank.repository.SurveyDAO;

@Service
public class SurveyService {
	
	@Autowired private SurveyDAO dao;
	
	private String saveDirectory = "C:\\upload";
	
	public SurveyService() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdir();
		}
	}

	public int insert(SurveyDTO dto) {
		String originalFileName1 = dto.getUpload0().getOriginalFilename();
		String originalFileName2 = dto.getUpload1().getOriginalFilename();
		
		File f1 = new File(saveDirectory,originalFileName1);
		File f2 = new File(saveDirectory,originalFileName2);
		
		try {
			dto.getUpload0().transferTo(f1);
			dto.getUpload1().transferTo(f2);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		dto.setImage1(originalFileName1);
		dto.setImage2(originalFileName2);
		
		return dao.insert(dto);
	}

	public List<SurveyDTO> getList() {
		
		return dao.selectList();
	}

	public SurveyDTO getSurvey(int idx) {
		
		return dao.selectOne(idx);
	}

	public int surveyInsert(ResultDTO dto) {
		
		return dao.insertResult(dto);
	}

	

	

}
