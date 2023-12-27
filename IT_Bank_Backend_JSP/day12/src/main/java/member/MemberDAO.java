package member;

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

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Context init;
	private DataSource ds;

	public MemberDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			System.out.println("지정한 이름의 객체를 찾을 수 없습니다.");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();

			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberDTO mapping(ResultSet rs) throws Exception {
		MemberDTO dto = new MemberDTO();
		dto.setUserid(rs.getString("userid"));
		dto.setUserpw(rs.getString("userpw"));
		dto.setGender(rs.getString("gender"));
		dto.setUserName(rs.getString("userName"));
		dto.setEmail(rs.getString("email"));
		return dto;
	}

	public List<MemberDTO> selectlist(MemberDTO dto) {
		ArrayList<MemberDTO> list = new ArrayList<>();
		String sql = "select * from Member order by userid";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(mapping(rs));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public MemberDTO login(String userid, String userpw) {
		MemberDTO dto = null;
		String sql = "select * from member where userid = ? and userpw = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpw);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = mapping(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return dto;

	}
	
	public int update (MemberDTO dto) {
		int row = 0;
		String sql = "update member set"
				+ "userid = ?, userpw = ? ,  userName = ? , gender =? , email=?"
				+ "where userid = ? and userpw = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserpw());
			pstmt.setString(2, dto.getUserName());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getEmail());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return row;
	}
	
	public int delete(String userid) {
		int row = 0;
		String sql = "delete member where userid = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		return row;
	}
}
