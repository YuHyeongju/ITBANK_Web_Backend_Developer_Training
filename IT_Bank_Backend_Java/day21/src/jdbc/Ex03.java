package jdbc;

import java.sql.SQLException;
import java.util.List;

public class Ex03 {

	public static void main(String[] args) throws SQLException {
		// 직원 중에서 급여를 가장 많이 받는 상위 5명의 이름과 급여 불러오기
		// DAO와 DTO클래스를 분리했지만 같은 패키지 내부에있기때문에
		// EX03이 아닌 다른 파일에서도 참조하여 활용할 수 있음

		DAO dao = new DAO();
		List<DTO> list = dao.getQueryFromEmployeesTop5();
		for (DTO dto : list) {
			System.out.printf("%s : $%,d\n", dto.getFirstName(), dto.getSalary());
		}

	}

}
