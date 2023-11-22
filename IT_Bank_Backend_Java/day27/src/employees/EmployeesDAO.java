package employees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class EmployeesDAO {
	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "hr";
	private String password = "hr";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private void close() {

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

	private Connection getConnection() {
		try {
			Class.forName(OracleDriver.class.getName());
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("DB 연결 오류" + e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을수 없습니다." + e);
			e.printStackTrace();
		} 
		return conn;
	}

	public List<EmployeesDTO> selectAll() {
		ArrayList<EmployeesDTO> list = new ArrayList<>();
		String sql = "select first_name, salary, hire_date, extract(year from sysdate) - extract(year from hire_date) as jobLong  "
				+ "from employees order by jobLong";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeesDTO dto = new EmployeesDTO();
				dto.setFirst_name(rs.getString("first_name"));
				dto.setSalary(rs.getInt("salary"));
				dto.setHire_date(rs.getDate("hire_date"));
				dto.setJobLong(rs.getString("jobLong"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

}
