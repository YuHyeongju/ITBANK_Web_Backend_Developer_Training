package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.mcdonald.McdonaldDTO;
import com.itbank.repository.McdonaldDAO;

enum McdonaldCategory{
	all(null),
	burger("버거"),
	drink("음료");
	
	private String columnVaule;
	
	McdonaldCategory(String columnValue){
		this.columnVaule = columnValue;
	}
	public String getColumnName() {
		return columnVaule;
	}
	
}


@Service
public class McdonaldService {
	
	@Autowired McdonaldDAO dao;
	
//	public List<McdonaldDTO> getMcdonaldList() {
//		List<McdonaldDTO> list = dao.selectList();
//		
//		
//		return list;
//	}
//	
//	public List<McdonaldDTO> getMcdonaldList(String category) {
//		
//		return dao.selectListByCategory(category);
//	}

	public int add(McdonaldDTO dto) {
		int row = dao.insert(dto);
		return row;
	}


	public McdonaldDTO getMcdonaldView(int idx) {
		
		return dao.selectOne(idx);
	}

	public int delete(int idx) {
		int row = dao.delete(idx);
		return row;
	}

	public int modify(McdonaldDTO dto) {
		int row = dao.modify(dto);
		return row;
	}

	public List<McdonaldDTO> getMcdonaldSearchList(HashMap<String, String> paramMap) {
		List<McdonaldDTO> list = dao.selectSearchList(paramMap);
		
		return list;
	}

	public List<McdonaldDTO> getList(String category) {
		String columnValue = null;
//		switch(category) {
//		case "all" : columnValue =  null; break;
//		case "burger" : columnValue =  "버거"; break;
//		case "drink" : columnValue =  "음료"; break;
//		} enum을 사용하면 이 switch문이 필요 없다.
		
		McdonaldCategory e1 = McdonaldCategory.valueOf(category);
		columnValue = e1.getColumnName();
		
		System.out.println("category: " + category);
		System.out.println("columnValue: " + columnValue);
		System.out.println();
		
		return dao.selectList(columnValue);
		
		
		
	}


	

	

	

}
