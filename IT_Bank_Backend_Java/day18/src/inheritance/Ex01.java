package inheritance;

class Parent1 { // 두 정수를 저장 할 수 있고, 그 값을 출력하는 메서드를 포함하는 클래스
	int x;		// 슈퍼 클래스
	int y;

	void show() {
		System.out.printf("x : %d, y : %d\n", x, y);
	}

	void setX(int x) {
		this.x = x;
	}

	void setY(int y) {
		this.y = y;
	}
}

// Parent1 클래스의 속성과 기능을 그대로 물려받는 서브클래스 Child1
// Parent1의 내용을 그대로 물려받은 상태에서, 추가적인 요소를 넣어서 개념을 확장하여 사용한다.
// 이미 만들어진 클래스의 재사용을  하기 위한 요소
class Child1 extends Parent1{ // extends: 확장, 기존 클래스의 개념에서 확장하여 더 많은 내용을 포함한다.
							  // 부모클래스와 내용이 동일하면 비워놔도 상관없음
			                  // 추가할 기능이 있으면 추가하면됨.
							  // inheritance: 물려받는다는 느낌이 너무 강하다.따라서 extends 사용
	// int x;
	// int y;
	int z;
//	void setX(int x) {
//		this.x = x;
//	}
//
//	void setY(int y) {
//		this.y = y;
//	}
	void setZ(int z) {
		this.z = z;
	}
	void show() { // 기존 기능을 수정 (기존에 만들어진 함수와 형식이 일치해야함.)
		System.out.printf("x: %d, y: %d, z: %d\n", x, y, z);
	}
	
}



public class Ex01 {

	public static void main(String[] args) { 
		Parent1 ob1 = new Parent1();

		ob1.setX(12);
		ob1.setY(7);
		ob1.show();

		 
		Child1 ob2 = new Child1();
		ob2.setX(35);
		ob2.setY(72);
		ob2.setZ(60);
		ob2.show();
	}

}
// 값의 재사용: 변수 
// 코드의 재사용: 함수 
// 클래스의 재사용: 상속 