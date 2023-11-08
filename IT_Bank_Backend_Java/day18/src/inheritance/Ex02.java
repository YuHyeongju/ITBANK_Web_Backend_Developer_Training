package inheritance;

class Parent2 {
	// 상속에서의 생성자
	int n1, n2;

	Parent2(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	void show() {
		System.out.printf("%d, %d\n", n1, n2);
	}

}

class Child2 extends Parent2 {
	// 1) 서브 클래스의 생서자는 반드시 슈퍼클래스의 생성자를 호출해야한다.
	// 2) 서브 클래스의 생성자는 매개변수 형태가 같은 슈퍼클래스의 생성자를 호출하지 않아도된다.
	int n3;

	Child2(int n1, int n2, int n3) {
		super(n1, n2);  // 슈퍼클래스의 생성자를 호출하기 위한 코드
		this.n3 = n3;
	}

	Child2() { 			// 서브클래스의 생성자는 슈퍼클래스의 생성자를 따라가는데 꼭 그럴 필요 없음.
		super(10, 20);  // 매개변수가 꼭 같을 필요는 없음.
	}
						// 서브클래스에서는 어떤 방식으로든 슈퍼클래스의 생성자를 한 번은 호출 해줘야함.
}

public class Ex02 {

	public static void main(String[] args) {
		Child2 ob1 = new Child2();
		ob1.show();

	}

}
