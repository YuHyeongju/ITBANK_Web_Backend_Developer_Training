package sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	private Connection con;
	private PreparedStatement pstmt;
	
	
	
	public List listMembers() {
		List list = new ArrayList();
		
		try {
			connDB();
			String query = "select * from t_member"; 
			System.out.println("prepareStatement" +  query);
			pstmt = con.prepareStatement(query); //변수를 미리 만들어놓고 사용
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo  = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	private void connDB() { //크롬에서 DB접속 요청을 할때 마다 실행됨
		try {
			Class.forName(driver);
			System.out.println("Oricle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user , pwd);
			System.out.println("Connection 생성 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
