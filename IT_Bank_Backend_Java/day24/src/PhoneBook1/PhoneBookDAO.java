package PhoneBook1;

import java.util.List;

public class PhoneBookDAO {
	JdbcTemplate template = new JdbcTemplate();

	public List<PhoneBookDTO> selectList() {

		String sql = "select * from PhoneBook order by favorite desc, name";

		RowMapper<PhoneBookDTO> mapper = (rs) -> {	// DB에서 데이터 받아와서 매핑하여 리스트에 넣기
			PhoneBookDTO dto = new PhoneBookDTO();	// 매퍼가 인터페이스 이므로 익명클래스로 rs를 받아와서 구현
			dto.setName(rs.getString("name"));
			dto.setPnum(rs.getString("pnum"));
			dto.setAge(rs.getInt("age"));
			dto.setFavorite(rs.getString("favorite"));
			return dto;
		};

		List<PhoneBookDTO> list =  template.queryForList(sql, mapper); // 쿼리문의 결과가 다중일 때  사용
		return list;
	}

	public int insert(PhoneBookDTO dto) {	// 이름, 전화번호, 나이, 즐겨찾기 추가
		String sql = "insert into phonebook values (?,?,?,?)";
		int row = template.update(sql, dto.getName(),dto.getPnum(),
				dto.getAge(),dto.getFavorite());
		return row;
	}
	
	public int delete(String name) {	// 핸들러로 부터 받은 이름을 가지고 명령문 실행 후 삭제
		
		
		String sql = "delete from phonebook where name = ?";
		
		int row = template.update(sql, name);
		
		return row;
	}
	
	public int updatePnum(PhoneBookDTO dto) {	// 핸들러로 부터 에서 전화번호 이름 전달받았으니 db에 반영 결과 반환
		int row;
		String sql = "update phone set pnum = ? where name = ?";
		Object[] args = {dto.getPnum(), dto.getName()};
		row = template.update(sql, args);
		
		return  row;
	}
	public int updatefavorite(String name) {	// 핸들러로 부터 받은 이름으로 명령문 실행하고 결과 반환 
		int row;
		String sql = "update phonebook set favorite = decode(favorite, 'Y','N','N','Y')"
				+ "where name = ?";
		
		row = template.update(sql, name);
		return row;
	}



}
