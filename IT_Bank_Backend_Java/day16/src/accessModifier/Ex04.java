package accessModifier;

// static: 하나의 클래스에 의해 만들어진 객체들은 모두 같은 값을 공유하게 하는 속성

class Test04 {
	int n1 = 10; // 일반 멤버 필드, 객체마다 다른값을 가지고 변경할 수 있음.
	static int n2 = 20; // 정적 멤버 필드, 모든 객체가 값을 공유하고 변경할 수 있다.
	final int n3 = 30; // 불변 멤버 필드, 객체마다 다른 값을 가지고 변경할 수 있음.
	static final int N4 = 40; // 정적 불변 멤버 필드, 모든 객체가 값을 공유하고 변경할 수 없음.

	// static <-> daynamic 정적/동적

	// 클래스를 제외한 모든 요소는 대문자로 시작할 수 없다.
	// 하지만 Static final 필드는 예외적으로 모든 글자를 대문자로 작성할 수 있다.
	// 단어와 단어사이는 _로 구분한다.
	
	public static int getN2() { // static 메서드는 static 필드를 참조해야한다.	
		//return n1;			// non-static 필드는 참조 불가.
		return n2;
	}// n1은 객체가 생성이 되어야 사용할 수 있기 떄문에 static만 생성된 시점에는 객체가 없을 수 있다.
	
	
	
	// 클래스와 객체는 클래스가 우선이다. 클래스가 없는데 객체를 생성할 수 없기 때문이다.
	// 따라서 static과 non-static이 있으면 static이 우선이다.
	// 메인은 static이다. 객체를 생성하지 않았어도 실행이 되어야 하기 때문이다.
	
	
}

public class Ex04 {
	public static void main(String[] args) {
		// final만 지정할 필드는 생성자의 활용에 따라 서로 다른 객체가 다른 값을 가질 수 있음.
		// static final은 변경할 수 없으며, 모든 객체가 동일한 값을 가지게 된다.

		Test04 ob1 = new Test04();
		Test04 ob2 = new Test04();

		System.out.println("ob1.n2 : " + ob1.n2);
		System.out.println("ob1.n2 : " + ob2.n2);
		System.out.println();
		// The static field Test04.n2 should be accessed in a static way
		// 정적 필드 n2는 정적인 방식으로 접근해야한다.
		// static 요소는 객체마다 서로 다른 값이 아니라, 클래스 하나에 고정된 값이므로
		// [객체.요소] 형식보다는 [클래스.요소] 형식으로 접근하는것이 올바르다.

		ob1.n2 += 5;

		System.out.println("ob1.n2 : " + ob1.n2);
		System.out.println("ob1.n2 : " + ob2.n2);
		System.out.println();

		System.out.println("Test04.n2 : " + Test04.n2);

		System.out.println(Integer.MAX_VALUE);
		// Static final 형태
		// 객체를 생성하지 않아도 사용 가능

		// 클래스 구성요소: 필드, 메서드 ,생성자, 접근제한자.
		// 추가 학습 요소: getter/setter, static, final

		// static 필드를 참조하는 메서드는 static 형식으로 작성하는 것이 좋다.

	}

}
