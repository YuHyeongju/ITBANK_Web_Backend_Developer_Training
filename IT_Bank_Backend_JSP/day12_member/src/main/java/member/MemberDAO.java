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
	// MemberDAO의 객체는 오직 하나뿐이다.
	
	public static MemberDAO getInstance() { // 객체를 반환하는 함수 getInstance()는 외부에서 호출가능
		return instance;
	}
	
	
	private Connection conn ;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Context init;
	private DataSource ds;
	
	// DAO는 DB에 접속하기 위해 Connection이 필요하다.
	// Connection을 미리 생성하여 관리하는 DataSource 객체는 context.xml에 정의 되어 있다.
	// 미리 준비한 DataSource를 자바 객체로 불러오기 위해서는 [Context]를 객체화해서 불러와야한다.
	// Connection 이후에는 이전 순서대로 [PrepareStatement],[ResultSet] 등이 필요하다.
	
	// 1) context.xml의 내용을 자바 객체로 불러온다. new InitialContext();
	// 2) context.xml에 작성한 DataSource 객체를 지정한 이름"jdbc/oracle"로 불러온다.
	// 3) context.xml에 정의한 객체는 이름 앞에 접두사를 붙여야 한다. "java:comp/env/"
	// 4) Object 타입을 반환하기 때문에 좌우의 자료형을 맞추기위해 다운캐스팅을 해야한다.(예외처리 필수) 
 	
	
	private MemberDAO() { // 생성자 외부 호출 금지
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			System.out.println("지정한 이름의 객체를 찾을 수 없습니다.");
		}finally {
			if(conn != null) {
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
			if(rs != null) {
				rs.close();
				
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberDTO mapping(ResultSet rs) throws Exception  {
		MemberDTO dto = new MemberDTO();
		dto.setUserid(rs.getString("userid"));
		dto.setUserpw(rs.getString("userpw"));
		dto.setGender(rs.getString("gender"));
		dto.setUserName(rs.getString("userName"));
		dto.setEmail(rs.getString("email"));
		return dto;		
	}
	
	public List<MemberDTO> selectList(){
		ArrayList<MemberDTO> list = new ArrayList<>();
		String sql = "select * from Member";
		try {
			conn  = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapping(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public MemberDTO login(MemberDTO dto) {
		MemberDTO login = null;
		String sql = "select * from member where userid = ? and userpw = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getUserpw());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				login = mapping(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return login;	
	}
	
	public MemberDTO selectOne(String userid) {
		MemberDTO dto = null;
		String sql="select * from member where userid = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
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
	
	
	
	public int insert(MemberDTO dto) {
		int row = 0;
		String sql = "insert into member(userid,userpw,username,gender,email) values"
				+ "(?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getUserpw());
			pstmt.setString(3, dto.getUserName());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getEmail());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
			
				
		return row;
		
	}
	
	public int update(MemberDTO dto) {
		int row = 0;
		String sql = "update member set userpw = ?, userName = ?, gender = ?, email =?"
				+ "where userid = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserpw());
			pstmt.setString(2, dto.getUserName());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getUserid());
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
