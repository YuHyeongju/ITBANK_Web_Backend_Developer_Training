package reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReplyDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Context init;
	private DataSource ds;
	
	public static ReplyDAO instance = new ReplyDAO();
	
	public static ReplyDAO getInstance() {
		return instance;
	}
	
	
	public ReplyDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void close(){
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// 게시글의 번호를 전달받아서, 해당 게시글에 달린 댓글 목록을 불러오는 함수
	public List<ReplyDTO> selectList(int board_idx){
		ArrayList<ReplyDTO> list = new ArrayList<>();
		String sql = "select * from reply where board_idx = ? order by idx";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyDTO dto = new ReplyDTO();
				dto.setBoard_idx(rs.getInt("board_idx"));
				dto.setContent(rs.getString("content"));
				dto.setIdx(rs.getInt("idx"));
				dto.setWriteDate(rs.getDate("writeDate"));
				dto.setWriter(rs.getString("writer"));
				list.add(dto);
				// 원래는 mapping이라는 함수를 만들어서 사용했음.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	} 
//	public int getReplyCount(int idx) { // 댓글 수 구하는 함수
//		int count = 0;
//		String sql = "select idx,title,writer, (select count(*) from reply where board_idx = board.idx) \r\n"
//				+ "    as replyCount\r\n"
//				+ "    from board\r\n"
//				+ "    order by idx;";
//		try {
//			conn = ds.getConnection();
//			pstmt =conn.prepareStatement(sql);
//			pstmt.setInt(1, idx);
//			count = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			close();
//		}
//		
//		return count;
//	}
	
	// 댓글 작성
	public int insert(ReplyDTO dto) {
		int row = 0;
		String sql = "insert into reply(board_idx, writer, content) values (?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBoard_idx());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return row;
		
	}
	// 댓글 삭제 
	public int delete(ReplyDTO dto) {
		int row = 0;
		String sql = "delete reply where idx = ? and writer = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getIdx());
			pstmt.setString(2, dto.getWriter()); // 주소창에서 delete주소를 입력하여 지울수 없도록 글쓴이가 일치하면
			row = pstmt.executeUpdate();		 // 지울수 있도록 코드를 변경(idx만 넘겼었는데, writer가 맞을때도 포함시킴)
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return row;
	}
	// 댓글 전체 삭제
	public int deleteAll(int board_idx) {
		int row = 0;
		String sql = "delete reply where board_idx = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_idx);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}
}
