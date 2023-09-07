package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface AccountDAO {

	@Select("select * from account")
	List<AccountVO> selectAll();

	
	@Select("select * from account where userid = #{userid} and userpw = #{userpw}")
	AccountVO selectOne(AccountVO input);

	
	@Select("select userid from account where email = #{email}")
	String selectId(String email);

	@Delete("delete from account where userid = #{userid}")
	int delete(String userid);
	

	int insert(AccountVO input);
	
	int updatePw(AccountVO input);

	int update(AccountVO input);

	

}
