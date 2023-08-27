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
	
	public List<PersonVO> getPersons(){
		return dao.selectAll();
	}
	public int addPer(PersonVO per) {
		return dao.insert(per);
	}
	public int delPer(String name) {
		return dao.delete(name);
	}
	public Object getPerson(String name) {
		
		return dao.selectOne(name);
	}
	public int updatePer(PersonVO per) {
		return dao.update(per);
	}
}
