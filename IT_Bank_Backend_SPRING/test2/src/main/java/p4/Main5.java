package p4;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main5 {
	public static void main(String[] args) throws SQLException {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:board-context.xml");
		
		BoardController controller = context.getBean(BoardController.class);
		List<BoardDTO> list = controller.getBoardList();
		
		for(BoardDTO dto : list) {
			System.out.printf("%d) %s %s\n", dto.getIdx(), dto.getTitle(), dto.getWriter());
		}
		System.out.println();
		context.close();
	}
}

// mvc였으면  DispatcherServlet의 역할을 한다.