package youtube;

import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.OracleDriver;

public class YoutubeDAO {
	
	private String url="jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user="c##itbank";
	private String password="it";
	
	private Connection conn ;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Connection getConnection() throws Exception {
		Class.forName(OracleDriver.class.getName());
		return DriverManager.getConnection(url,user,password);
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			
		}
	}
	
	public YoutubeDTO mapping(ResultSet rs) throws SQLException {
		YoutubeDTO dto = new YoutubeDTO();
		dto.setIdx(rs.getInt("idx"));
		dto.setTitle(rs.getString("title"));
		dto.setName(rs.getString("name"));
		dto.setThumbnail(rs.getString("thumbnail"));
		dto.setTag(rs.getString("tag"));
		return dto;
	}
	
	
	public List<YoutubeDTO> selectList(){
		ArrayList<YoutubeDTO> list = new ArrayList<>();
		String Sql = "select * from youtube";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(Sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapping(rs));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public YoutubeDTO selectOne(int idx) {
		String sql="select * from youtube where idx=?";
		YoutubeDTO dto = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
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
	
	public int insert(YoutubeDTO dto) {
		int row = 0;
		String sql = "insert into youtube (title,name,thumbnail,tag) values(?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getThumbnail());
			pstmt.setString(4, dto.getTag());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return row;
	}
	public int delete(int idx) {
		int row = 0;
		String sql = "delete youtube where idx =?";
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return row;		
	}
	public int update(YoutubeDTO dto) {
		int row=0;
		String sql = "update youtube set title=?,name=?,thumbnail=?,tag=? where idx= ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getTitle());
			pstmt.setString(2,dto.getName());
			pstmt.setString(3,dto.getThumbnail());
			pstmt.setString(4,dto.getTag());
			pstmt.setInt(5, dto.getIdx());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return row;
	}
	public int selectCurrSeq() {
		int idx = 0;
		String sql = "select max(idx) from youtube";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				idx = rs.getInt(1);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return idx;
	}
	
	public List<YoutubeDTO> search(String title){
		ArrayList<YoutubeDTO> list = new ArrayList<>();
		String Sql = "select * from youtube where title like '%' || ? || '%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapping(rs));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	} 
	
	
	
}
