package schedule;

import java.util.Date;

/*create table schedule(
	    title        varchar2(100)     not null,
	    start_date   date              not null,          
	    end_date    date               not null
	);
	
이름         널?       유형            
---------- -------- ------------- 
TITLE      NOT NULL VARCHAR2(100) 
START_DATE NOT NULL DATE          
END_DATE   NOT NULL DATE   		
*/

public class ScheduleDTO {
	private String title;
	private Date start_date;
	private Date end_date;

	public String getTitle() {
		return title;
	}

	public Date getStart_date() {
		return start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public void setString(String string) {
		
		
	}

}
