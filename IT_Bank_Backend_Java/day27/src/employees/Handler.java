package employees;

import java.util.List;

public class Handler {
	
	private EmployeesDAO dao = new EmployeesDAO();
	
	public List<EmployeesDTO> selectAll(){
		
		return dao.selectAll();
	}
	
	
	
}
