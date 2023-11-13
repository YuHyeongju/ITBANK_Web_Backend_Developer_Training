package jdbc;

class DTO { // Data Transfer Object, DB <-> Program 사이로 데이터를 주고받기 위해 사용하는 객체
	private String firstName;
	private int salary;

	public String getFirstName() {
		return firstName;
	}

	public int getSalary() {
		return salary;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
