package abstraction;

abstract class Test3{
	void function() {
		System.out.println("내용");
	}
	
	// void function2(); // 이 메서드는 세미콜론 대신 내용이 필요하다.
	
	abstract void function2(); 
	// 추상 메서드 function2를 포함하는 클래스 Test3는 추상클래스가 되어야 합니다. 
	
}

class Sub extends Test3  { // 추상클래스를 상속받는 클래스 sub
	// The type Sub must implement the inherited abstract method Test3.function2()
	// 자료형 sub는 상속받은 Test3의 추상메소드 function2를 반드시 구현해야한다.( 추상메서드는 미구현 상태로 간주)
	
	@Override
	void function2() {
		System.out.println("상속받아서 오버라이딩으로 구현한 내용");
	}

}
// 1. 서브클래스 -> 추상클래스
// 2. 상속받은 메서드가 더이상 추상메소드가 아니게 오버라이딩한다 -> body를 만들어준다.
public class Ex01 {

	public static void main(String[] args) {
		// 실제 객체를 코드에 반영할 때는 작성자의 시점/관점에 따라 필요한 부분만 반영하게 된다.
		// 문법적으로는 객체 특성의 형태만 지정되어 있고, 구체적인 내용이 지정되지 않은 형식을 추상화라 한다.
		// 추상클래스 : 구체적인 내용없이 객체화(instantiate)할 수 없는 클래스, 추상 메서드를 포함한다.
		// 추상메서드 : 함수의 형태는 지정되어 있으나, 내용은 없어서 호출 할 수 없는 메서드

		
		// Test3 ob1 = new Test3();
		// Test3를 객체화 할 수 없습니다.
		 Sub ob1 = new Sub();
		 ob1.function();
		 ob1.function2();
	}

}
