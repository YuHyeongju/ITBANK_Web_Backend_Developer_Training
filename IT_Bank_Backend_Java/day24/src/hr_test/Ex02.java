package hr_test;

import java.util.List;


// 1번과 2번의 공통점: 클래스를 만들지 않아도 되는 형식



public class Ex02 {

	public static void main(String[] args) {

		JdbcTemplate template = new JdbcTemplate();

		String sql = "select tname from tab"; // 테이블 이름들을 불러옴
		
		RowMapper<String> mapper = (rs) -> { // 단일 객체(단일 레코드, 줄)에 대한 맵핑 규칙이다.
											 // 보통 mapper에서는 while을 사용하지 않음.
											 // while에서 작성하는 내용을 넣에주면 된다.
			return rs.getString("tname");

		};
		List<String> tableNameList = template.queryForList(sql, mapper);
		tableNameList.forEach(System.out::println);

	}

}
