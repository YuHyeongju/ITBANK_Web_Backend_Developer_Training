package com.itbank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itbank.model.Product2DTO;

@Repository
public interface Product2DAO {

	List<Product2DTO> selectList();

	int insert(Product2DTO dto);

	int delete(int idx);

	int modify(Product2DTO dto);

	Product2DTO selectOne(int idx);

}
