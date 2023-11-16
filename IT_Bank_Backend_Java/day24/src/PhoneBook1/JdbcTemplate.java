package PhoneBook1;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class JdbcTemplate { // jdbc의 사용을 단순화하고 일반적인 오류를 방지하는데 도움이 됨.
							// 개발자가 jdbc를 사용할 때 발생하는 다음과 같은 반복작업을 대신 처리
							//	커넥션 획득
							//	statement를 준비하고 실행
							//	결과를 반복하도록 루프를 실행
							//	커넥션 종료, statement 및 resultset 종료
							//	트랜잭션을 다루기 위한 커넥션 동기화
							//	예외 발생 시 스프링 예외 변환기 실행
	
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

	/**
	 * 
	 * @param <T>       : DTO CLASS, 단일 , DTO 클래스
	 * @param sql       : SQL to run, 실행할 SQL
	 * @param rowMapper : how to mapping Relational to Object in JAVA(lamda)
	 * @return : List<DTO>, 여러 DTO를 List 형태로 전환
	 */

	public <T> T queryForObject(String sql, RowMapper<T> rowMapper) {
		T ob = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()) {					// 다음 값이 있는지 확인하고 값을 가져가려고해라 
			 ob = rowMapper.mapper(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return ob;
	}

	/**
	 * 
	 * @param <T>       : DTO CLASS, 단일 , DTO 클래스
	 * @param sql       : SQL to run, 실행할 SQL
	 * @param rowMapper : how to mapping Relational to Object in JAVA(lamda)
	 * @return : List<DTO>, 여러 DTO를 List 형태로 전환
	 */

	public <T> ArrayList<T> queryForList(String sql, RowMapper<T> rowMapper) {
		ArrayList<T> list = new ArrayList<>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				T ob = rowMapper.mapper(rs);
				list.add(ob);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return list;
	}
	/**
	 * 
	 * @param sql : SQL to run, 실행할 SQL
	 * @param args : PreparedStatement에 Sql을 올려둔 후 ?에 해당하는 값들을 가변인자로 전달(Object) 
	 * @return: SQL(insert, update, delete)에 영향을 받은 줄 수 (count of affected row, int)
	 */
	public int update(String sql, Object... args) {
		int seq = 0;
		int row = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				switch (args[i].getClass().getName()) {
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
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return row;
	}

}
