package phonebook2;

import java.util.List;

public class Handler {
		PhonebookDAO dao = new PhonebookDAO();

	public List<PhonebookDTO> showList() throws Exception {
		List<PhonebookDTO> list = dao.selectList();
		return list;
	}

	public int insertPhonebook(PhonebookDTO dto) throws Exception {
		int row = dao.insertPhonebook(dto);
		return row;
	}

	public int updatePnum(String name, String pnum) throws Exception {
		int row = dao.updatePnum(name,pnum);
		return row;
	}

	public int updateFavorite(String name) throws Exception {
		int row = dao.updateFavorite(name);
		return row;
	}

	public int delete(int idx) throws Exception {
		int row = dao.delete(idx);
		return row;
	}

}
