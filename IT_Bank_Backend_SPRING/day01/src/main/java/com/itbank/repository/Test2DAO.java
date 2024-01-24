package com.itbank.repository;

import java.sql.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Test2DAO { // 가장 직관적인 코드  - > 번거로움 으로 인해 3방식을 사용함.
	
	@Autowired private SqlSessionTemplate sst;

	public String selectBanner() {
		
		//String sql ="select banner from v$version"; test2.xml에서 sql문을 가져오기 때문에 sql문 불필요
		
		// sst.selectOne("namespace.id");
		String version = sst.selectOne("test2.selectVersion");
		return version;
	}

	public Date selectSysdate() {
		Date sysdate = sst.selectOne("test2.selectSysdate");
		return sysdate;
	}
	
	
}
