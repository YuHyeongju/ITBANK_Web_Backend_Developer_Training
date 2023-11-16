package PhoneBook1;

import java.util.List;

public class Handler {
	PhoneBookDAO dao = new PhoneBookDAO();
	
	public List<PhoneBookDTO> showList() {
	
		List<PhoneBookDTO> list = dao.selectList();  // dao에서 selectList를 가져와서 리스트에 넣고 반환
		return list;
	}
	
	public int insertPhonebook(PhoneBookDTO dto) {
		
		int row = dao.insert(dto);				// dao에 insert를 row에 저장 후 반환 
		return row;
	}
	
	public	int  delete(String name) {			// 메인에서 인자로 이름을 받아옴
		int row = 0;
		
		row = dao.delete(name);					// dao의 delete 를 row에 저장후 반환

		return row;
		
	}
	
	public int updatePnum(String name, String pnum) {	// 메인에서 이름과 전화번호를 인자로 받아옴
		
		PhoneBookDTO dto = new PhoneBookDTO();	// dto 객체 만들기
		dto.setName(name);						// dto에 setName에 입력받은 이름, setPnum으로 전화번호 변경후 
		dto.setPnum(pnum);						// dao에 dto를 넘겨줌으로써 DB에 반영
		int row = dao.updatePnum(dto);			// row에 저장해서 반환
		return row;
	}
	
	public int updatefavorite(String name) {	// 메인에서 이름입력받아서 dao.updatefavorite에 전달
		int row;								// 하는 코드를 row에 저장해서 반환
		row = dao.updatefavorite(name);
		return row;
	}


	

}
