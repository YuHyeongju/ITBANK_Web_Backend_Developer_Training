package phonebook2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class PhonebookDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String username = "c##itbank";
	private String password = "it";

	public PhonebookDAO() {
		try {
			Class.forName(OracleDriver.class.getName());
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 불러올 수 없습니다." + e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속에 예외가 있습니다.");
			e.printStackTrace();
		}
	}

	public List<PhonebookDTO> selectList() throws Exception {
		ArrayList<PhonebookDTO> list = new ArrayList<>();
		// 추가할 데이터들을 넣을 리스트를 생성
		String sql = "select * from Phonebook order by idx";

		pstmt = conn.prepareStatement(sql); // sql문을 실행하는 코드
		rs = pstmt.executeQuery(); // select가 있을때만 rs사용

		while (rs.next()) {
			PhonebookDTO dto = new PhonebookDTO();
			dto.setIdx(rs.getInt("idx"));
			dto.setName(rs.getString("name"));
			dto.setPnum(rs.getString("pnum"));
			dto.setAge(rs.getInt("age"));
			dto.setFavorite(rs.getString("favorite"));
			list.add(dto); // 리스트에 dto를 add
		}

		return list;
	}

	public int insertPhonebook(PhonebookDTO dto) throws Exception {

		String sql = "insert into phonebook (name,pnum,age,favorite) values(?,?,?,?)";
		// 인덱스가 있기때문에 값을 지정해주어야함.
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getPnum());
		pstmt.setInt(3, dto.getAge());
		pstmt.setString(4, dto.getFavorite());

		int row = pstmt.executeUpdate();
		return row;

	}

	public int updatePnum(String name, String pnum) throws Exception {

		String sql = "update phonebook set pnum = ? where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pnum);
		pstmt.setString(2, name);
		int row = pstmt.executeUpdate();
		return row;
	}

	public int updateFavorite(String name) throws Exception {
		String sql = "update phonebook set favorite = " + "decode(favorite,'Y','N','N','Y')" + "where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		int row = pstmt.executeUpdate();
		return row;
	}

	public int delete(int idx) throws Exception {

		String sql = "delete phonebook where idx = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		int row = pstmt.executeUpdate();
		return row;
	}

}
