package ex03;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ex03DAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "hr";
	private String password = "hr";

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		// 예외처리를 처리해 줄 상위 요소가 있으면 throws하여 던져버릴 수 있지만 처리해줄 상위 요소가 없을 경우
		// 자신이 직접 try catch를 처리함.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url, user, password);

		return conn;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getDBversion() {
		String answer = "null";
		String sql = "select banner from v$version";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				answer = rs.getString("banner");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return answer;
	}

	public List<EmployeeDTO> getEmployeeList() {
		ArrayList<EmployeeDTO> list = new ArrayList<>();
		String sql = "select * from employees";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setCommission_pct(rs.getDouble("commission_pct"));
				dto.setDepartment_id(rs.getInt("department_id"));
				dto.setEmail(rs.getString("email"));
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setHire_date(rs.getDate("hire_date"));
				dto.setJob_id(rs.getString("job_id"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setManager_id(rs.getInt("manager_id"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setSalary(rs.getDouble("salary"));
				list.add(dto);

			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}finally {
			close();
		}
		

		return list;
	}
}
