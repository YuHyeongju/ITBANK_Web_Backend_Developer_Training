package hr_test;

public class Ex01 {
	public static void main(String[] args) {
		// select banner from v$version;
		// 단일 문자열을 불러와서 출력하기

		JdbcTemplate template = new JdbcTemplate();

		// param 1 실행할 sql 준비
		String sql = "select banner from v$version"; // 실행할 sql 준비
		
		// select 한 결과를 rs에 무조건 반환

		// 단일 데이터를 불러오는 queryForobject 함수를 사용한다.
		// sql과 RowMapper 객체를 전달하면 된다.
		// RowMapper객체는 결과를 rs에 불러왔을 때 어떤 형식으로 맵핑할지 결정해서
		// 추상메서드를 오버라이딩으로 구현하는 형태로 만들어주면 됨.
		// param 2 : rs에 담긴 결과를 어떻게 맵핑하여 반환하는가?(규칙을 담고있는 함수)
		// 매핑: 해당값이 다른 값을 가르키게 하는 작업
//		RowMapper<String> mapper = (rs) -> {
//			
//			return rs.getString("banner");
//			
//			 
//		};
		RowMapper<String> mapper = rs -> rs.getString("banner");		// 매개변수 하나 : 소괄호 생략
																		// 문장이 한 문장 : 중괄호 생략 
																		// return 문장 한 문장 : return문 생략
		String result = template.queryForObject(sql, mapper);			

		System.out.println(result);
	}
}
