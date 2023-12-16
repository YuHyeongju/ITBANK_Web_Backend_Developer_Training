package product;

import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.OracleDriver;

public class ProductDAO {

	private String url = "jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public Connection getConnection() throws Exception {
		Class.forName(OracleDriver.class.getName());
		return DriverManager.getConnection(url, user, password);
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ProductDTO mapping(ResultSet rs) throws Exception {
		ProductDTO dto = new ProductDTO();

		dto.setIdx(rs.getInt("idx"));
		dto.setName(rs.getString("name"));
		dto.setPrice(rs.getInt("price"));
		return dto;

	}

	public List<ProductDTO> selectAll() {
		ArrayList<ProductDTO> list = new ArrayList<>();
		String sql = "select * from product";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(mapping(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public int insert(ProductDTO dto) {
		int row = 0;
		String sql = "insert into product(name,price) values(?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getPrice());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}
	public int update(ProductDTO dto) {
		int row=0;
		String sql = "update product set name=?,price=? where idx=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getIdx());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getPrice());
			
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return row;
	}
	public int delete(int idx) {
		int row = 0;
		String sql="delete product where idx=?";
		try {
			conn = getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return row;
	}
	
	public ProductDTO selectOne(int idx) {
		String sql = "select * from product where idx = ?";
		ProductDTO dto = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = mapping(rs); // 특정인덱스의 값을 dto에 넣기
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}

	public int selectNextseq() {
		int idx = 0;
		String sql = "select max(idx) from product";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				idx = rs.getInt(1); //현재 컬럼을 불러옴
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return idx;
	}
}
