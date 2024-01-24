package p4;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BoardController {
	@Autowired private BoardDAO dao;
	
	public List<BoardDTO> getBoardList() throws SQLException {
		
		return dao.selectList();
	}

}
