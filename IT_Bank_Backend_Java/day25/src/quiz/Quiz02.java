package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Quiz02 {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
		String user = "c##itbank";
		String password = "it";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, user, password);

		String sql = "select sysdate from dual";
		// 주어진 SQL문을 활용하여 실행한 시점의 시간을 화면에 출력하세요.
		// 자료형은 문자열로 처리하면 됩니다.

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		String sysdate = null;
		while (rs.next()) {
			sysdate = rs.getString("sysdate");
		}
		System.out.println(sysdate);
		rs.close();
		pstmt.close();
		conn.close();
	}

}
