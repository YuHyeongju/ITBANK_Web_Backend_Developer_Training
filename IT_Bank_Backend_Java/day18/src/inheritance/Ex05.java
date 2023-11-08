package inheritance;

class Parent5 { // 두 정수를 전달받아서, 객체를 생성하고 덧셈식을 출력하는 클래스

	int n1, n2;

	public Parent5(int n1, int n2) {	// 기본생성자가 없음.
		this.n1 = n1;
		this.n2 = n2;

	}

	public void show() {
		System.out.printf("%d + %d = %d\n " + n1, n2, n1 + n2);
	}

}

class Child5 extends Parent5 {
	// 생성자를 작성하여 필요한 코드를 작성하세요
	int n3;
	
	public Child5(int n1, int n2, int n3) {
		super(n1, n2);
		this.n3 = n3;

	}

	// 세 정수를 입력받고, 세 정수의 덧셈식을 출력하는 기능을 오버라이딩 하세요.(함수 내용 수정)

	@Override
	public void show() {
		System.out.printf("%d + %d + %d = %d\n", n1, n2, n3, n1 + n2 + n3);

	}

	// 세 정수 중 가장 큰 수를 출력하는 함수를 작성하세요.(오버라이딩 아님, 함수 추가)

	public void showMaxNum() {
//		int max;  // 내 코드
//		
//		max = n1;
//		if(n2 > max) {
//			max = n2;
//		}
//		if(n3 > max) {
//			max = n3;
//		}
//		
		/*// 옆사람 코드
		int max = n1;
		max = max > n2 ? max : n2;
		max = max > n3 ? max : n3;
		
		*/
		// 강사님 코드
		int max = Integer.MIN_VALUE;
		
		if(max < n1) max = n1;
		if(max < n2) max = n2;
		if(max < n3) max = n3;

		System.out.println("가장 큰 수: " + max);
		
	}

}

public class Ex05 {

	public static void main(String[] args) {

		Child5 ob1 = new Child5(12, 7, 25);
		ob1.show();
		ob1.showMaxNum();
		
		Parent5 ob2 = new Child5(1,2,3);
		Child5 ob3 = (Child5) ob2; // 덮어쓰기
		
		System.out.println("ob1 : " + ob2);
		System.out.println("ob2 : " + ob3);
		System.out.println("ob2 == ob3 : " + (ob2 == ob3));
		// ob2 참조변수와 ob3 참조변수는 동일한 대상을 참조하고 있음.
		
		ob3.show();
		ob3.showMaxNum();
		
		ob2.show(); 		// ob2는 슈퍼클래스 타입이지만 오버라이딩 메서드가 실행됨
		//ob2.showMaxNum(); // ob2는 슈퍼클래스 타입이므로 서브클래스의 메서드를 참조할 수 없음.
	
		// 오버라이딩 장점1: 서브로 참조하던 슈퍼로 참조하던 똑같은 결과를 보장함. 
		// 오버라이딩 장점2: 
		// 다형성: 하나의 메소드나 클래스가 다양한 방식으로 동작하는 것.
 	}

}
