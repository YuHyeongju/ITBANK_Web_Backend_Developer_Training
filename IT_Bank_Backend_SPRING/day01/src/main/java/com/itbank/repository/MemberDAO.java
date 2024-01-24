package com.itbank.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.member.MemberDTO;

@Repository
public interface MemberDAO {

	
	@Select("select * from member order by idx")
	List<MemberDTO> selectList();
	
	
	//pstmt에 ?에 대응하는 두가지 표현식이 있다.
	//${}는 따옴표를 무조건 넣지 않는다.
	//#{}는 자료형에 따라 따옴표를 적절하게 처리해준다.
	@Select("select * from member "
			+ "where ${searchType} like '%' || #{searchKeyword} || '%' "
			+ "order by idx")
	List<MemberDTO> selectSearchList(HashMap<String, String> paramMap);

	@Select("select * from member where idx = #{idx} ")
	MemberDTO selectOne(int idx);
	
	@Insert("insert into member (userid,userpw,username, "
			+ "gender,email) values (#{userid},#{userpw},#{username},#{gender},#{email})") 
	int insert(MemberDTO dto);

	@Delete("delete from member where idx = #{idx}")
	int delete(int idx);

	@Update("update  member set  userid = #{userid}, userpw = #{userpw}, username = #{username}, gender = #{gender}, email = #{email}"
			+ "where idx = #{idx}")
	int update(MemberDTO dto);

	
	
}
