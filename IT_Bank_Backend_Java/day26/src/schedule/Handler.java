package schedule;

import java.util.Date;
import java.util.List;

public class Handler {
	private ScheduleDAO dao = new ScheduleDAO();
	
	public List<ScheduleDTO> selectAll() {
		
		return dao.selectAll();
	}
	
	public String getVersion() {
		
		return dao.getVersion();
	}

	public Date getSysdate() {
		
		return dao.selectSysdate();
	}

	public int insertSchedule(ScheduleDTO dto) {
		
		return dao.insertSchedule(dto) ;
	}

	public int deleteSchedule(String title) {
		
		return dao.deleteSchedule(title);
	}

	public List<ScheduleDTO> selectMonth(int month) {
		
		return dao.selectMonth(month);
	}


	
	
	
}
