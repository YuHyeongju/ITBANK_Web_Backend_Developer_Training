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
import javax.sql.DataSource;import oracle.net.jdbc.TNSAddress.SOException;

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
		dto.setDeleted(rs.getInt("deleted"));
		return dto;
	}
	
	public List<Board2DTO> selectList(String search, Paging paging ){
		ArrayList<Board2DTO> list = new ArrayList<>();
		String sql = "select * from board2 "			// 검색 기능 포함
				+ "where "
				+ "		deleted = 0 and"				
				+ "		(title like '%' || ? || '%' or "
				+ "		writer like '%' || ? || '%' or "
				+ "		content like '%' || ? || '%')  "		
				+ "order by idx desc "
				+ "offset ? rows "
				+ "fetch next ? rows only";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, search);
			pstmt.setInt(4, paging.getOffset());
			pstmt.setInt(5, paging.getFetch());
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
	
	//게시글 갯수 불러오기
	public int selectCount(String search) {
		int count = 0;
		
		String sql = "select count(*) from board2 "			
				+ "where "
				+ "		deleted = 0 and"				
				+ "		(title like '%' || ? || '%' or "
				+ "		writer like '%' || ? || '%' or "
				+ "		content like '%' || ? || '%')  ";		
		try {
			conn =ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, search);
			rs = pstmt.executeQuery();		
			while(rs.next()) {
				count = rs.getInt(1);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return count;
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
			if(dotCount >= 2 || '0' >= ch && ch<= '9') {	// dotCount가 2이상이고(ip에서 3번째 자리)
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
		String sql = "update board2 set title= ?,content= ?, image = ? where idx = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getImage());
			pstmt.setInt(4, dto.getIdx());
			row = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return row;
	}
	
	//삭제: 리스트를 불러올때 , deleted 값이 0인 항목만 불러오면 된다.
	// 0이면 1로, 1이면 0으로 변경
	public int delete (int idx) {
		int row = 0;
		String sql = "update board2 set deleted = 1-deleted where idx = ? ";
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
	public List<Board2DTO> selectListByWriter(String writer,Paging paging){
		ArrayList<Board2DTO> list  = new ArrayList<>();
		String sql ="select * from board2 where writer = ? order by writer "
				+ "offset ? rows "
				+ "fetch next ? rows only";									// 페이징 기능 추가
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setInt(2, paging.getOffset());
			pstmt.setInt(3, paging.getFetch());
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
}
