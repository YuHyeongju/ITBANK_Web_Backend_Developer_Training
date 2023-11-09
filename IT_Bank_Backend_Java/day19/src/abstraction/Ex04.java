package abstraction;


interface Test6{
	// 인터페이스는 추상클래스의 일종이다.
	// 인터페이스는 일반적인 추상클래스와 달리 일반 메서드를 포함할 수 없다,
	// 인터페이스는 extends 대신 implements 키워드로 상속(구현)한다.
	// 인터페이스의 모든 필드는 public static final 속성을 가진다.
	// 인터페이스의 모든 메서드는 public abstract 속성을 가진다
	// 인터페이스는 다중 상속을 허용한다.
	
	String name = "테스트 인터페이스"; // static final이 적용되있음, 완전한 고정값.
	
	
	void f1(); // 추상메서드는 바디를 만들 수 없다.
	
	
	// 잘못된 식별자가 f2에 지정되어있다.
	// 오로지 public private abstract default static strictfp만 허용
	private void f2() {
		// 내부에서만 호출가능한 함수
	}; 

	public abstract void f3(); // 메서드만 작성했을때 기본형

}						


public class Ex04 {

	public static void main(String[] args) {
		// 인터 접두사: 서로다른 
		// 인터페이스 : 서로 다른 유형의 객체를 같은 규격(표면, face)으로 맞추기 위한 형태, 도구
		// 인터페이스 = 규격 
		// 형식만 맞추고 내부에서 수행되는 내용은 다르다.

	}

}
