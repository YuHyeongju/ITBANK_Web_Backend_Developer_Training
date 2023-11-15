package book7;

import java.util.ArrayList;

// Oracle전용 접속 드라이버는 라이브러리 파일을 가져와야 한다

public class BookDAO {

	private JdbcTemplate template = new JdbcTemplate();
	
	// 전체 목록 불러오기
	public ArrayList<BookDTO> selectList() {
		String sql = "select * from book";
		
		RowMapper<BookDTO> mapper = rs -> {
			BookDTO dto = new BookDTO();
			dto.setAuthor(rs.getString("author"));
			dto.setName(rs.getString("name"));
			dto.setPrice(rs.getInt("price"));
			dto.setPublisher(rs.getString("publisher"));
			return dto;
		};
		
		return template.queryForList(sql, mapper);
	}

	// 전달받은 객체를 DB에 저장하기
	public int insertBook(BookDTO dto) {
		int row = 0;
		String sql = "insert into book values (?, ?, ?, ?)";	// 쿼리문 형식만 준비
		row = template.update(sql, dto.getName(), dto.getAuthor(), dto.getPublisher(), dto.getPrice());
		return row;
	}

	public int deleteBook(String name) {
		int row = 0;
		String sql = "delete book where name = ?";
		row = template.update(sql, name);
		return row;
	}
	
}














