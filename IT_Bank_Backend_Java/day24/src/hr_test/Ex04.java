package hr_test;

public class Ex04 {

	public static void main(String[] args) {
		// countries 테이블에 insert 하기
		
		JdbcTemplate template = new JdbcTemplate();
		
		String sql = "insert into countries values (?,?,?)";
		
		int row = template.update(sql, "KR", "South Korea", 3);
		
		System.out.println("결과 : " + row);

	}

}
