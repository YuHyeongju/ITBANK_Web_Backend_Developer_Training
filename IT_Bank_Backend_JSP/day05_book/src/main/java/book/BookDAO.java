package book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

 	private ArrayList<BookDTO> list = new ArrayList<>();
 	
 	public List<BookDTO> selectList(){
 		// 쿼리문 select * from book order by idx;
 		return list;
 	}
 	
 	public BookDTO selectOne(int idx){
 		// select * from book where idx = ?;
 		for(BookDTO dto : list) {
 			if(dto.getIdx() == idx) { // dto의 인덱스와 선택한 요소의 인덱스가 같으면
 				return dto;			  // dto 반환
 			}
 		}
 		return null;
 	}
 	
 	
 	public int insert(BookDTO dto) {
 		int row = list.add(dto) ? 1:0; // 추가되었으면 1저장 아니면 0저장
 		return row;
 	}
 	
 	public int delete(int idx) {
 		// delete book where idx= ?
 		int row = list.removeIf(dto ->dto.getIdx() == idx) ? 1: 0;
 		return row;
 		
 	}
	
 	// 마지막으로 추가된 객체의 idx가 몇 번인지 확인하는 메서드
 	public int currval() {
 		// select book_seq.currval from dual;
 		return BookDTO.getSeq();
 	}
	
}
