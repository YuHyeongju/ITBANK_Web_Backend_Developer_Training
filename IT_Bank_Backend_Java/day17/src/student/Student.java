package student;

public class Student {
	public String name;
	public int ban, no, kor, eng, math;

	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Student() {
	}

	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getNo() {
		return no;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public String info() {
		String answer = "%s, %d, %d, %d, %d, %d";
		answer = String.format(answer, name, ban, no, kor, eng, math);
		return answer;
	}

	public int getTotal() {
		int sum = kor + eng + math;
		return sum;
	}

	public float getAvg() {
		float avg = (float) (getTotal() / 3.0);
		avg = Float.valueOf(String.format("%.2f", avg));
		return avg;
	}
	

}
