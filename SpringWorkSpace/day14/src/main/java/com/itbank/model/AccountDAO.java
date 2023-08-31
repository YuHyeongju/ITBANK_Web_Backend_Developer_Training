package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface AccountDAO {

	@Select("select * from account")
	List<AccountVO> selectAll();

	
	@Select("select * from account where userid = #{userid} and userpw = #{userpw}")
	AccountVO selectOne(AccountVO input);

}
