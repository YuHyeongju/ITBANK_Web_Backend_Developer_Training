package date;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex04 {
	public static void main(String[] args) throws Exception {
		String sql = "select sysdate from dual";
		String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url,"c##itbank","it");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		String sysdate1 = null;
		Date sysdate2 = null;
		
		while(rs.next()) {
			sysdate1 = rs.getString("sysdate");
			sysdate2 = rs.getDate("sysdate"); 	// Date타입으로 변환되면서 시간정보가 생략됨
		}
		System.out.println("sysdate1: " + sysdate1);
		System.out.println("sysdate2: " + sysdate2);
		rs.close();
		pstmt.close();
		conn.close();
	}
}
