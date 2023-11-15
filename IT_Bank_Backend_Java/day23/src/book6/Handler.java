package book6;

import java.util.List;

public class Handler {


	// 전체 목록 출력
	public void showList() {
		BookDAO dao = new BookDAO(); 				// Connection이 연결된 상태
		List<BookDTO> list = dao.selectList();		// DB에 저장된 데이터를 불러온다.
		list.forEach(ob -> System.out.println(ob));	// 지금의 DAO는 일회용이다.
	}
	
	// 도서 추가
	public int insertBook(BookDTO ob) {
		int row = 0;
		BookDAO dao = new BookDAO(); // 메인에 넘겨준 객체를 dao로 전달하여 추가 
		row = dao.insertBook(ob);	// 추가 결과 정수를 다시 메인으로 반환
		return row;
	}
	// 도서 이름을 전달받아서, 배열 안에서 일치하는 객체를 찾아서 삭제하는 함수 
	public int deleteBook(String name) {
		int row = 0;
		BookDAO dao  = new BookDAO();
		row = dao.deleteBook(name);
		return row;
	}

}	
	