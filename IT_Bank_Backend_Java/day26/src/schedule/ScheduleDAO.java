package schedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleDAO {
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("연결 문제 발생" + e);
		}
		return conn;
	}

	private void close() { // 내부에서만 작동하는 함수
		try { // 자주 사용되고 내용이 똑같거나, 일정구간만 다르다면 함수로 묶어서 처리
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {

		}
	}

	public List<ScheduleDTO> selectAll() {
		ArrayList<ScheduleDTO> list = new ArrayList<>();
		String sql = "select * from schedule order by start_date asc";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				ScheduleDTO dto = new ScheduleDTO();
				dto.setTitle(rs.getString("title"));
				dto.setStart_date(rs.getDate("start_date"));
				dto.setEnd_date(rs.getDate("end_date"));
				list.add(dto);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public String getVersion() {
		String sql = "select banner from v$version";
		String version = null; // 첫 줄에 반환형의 변수를 만들고 (초기화 필요)

		// 연결(conn)해서 sql을 실행 (pstmt.excuteQuery())하고 결과(rs)를 반환
		try {
			conn = getConnection(); // 연결
			pstmt = conn.prepareStatement(sql); // pstmt에 sql 적재(실행할 준비)
			rs = pstmt.executeQuery(); // 쿼리 실행 후 결과 받기

			while (rs.next()) {
				version = rs.getString("banner");

			}

		} catch (Exception e) {
			System.out.println("db 연결 오류" + e);
			e.printStackTrace();

		}

		return version; // 마지막줄에 해당 변수의 값을 반환함.
	}

	public Date selectSysdate() {
		Date sysdate = null; // 초기화
		String sql = "select sysdate from dual";
		try {
			conn = getConnection(); // 연결해서
			pstmt = conn.prepareStatement(sql); // SQL을 실행할 준비
			rs = pstmt.executeQuery(); // 실행해서 결과 받기

			// 결과 안에 내가 우너하는 데이터가 있으면
			// 이 함수는 Date타입의 함수를 반환해야함.
			while (rs.next()) {
				sysdate = rs.getDate("sysdate");
			}
		} catch (Exception e) {
			System.out.println("날짜 불러오기 오류 발생" + e);
		} finally {
			close();
		}
		return sysdate;

	}

	public int insertSchedule(ScheduleDTO dto) {
		int row = 0;
		String sql = "insert into schedule values(?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setDate(2, new java.sql.Date(dto.getStart_date().getTime()));
			pstmt.setDate(3, new java.sql.Date(dto.getEnd_date().getTime()));
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("DB 연결 오류" + e);
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public int deleteSchedule(String title) {
		int row = 0;
		String sql = "delete schedule where title = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			row = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public List<ScheduleDTO> selectMonth(int month) {
		ArrayList<ScheduleDTO> list = new ArrayList<>();
		
		String sql = "select * from schedule where extract(month from start_date) = ?"
				+ "order by start_date desc";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, month);
			rs = pstmt.executeQuery();
			
			
			
			
			while(rs.next()) {
				ScheduleDTO dto = new ScheduleDTO();
				dto.setTitle(rs.getString("title"));
				dto.setStart_date(rs.getDate("start_date"));
				dto.setEnd_date(rs.getDate("end_date"));
				list.add(dto);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

}
