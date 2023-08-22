package com.itbank.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.PersonDAO;
import com.itbank.model.PersonVO;


@Service
public class PersonService {
	
	@Autowired
	private PersonDAO dao;
	
	public List<PersonVO> getList() {
		return dao.selectAll();
	}

}
