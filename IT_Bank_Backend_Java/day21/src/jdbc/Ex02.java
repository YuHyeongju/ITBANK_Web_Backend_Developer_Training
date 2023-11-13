package jdbc;

import java.util.List;

public class Ex02 {

	public static void main(String[] args) throws Exception {
		DAO dao = new DAO(); // DB에 접속해서

		List<DTO> list = dao.getQueryFromEmployees(); // 원하는 데이터를 리스트 형태로 가져와서

		// 모두 출력한다.
		list.forEach(ob -> System.out.printf("%s : $%,d\n", ob.getFirstName(), ob.getSalary()));
	}

}
// 상향식 설계 
// 하향식 설계 

// DAO: 값을 저장하지만, 값을 가져오는 기능이 포커스(행위) - 자판기
// DTO: 값을 저장하는 자체가 포커스              		- 음료수 형태