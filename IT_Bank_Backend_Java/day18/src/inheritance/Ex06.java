package inheritance;

class Human {
	// 이름을 저장할 필드를 작성하시오.
	String name;

	// 생성자를 이용하여 이름을 전달받고 필드에 저장하시오.
	public Human(String name) {
		this.name = name;
	}

	// 본인의 이름을 출력하는 메서드 show()를 작성하세요.
	public void show() {
		System.out.printf("이름: %s\n", name);
	}

}

class Student extends Human {
	// 학생의 성적 점수를 저장할 int형 필드 score를 작성하세요.
	int score;

	// 생성자에서 이름과 점수를 전달받고, 이름은 슈퍼클래스의 생성자로 보내고, 점수를 필드에 저장하시오.
	public Student(String name, int score) {
		super(name);
		this.score = score;
	}
	// show()를 오버라이딩하여, 이름과 정수를 함께 출력하도록 수정하시오.

	@Override
	public void show() {
		System.out.printf("이름: %s, 점수: %d\n", name, score);
	}

}

public class Ex06 {

	public static void main(String[] args) {
		Human ob1 = new Human("이지은");
		Student ob2 = new Student("홍진호", 22);
		ob1.show();
		ob2.show();
		// 상속을 사용하는 경우
		// A클래스와 B클래스가 is 관계가 성립하면 상속을 사용함.
		// 카테고리(범주)상의 포함관계일 경우 사용함.
		// Student is a Human
		// class Student extends Human

		// 물리적 포함관계는 상속으로 포함하지않음.(has)
		// Car has a tire
		// class Tire extends Car(x)

		// 같은 상황에서 서로 다른 클래스의 객체를 사용할 수 있는지 확인해보면 된다.
		// 학생에게 말을 걸었다 -> 사람에게 말을 걸었다.(o)
		// 자동차를 운전한다. -> 타이어를 운전한다.(x)

		// [일반 DB 접속 클래스]를 이용하여 DB에 접속한다. -> [오라클 DB 접속 클래스]를 이용하여 DB에 접속한다.

	}

}
// 객체지향 특성 4가지
//  캡슐화  : 서로 다른 자료형의 필드와 메서드를 하나의 객체로 묶어서 처리가능 
//  상속 	  : 기존의 클래스를 재활용하여 내용을 추가/수정하여 새로운 클래스를 만들어냄
//  다형성 : 하나의 객체는 슈퍼클래스로도 참조 가능하고, 서브클래스로도 참조 가능하다.
//  추상화 : 객체의 구체적인 내용없이 추상적인 형태만 지정할 수 있음.

// 객체지향 프로그래밍의 5가지 원칙
// • 단일 책임 원칙 (SRP : Single Responsibility Principle): 	  한 클래스는 하나의 책임만 가져야한다.
// • 개방 폐쇄 원칙 (OCP : Open/Closed Principle): 				  확장은 가능하나 변경은 할 수 없다.
// • 리스코프 치환 원칙 (LSP : Liskov’s Substitution Principle):  프로그램의 객체는 정확성을 깨뜨리지
//															  않으면서 하위타입의 인스턴스로 변경 가능해야한다.
// • 인터페이스 분리 원칙 (ISP : Interface Segregation Principle): 특정 클라이언트를 위한 인터페이스 여러 개가 
//                                                            공용 인터페이스 하나보다 나음. 
// • 의존관계 역전 원칙 (DIP : Dependency Inversion Principle):   가급적 객체의 상속은 인터페이스를 통해 이루어져야한다.

