package com.itbank.repository;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate; // root-context.xml안에 jdbcTemplelate를 참조하게 함.

	public String selectBanner() {
		String sql = "select banner from v$version";

//		RowMapper<String> rowMapper = new RowMapper<String>() { // 익명내부 클래스를 만들어서 함수 반환
//			
//			@Override
//			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//				
//				return rs.getString("banner");
//			}
//		};

		// 함수형 인터페이스 -> 람다식 사용가능

		RowMapper<String> rowMapper = (rs, rownum) -> rs.getString("banner");

		// 람다식을 사용하여 익명클래스를 생성할 필요없이 간단하게 작업 가능

		String version = jdbcTemplate.queryForObject(sql, rowMapper); // rowMapper: jsp에서의 매핑 함수 역할
		
		return version;
	}

	public Date selectSysdate() {
		String sql ="select sysdate from dual";
		
		RowMapper<Date> rowMapper = (rs, rownum) -> rs.getDate("sysdate");
		
		// Date sysdate = jdbcTemplate.queryForObject(sql, Date.class);
		
		Date sysdate = jdbcTemplate.queryForObject(sql, rowMapper);
		// Date sysdate = jdbcTemplate.queryForObject(sql, (rs, rownum) -> rs.getDate("sysdate"));
		
		return sysdate;
	}
}
