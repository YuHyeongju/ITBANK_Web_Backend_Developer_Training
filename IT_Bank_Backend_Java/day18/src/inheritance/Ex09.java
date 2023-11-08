package inheritance;

class Student2 {
	String name;
	int score;

	public Student2(String name, int score) {
		this.name = name;
		this.score = score;
	}

	void show() { // 정보를 출력하는 함수
		System.out.printf("이름: %s, 점수: %d\n", name, score);
	}

	@Override
	public String toString() { // 객체를 문자열로 나타낼때의 형식을 정의하는 함수(오버라이딩)
		return String.format("이름:  %s, 점수: %d\n", name, score);
		// 서식을 지정하고 문자열을 반환
	}
}

public class Ex09 {

	public static void main(String[] args) {
		Student2 ob1 = new Student2("이지은",99);
		ob1.show();
		
		System.out.println(ob1.toString());
		System.out.println(ob1);
		
		Object ob2 = ob1;
//		ob2.show(); // Object클래스 에서는 show() 메서드가 없어서 호출 불가

		System.out.println(ob2.toString());
		// Object 클래스에는 toSting () 메서드가 있어서 호출할 수 있다.
		// 오버라이딩 했기때문에 호출되고 나면 오버라이딩 한 내용 대로 실행된다.
	}

}
