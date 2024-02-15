package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.Product2DTO;
import com.itbank.repository.Product2DAO;

@Service
public class ProductService {
	@Autowired private Product2DAO dao;
	
	private String saveDirectory = "C:\\upload";
	
	public ProductService() {
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdir();
		}
	}

	public List<Product2DTO> getProductList() {
		
		return dao.selectList();
	}

	public int productInsert(Product2DTO dto) {
		String fileName = dto.getUpload().getOriginalFilename();
		
		File f = new File(saveDirectory,fileName);
		
		try {
			dto.getUpload().transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		dto.setImg(fileName);
		
		
		return dao.insert(dto);
	}

	public int productDelete(int idx) {
		
		return dao.delete(idx);
	}

	public int productModify(Product2DTO dto) {
		
		return dao.modify(dto);
	}

	public Product2DTO getProduct(int idx) {
		
		return dao.selectOne(idx);
	}

}
