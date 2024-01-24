package com.itbank.repository;

import java.sql.Date;

import org.apache.ibatis.annotations.Select;


public interface Test3DAO { // 모든 멤버의 접근제한자는 public이다.
							// 모든 메서드는 static final이다.
	
	// sqlSesionTemplate을 직접 참조 할때 와 같이 xml mapper를 사용하는 방법
	// namespace: package + Interface Name(com.itbank.repository.Test3DAO)
	// id: 함수 이름(selectBanner)					(실무에서 사용하는 방식)
	String selectBanner();/*
							 { return sst.selectOne("com.itbank.repository.Test3DAO.selectBanner"); }
						  */
	
	// 간단한 sql은 어노테이션으로 처리하여 mapper도 생략할 수있다.(우리가 원하는 방식)
	@Select("select sysdate from dual")
	Date selectSysdate();
	
}
//인터페이스는 기본생성자로 객체를 생성할 수 없음.

//마이바티스 프록시 객체 (대리인)