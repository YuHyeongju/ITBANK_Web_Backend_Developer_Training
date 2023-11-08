package inheritance;

class Parent4 {
	double db = 1.2;

	void show() {
		System.out.printf("Parent) db: %f\n", db);
	}
	
	final void test() {
		System.out.println("cannot override");
	}
}

class Child4 extends Parent4 {
	// 슈퍼클래스에서 이미 만들어진 기능이 있지만
	// 기능의 내용을 수정해서 사용하고 싶을 때 (없는 기능을 추가하는 상황은 아님)
	// 기존 기능(함수)의 형식은 그대로 정의하고, 내용만 새로 작성하여 사용할 수 있음.
	// 기존에 정의된 함수를 새롭게 재정의한다 라고 하여 override라고 한다.
	// 메서드 오버라이딩은 오버로딩과 달리 반환형, 함수이름, 매개변수의 형태 및 개수가 모두 일치해야함.
	// 오버로딩: 함수의 중복정의 - 매개변수의 이름이 같고, 개수, 타입이 달라야됨.
	// 오버라이딩: 클래스의 재정의 - 메소드이름, 매개변수, 리턴값이 동일해야함.

	// Cannot reduce the visibility of the inherited method from Parent4
	// 상속받은 메서드의 접근제한자 범위를 줄일 수 없다.(늘리는건 가능 - package -> public)
	//*************************************************************************
	//* private -> default(package) -> protected -> public : 가능  			  *
	//* 반대의 경우는 불가능                                                       *
	//*************************************************************************
	@Override // 오버라이딩 규칙에 맞지 않으면, 경고를 보내고 실행시키지 않음.
			  // 이 메소드는 상속받은 후, 재정의한 메서드임을 명시
	void show() {
		System.out.printf("Child) db: %.2f\n", db);
	}
			  		// final 클래스는 상속받을 수 없다.(예: Scanner 클래스)	
//	@Override 		// final 메서드 , final 필드는 오버라이딩 불가(함수의 내용, 필드의 값을 바꿀 수 없다.)
//	void test() {
//		System.out.println("오버라이딩 돼");
//	}
//	
}

public class Ex04 {

	public static void main(String[] args) {
		Parent4 ob1 = new Parent4();
		ob1.show();

		Child4 ob2 = new Child4();
		ob2.show();
		ob2.test();

	}

}
