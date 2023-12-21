package bugs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class BugsDAO {
	
	
	private String url="jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Connection getConnection() throws Exception {
		Class.forName(OracleDriver.class.getName());
		return DriverManager.getConnection(url,user,password);
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
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
	
	
	 /*List<BugsDTO> selectAll*/
	 /* select * from bugs order by artist_name ,id; */
	public List<BugsDTO> selectAll(String search){
		ArrayList<BugsDTO> list = new  ArrayList<>();
		String sql = "select * from bugs where name like '%' || ? || '%' or artist_name like '%' || ? || '%' order by artist_name,id";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapping(rs));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close();
		}
		//System.out.printf("불러온 목록의 개수: " + list.size());
		return list;
	}
	/*List<BugsDTO> selectListBySearch(String search)*/
	/*select * from bugs where 
	 * 						name like '%' || ? || '%'
	 * 						or artist_name like '%' || ? || '%'
	 */
	 // 전체조회와 검색을 위에서 하나로 합침
	
	
	/*BugsDTO selectOne(int id)*/
	/*select * from bugs where id = ?*/
	public BugsDTO selectOne(int id) {
		BugsDTO dto = null;
		String sql = "select * from bugs where id = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = mapping(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	/*int insert(BugsDTO dto)
	/*insert into bugs (...) values(?, ...)*/
	public int insert (BugsDTO dto) {
		int row = 0;
		String sql = "insert into bugs "
				+ "(artist_name,artist_img,album_img,album_name,"
				+ "name,genre,playTime,lyrics,isTitle) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getArtist_name());
			
			pstmt.setString(2, dto.getArtist_img());
			pstmt.setString(3, dto.getAlbum_name());
			//아티스트 이미지와 앨범이미지에 default.img를 걸어놓았는데
			// 이 이미지가 뜨게하기위해서는 여기서 setString해서줘서는 안된다.
			// 따라서 지금 상태에서는 무조건 값을 넣는 수 밖에 없다.
			pstmt.setString(4, dto.getAlbum_img());
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
	
	/*int modify(BugsDTO dto)
	/*update bugs set artist_name=?, ... where id =?*/
	
	public int modify(BugsDTO dto) {
		int row =0;
		String sql = "update bugs"
				+ "		set"
				+ "			artist_name = ?,"
				+ "			album_name = ?,"
				+ "			name = ?,"
				+ "			genre = ?,"
				+ "			playTime = ?,"
				+ "			isTitle = ?,"
				+ "			lyrics = ?"
				+ "		where"
				+ "			id = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getArtist_name());
			pstmt.setString(2, dto.getAlbum_name());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getGenre());
			pstmt.setInt(5, dto.getPlayTime());
			pstmt.setInt(6, dto.getIsTitle());
			pstmt.setString(7, dto.getLyrics());
			pstmt.setInt(8, dto.getId());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}		
				
		return row;
	}
	
	/*int delete(int id)*/
	/*delete from bugs where id = ?*/
	public int delete(int id) {
		int row = 0;
		String sql ="delete from bugs where id = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return row;
	}
	/* int selectNextseq()*/
	/*select max(id) from bugs*/
	public int selectNextseq(){
		int id = 0;
		String sql = "select max(id) from bugs";
		
		try {
			conn =getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id =rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return id;
	}
	
}
