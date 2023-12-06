package food;

import java.util.ArrayList;
import java.util.List;

public class FoodService {
	
	private ArrayList<FoodDTO> list = new ArrayList<>(); // FoodDTO 타입의 리스트 객체 생성
	
	public int add(FoodDTO dto) {	 
		int row = 0;
		row += list.add(dto)? 1:0;
		return row;
	}
	
	public List<FoodDTO> getList(){ // 리스트가져오는 함수
		return list;
	}
}
