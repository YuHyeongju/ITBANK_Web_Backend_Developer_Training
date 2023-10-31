package oop;

class Test{
	int num;
	
	void show() {
		System.out.println("numl: " + num);
	}
	
	
	// 생성자를 작성하지 않아도 컴파일시 기본생성자가 (매개변수를 받지않는 생성자)가 자동으로 작성됨.
	// Test() {} 
	
	// 작성자가 임의로 생성자를 정의하면 자동으로 생성자를 만들어주지 않음.
	Test(int num){
		this.num = num;
		System.out.println("Test 타입의 객체를 하나 생성했습니다.");
		
		// 생성자역할
		// 필드의 초기값 지정
		// 객체 생성시 초기 작동 제어
	}
	// 생성자도 함수임으로 오버로딩(이름이 같지만, 매개변수 형태가 다른 함수 중복 정의) 가능
	Test(){
		System.out.println("기본 생성자 호출\n");
	}
	
	
}




public class Ex06 {

	public static void main(String[] args) {
		Test ob1 = new Test();	// 생성자를 아예 작성하지 않아도 기본생성자를 호출할 수 있다.
		ob1.show();
		
		ob1.num = 12;
		ob1.show();
		
		Test ob2 = new Test(25);
		ob2.show();

	}

}

// 생성자
//
// 클래스를 이용하여 객체를 생성할 때, 호출해야하는 특수한 함수이다.
// 클래스 변수 = new 생성자();
//
// 1) 생성자의 이름은 클래스의 이름과 같아야한다.
// 2) 클래스 작성시  어떤 형태이든 생성자를 작성하지 않으면, 매개변수를 받지않는 지본 생성자가 자동으로 만들어짐. 
// 3) 클래스 작성시 어떤 형태이든 생성자를 작성하면, 자동으로 생성하지않음.
// -> 이름 이용하여, 특정 타입의 객체를 생성하기 위해서는 반드시 어떤 값을 전달해야한다는 규칙이 만들어짐.
// 4) 생성자는 매개변수를 받아서 , 멤버필드의 값을 초기화 할 수 있음.
// -> 클래스는 하나이지만, 생성자 코드에 따라 서로 다른 객체가 서로 다른 값을 가질 수 있도록 한다.
// 5) 생성자는 필드 초기화 이외에도, 특정 코드를 수행하도록 만들 수 있다.

// ex) Scanner  클래스는 객체를 생성하기위해서, InputStream 혹은 string 혹은 File등을 전달해야함.
// the constructor Scanner() is undefined
// 매개변수를 전달받지 않는 Scanner() 생성자는 정의되어 있지 않음.
// Scanner sc = new Scanner(); 









