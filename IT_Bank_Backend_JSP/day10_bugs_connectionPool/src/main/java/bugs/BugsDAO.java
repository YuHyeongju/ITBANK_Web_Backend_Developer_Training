package bugs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BugsDAO {

	// 싱글톤: 페이지마다 같은 기능을 하는 서로 다른 객체가 생기지 않도록 처리(자원 낭비 방지)
	// 외부에서 DAO의 객체를 함부로 생성할 수 없도록 생성자의 접근제한자를 private로 수정해준다.
	// 인형뽑기 기계에 팔이 여러 개일 필요가 없다.

	private static BugsDAO instance = new BugsDAO();

	public static BugsDAO getInstance() {
		return instance;
	}

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Context init; // context.xml에서 작성한 내용대로의 객체를 포함하는 컨테이너
	private DataSource ds; // 여러 커넥션을 관리하는 DataSource 객체

	// 커넥션 풀: 요청이 들어올때 마다 새로운 커넥션을 생성하지 말고,
	//			미리 충분히 사용할 만큼 커넥션을 생성해두고, 돌려가면서 사용하기 위해서
	// 고기집에서 불판에 바로 올려주기위한 상태의 고기를 미리 준비하는 것.
	// 요청이 들어왔을 때 그제서야 준비를 하면 늦다.
	
	public BugsDAO() {
		try {
			init = new InitialContext(); // init 객체 생성
			// init의 lookup메서드를 사용하여 "java:comp/env/jdbc/oracle"에 해당하는 
			// 객체를 찾아서 ds에 저장
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
			// 반환형 object타입 -> 안에 무슨 형의 자원이 들어올지 모르니 object로 반환
			// -> 다운캐스팅 하여 사용
			// lookup 함수가 작동할 때, web.xml을 참고하여 찾음. 
		} catch (NamingException e) {
			System.out.println("지정한 이름의 객체를 찾을 수 없습니다.: " + e);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public BugsDTO mapping(ResultSet rs) throws Exception {
		BugsDTO dto = new BugsDTO();
		dto.setId(rs.getInt("id"));
		dto.setArtist_name(rs.getString("artist_name"));
		dto.setArtist_img(rs.getString("artist_img"));
		dto.setAlbum_img(rs.getString("album_img"));
		dto.setAlbum_name(rs.getString("album_name"));
		dto.setName(rs.getString("name"));
		dto.setGenre(rs.getString("genre"));
		dto.setPlayTime(rs.getInt("playTime"));
		dto.setLyrics(rs.getString("lyrics"));
		dto.setIsTitle(rs.getInt("isTitle"));
		return dto;
	}

	public List<BugsDTO> selectAll(String search) {
		ArrayList<BugsDTO> list = new ArrayList<>();
		String sql = "select * from bugs where name like '%' || ? || '%' or artist_name like '%' || ? || '%' order by artist_name,id";
		try {
			conn = ds.getConnection(); // 커넥션을 관리하는 ds가 생김 -> ds에게 커넥션을 달라고 요청함.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(mapping(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		// System.out.printf("불러온 목록의 개수: " + list.size());
		return list;
	}
	public BugsDTO selectOne(int id){
		BugsDTO dto = null;
		String sql = "select * from bugs where id = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = mapping(rs); //하나 들고와서 
				return dto;        //  바로 반환 
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {  // while의 리턴에서 함수가 종료되었지만 
			close(); // finally는 실행되고 나서 종료된다.
		}
		return dto;
	}
	
	public int insert(BugsDTO dto) {
		int row = 0;
		String sql = "insert into (artist_name,artist_img,album_img,album_name,genre,playTime,lyrics,isTitle)"
				+ "		values(?,?,?,?,?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getArtist_img());
			pstmt.setString(2, dto.getArtist_name());
			pstmt.setString(3, dto.getAlbum_img());
			pstmt.setString(4, dto.getAlbum_name());
			pstmt.setString(5, dto.getName());
			pstmt.setString(6, dto.getGenre());
			pstmt.setInt(7, dto.getPlayTime());
			pstmt.setString(8, dto.getLyrics());
			pstmt.setInt(9, dto.getIsTitle());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return row;
	}
	
	public int delete(int id) {
		int row =0;
		String sql = "delete bugs where id = ?";
		try {
			conn = ds.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			// sql이 select면 excuteQuery(); -- ResultSet형태 반환
			// sql이 insert/update/delete면 executeUpdate();이다.
			// -- int 형태 반환
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
}
