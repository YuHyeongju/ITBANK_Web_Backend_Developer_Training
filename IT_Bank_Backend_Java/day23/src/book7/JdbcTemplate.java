package book7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class JdbcTemplate {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String username = "c##itbank";
	private String password = "it";
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(OracleDriver.class.getName());
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			System.out.println("SQL 접속 예외 : " + e);
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 불러올 수 없습니다 : " + e);
			e.printStackTrace();
		} 
		return conn;
	}

	public <T> T queryForObject(String sql, RowMapper<T> rowMapper) {
		T ob = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ob = rowMapper.mapper(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		
			try {
				if(rs != null) rs.close();	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
		return ob;
	}
	
	public <T> ArrayList<T> queryForList(String sql, RowMapper<T> rowMapper) {
		ArrayList<T> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				T ob = rowMapper.mapper(rs);
				list.add(ob);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		
			try {
				if(rs != null) rs.close();	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
		return list;
	}
	
	public int update(String sql, Object... args) {
		int seq = 0;
		int row = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++) {
				switch(args[i].getClass().getName()) {
				case "java.lang.Integer":
					pstmt.setInt(++seq, Integer.parseInt(args[i].toString()));
					break;
				default:
					pstmt.setString(++seq, args[i].toString());
				}
			}
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {		
			try {
				if(rs != null) rs.close();	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {}
		}
		return row;
	}

}
