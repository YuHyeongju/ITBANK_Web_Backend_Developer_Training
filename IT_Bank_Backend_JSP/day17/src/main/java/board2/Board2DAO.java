package board2;

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

public class Board2DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Context init;
	private DataSource ds;
	
	
	private static Board2DAO instance = new Board2DAO();
	
	public static Board2DAO getInstance() {
		return instance;
	}
	
	
	public Board2DAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
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
	public Board2DTO mapping(ResultSet rs) throws SQLException{
		Board2DTO dto = new Board2DTO();
		dto.setIdx(rs.getInt("idx"));
		dto.setTitle(rs.getString("title"));
		dto.setWriter(rs.getString("writer"));
		dto.setContent(rs.getString("content"));
		dto.setImage(rs.getString("image"));
		dto.setViewCount(rs.getInt("viewCount"));
		dto.setWriteDate(rs.getDate("writeDate"));
		dto.setIpaddr(rs.getString("ipaddr"));
		return dto;
	}
	
	public List<Board2DTO> selectList(String search){
		ArrayList<Board2DTO> list = new ArrayList<>();
		String sql = "select * from board2 "			// 검색 기능 포함
				+ "where "
				+ "		title like '%' || ? || '%' or "
				+ "		writer like '%' || ? || '%' or "
				+ "		content like '%' || ? || '%'  "		
				+ "order by idx desc";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, search);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(mapping(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		
		}
		return list;
	}
	// 단일 게시글 불러오기 (ip주소 일부 가리기)
	public Board2DTO selectOne(int idx) {
		Board2DTO dto =null;
		String sql = "select * from board2 where idx = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = mapping(rs);
				dto.setIpaddr(maskIPaddr(dto.getIpaddr()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	private String maskIPaddr(String src) { // 아이피 주소 원본 (DB에서 가져온 값)
		String dst = ""; 
		int dotCount = 0;
		for(int i = 0; i < src.length(); i++) { 
			char ch = src.charAt(i);	// src를 i번째 문자열을 하나 꺼내 ch에 저장
			if(ch == '.') dotCount +=1;	// 만약 ch가 . 이면 dotCount 1 증가
			if(dotCount >= 2 && '0' >= ch && ch<= '9') {	// dotCount가 2이상이고(ip에서 3번째 자리)
				dst += '*';									// ch가 0 ~ 9의 문자일 때
															// dst에 * 추가
			}else {											// 아닐 경우
															// 그대로 dst에 추가								
				dst += ch;
			}
			
		}
		
		return dst;// 뒷자리 숫자를 자릿수 맞추어서 * 로 바꾼 문자열
	}
	
	
	
	
	
	
	
	public int insert(Board2DTO dto) {
		int row = 0;
		String sql = "insert into board2 (title, writer, content, image,ipaddr) values(?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString (1, dto.getTitle());
			pstmt.setString(2,dto.getWriter());
			pstmt.setString(3,dto.getContent());
			pstmt.setString(4,dto.getImage());
			pstmt.setString(5,dto.getIpaddr());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return row;
	}
	public int modify(Board2DTO dto) {
		int row = 0;
		String sql = "update board2 set title= ?,content= ?, image = ? ";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getImage());
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return row;
	}
	
	public int delete (int idx) {
		int row = 0;
		String sql = "delete from board2 where idx = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return row;
	}
}
