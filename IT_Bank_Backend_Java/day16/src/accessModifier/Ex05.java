package accessModifier;

class Test05 {
	private String name;
	private int age;
	private static int count; // 필드의 초기값이 없으면 0이다.

	public Test05(String name, int age) {
		this.name = name;
		this.age = age;
		count += 1; // 객체를 생성할 때 마다 count의 값을 1 증가한다.
	}

	// 멤버 필드와 같은 타입/이름의 값을 매개변수로 전달 받아 필드에 대입하는 생성자
	// Constructor using Filed(필드를 사용하는 생성자)

	// 기본 생성자 -> 클래스 내부 빈 곳에 ctrl + space

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public static int getCount() {
		return count;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class Ex05 {

	public static void main(String[] args) {

		// 이클립스에서 static 요소는 이텔릭이 적용됨
		// 이클립스에서 final 요소는 볼드체(굵게)가 적용됨.

		System.out.println("Test05 타입의 객체 수: " + Test05.getCount());

		Test05 ob1 = new Test05("이지은", 30);
		Test05 ob2 = new Test05("홍진호", 41);

		System.out.println("Test05 타입의 객체 수: " + Test05.getCount());

		// ob1.setCount(1); // setter가 없어서 private 필드의 값을 수정할 수 없다.
		// Test05.setCount(1); // 클래스로 접근해도 마찬가지이다.

		System.out.printf("%s : %d살\n", ob1.getName(), ob1.getAge());
		System.out.printf("%s : %d살\n", ob2.getName(), ob2.getAge());
		System.out.println("ob1.getCount() : " + ob1.getCount());
		System.out.println("ob2.getCount() : " + ob2.getCount());

		// non-static 필드는 객체마다 서로 다른 값을 저장하지만
		// static 필드는 클래스에 속한 값이며, 서로 다른 객체가 같은 값을 공유함.
	}

}
