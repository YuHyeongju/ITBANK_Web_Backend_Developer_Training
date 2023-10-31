package oop;

class Circle {
	double radius;
	double area;
	double pi = 3.14; // 필드에 초기값을 지정해두면, 생성자로 덮어쓰지 않는한
						// 모든 객체가 동일한 값을 지니게 됨.

	// 반지름 radius를 전달받아서 저장하고,
	// 원의 넓이를 구하는 코드를 포함하는 생성자를 작성하세요.
	Circle(int radius) {
		this((double)radius);			// this가 없으면 지역변수 매개변수 부터 참조 시도
//		this.radius = radius;			// this가 붙거나 같은 이름이 없으면 멤버 필드 참조
//		area = radius * radius * pi;
	}

	// 생성자를 오버로딩하여 정수, 혹은 실수 형태로 전달 받을 수 있도록 처리하세요.
	Circle(double radius) {
		this.radius = radius;
		area = radius * radius * pi;
	}
	// 원의 반지름과 넓이를 각각 출력하는 함수 show()를 정의하세요.

	void show() {
		System.out.printf("원의 반지름: %.2f, 원의 넓이: %.2f\n",radius,area);
		// 실수 기본: 6자리 출력
	}

}

public class Quiz01 {

	public static void main(String[] args) {
		Circle c1 = new Circle(2);
		Circle c2 = new Circle(3.5);
		
		c1.show();
		c2.show();
	}

}
