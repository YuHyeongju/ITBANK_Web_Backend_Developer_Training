package employees;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Handler handler = new Handler();
		
		List<EmployeesDTO> list = new ArrayList<>();
		list = handler.selectAll();
		list.forEach(System.out::println);

	}

}
