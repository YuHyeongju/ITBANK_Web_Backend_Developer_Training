package employees;
import java.util.Date;
/*
이름             널?       유형           
-------------- -------- ------------ 
EMPLOYEE_ID    NOT NULL NUMBER(6)    
FIRST_NAME              VARCHAR2(20) 
LAST_NAME      NOT NULL VARCHAR2(25) 
EMAIL          NOT NULL VARCHAR2(25) 
PHONE_NUMBER            VARCHAR2(20) 
HIRE_DATE      NOT NULL DATE         
JOB_ID         NOT NULL VARCHAR2(10) 
SALARY                  NUMBER(8,2)  
COMMISSION_PCT          NUMBER(2,2)  
MANAGER_ID              NUMBER(6)    
DEPARTMENT_ID           NUMBER(4)    
*/


public class EmployeesDTO {
	private String first_name;
	private int salary;
	private Date hire_date;
	private String jobLong;
	
	@Override
	public String toString() {
		String form = "";
		form = String.format("%-11s %10d$ %15s %7s년 근무",first_name, salary,hire_date, jobLong);
				
		return form;
	}
	
	public String getJobLong() {
		return jobLong;
	}
	public void setJobLong(String jobLong) {
		this.jobLong = jobLong;
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public int getSalary() {
		return salary;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setHire_date(Date string) {
		this.hire_date = string;
	}
	
}
