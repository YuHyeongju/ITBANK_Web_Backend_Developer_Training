package oop;

class PhoneBook{			// 내가 만드는 자료형
	// 변수 (member field)		// 하나의 자료형으로 여러 데이터를 생성할 수 있기때문에
	String name;			// 클래스를 작성할 때는 하나의 객체를 기준으로 생각하면서 내용을 구성한다. 
	int age;
	String phoneNumber;



	// 기능 (member method)
	// 메서드 내부에서는 멤버 필드를 조건없이 자유롭게 참조 할 수 있음.
	void show() {
		String form = "%s (%02d) : %s\n";
		System.out.printf(form, name, age, phoneNumber);
	}
	
	// 생성자: 객체를 생성할 때 실행되는 함수이며, 클래스의 이름과 같은 이름을 사용하는 함수.
	// 생성자 정의에는 반환형을 작성하지 않음.
	PhoneBook(String name, int age, String phoneNumber){
		this.name  = name;		// 매개변수에 넘어온 값으 ㄹ같은 이름의 멤버필드에 저장한다.
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	
	// 생성자를 오버로딩(종복정의)하여, 매개변수를 전달하지 않아도 객체를 생성할 수 있게 된다.
	PhoneBook(){}		

}

public class Ex05 {

	public static void main(String[] args) {
		// 여러 사람의 이름과 나이, 전화번호를 저장하여 출력하는 프로그램을 작성하고 싶다.
		// 클래스를 이용하여 객체를 생성할 때는 [생성자] 라고 하는 특수한 함수를 호출한다.
		// 자바에서는 몇 가지 예외 상황을 제외하면, 생성자를 통해서만 객체를 생성할 수 있다,
		// 아래 코드에서 ob1은 객체가 생성되었지만
		// ob2 는 객체를 가리킬 수 있는 참조 변수만 생성되었을뿐, 실제 객체는 생성되지 않은 상태이다.
		PhoneBook ob1 = new PhoneBook();
		PhoneBook ob2;
		
		// 객체를 생성한 직후에는 객체 내부 멤버필드의 값이 0, 혹은 null로 초기화 되어있음.
		System.out.println("ob1.name : " + ob1.name);
		System.out.println("ob1.age : " + ob1.age);
		System.out.println("ob1.phoneNumber : " + ob1.phoneNumber);
		System.out.println();
		
		// 객체 내부의 맴버필드에서 일반 변수와 동일하게 대입을 수행할 수 있음.
		ob1.name = "이지은";
		ob1.age = 30;
		ob1.phoneNumber = "010-1234-1234";
		
		// 필드에 접근하여 값을 출력할 수도 있지만, 만들어둔 기능이 있으면 함수를 호출할 수 있음.
		ob1.show();		// 소괄호가 붙어있으면 무조건 함수이다.
		
		// 아까 만들어둔 ob2 변수에도 새로운 객체를 할당하여 추가 데이터를 입력한다.
		
		ob2 = new PhoneBook();
		
		ob2.name = "홍진호";
		ob2.age = 41;
		ob2.phoneNumber = "010-2222-2222";
		
		ob2.show();
		
		PhoneBook[] arr = {ob1,ob2};
		// 클래스도 자료형이므로, 같은 자료형의 여러 데이터를 묶어서 처리하는 배열로 만들 수 있음.
		
		System.out.println("\n배열로 출력하기");
		 for(int i = 0; i < arr.length; i++) {
			 arr[i].show();
		 }
		 System.out.println();
		 
		 
		 // ob1과 ob2는 객체 생성 이후 필드에 값을 대입하여 사용한다.
		 // 멤버 필드가 많고 대입할 내용이 많으면 코드가 길어지기 때문에
		 // 객체 생성과 동시에 값을 지정하는 방법이 있다.
		 // 생성자를 호출하면서 필요한 값을 순서대로 전달하면 값이 준비된 객체가 생성될 수 있다.
		 
		 PhoneBook ob3 = new PhoneBook("나단비", 5, "010-3434-3434");
		 
		 arr = new PhoneBook[] {ob1,ob2,ob3};
		 
		 System.out.println("\n새로운 배열로 다시 반복");
		 for(PhoneBook ob : arr) {
			 ob.show();
		 }
		 System.out.println();
	}

}
