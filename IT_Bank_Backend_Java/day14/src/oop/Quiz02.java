package oop;

/*
		편의점에서 성인/미성년자 여부에 따라 상품을 판매하려고 한다.
		손님 클래스는 이름과 나이로 구성되어 있다.
 */

class Customer {
	// 1) 문자열 형태의 이름과 정수 형태의 나이를 저장할 수 있는 필드를 작성하세요.
	String name;
	int age;

	// 2) 손님 객체는 반드시 이름과 나이가 지정되어있어야한다. -> 기본생성자로는 객체를 생성할 수 없음.
	// 생성자를 활용하여 매개변수로 이름과 나이를 전달받은 후 필드에 저장
	Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 3) 손님의 간략한 정보를 확인하기위한 void show() 함수(메서드)를 작성하세요.
	// printf를 이용하여 이름과 나이를 한 줄에 출력하세요.
	void show() {
		System.out.printf("손님의 이름: %s, 나이: %d살\n", name, age);
	}

	// 4) 손님이 성인인지 아닌지 판별하기 위한 isAdult()를 작성합니다.
	boolean isAdult() {
		boolean answer; 	// 지역변수
		answer = age >= 20; // age는 지역변수로 존재하지 않아서 멤버필드를 참조한다.
		return answer; 		// 함수 영역 내에서 가까운 요소를 참조함.
	}
	
	// 7) 생성자를 추가로 작성하여(오버로딩), 이름만으로도 객체를 생성할 수 있도록한다.
	// 이때, 값을 초기화하지 않은 age의 값은 0이다.
	Customer(String name){
		this.name = name;
	}
}

public class Quiz02 {

	public static void main(String[] args) {
		// 5) 성인 2명, 미성년자 1명 총 3명의 손님 객체를 생성
		// 이름과 나이는 마음대로
		Customer customer1 = new Customer("홍길동", 24);
		Customer customer2 = new Customer("이몽룡" , 26);
		Customer customer3 = new Customer("이나영", 17);
		Customer customer4 = new Customer("둘리");
		
		// 6) 손님 객체 3명을 배열로 묶은 다음
		// 반복문을 이용하여 손님의 성인여부에 따라 판매 가능/불가능 출력
		Customer[] arr = {customer1,customer2,customer3,customer4};	// 배열 안의 각 손님 객체를 member라고 한다.
		for(int i = 0; i < arr.length; i++) {				// 손님 정보를 출력
			Customer member = arr[i];
			member.show();
			if(member.isAdult()) {							// 손님이 성인이면
				System.out.println("상품 판매 가능");			// 판매가능 출력
			}else {											// 미성년자는
				System.out.println("상품 판매 불가능");			// 판매 불가능 출력
			}
			System.out.println();							
		}
		
		
	}

}
