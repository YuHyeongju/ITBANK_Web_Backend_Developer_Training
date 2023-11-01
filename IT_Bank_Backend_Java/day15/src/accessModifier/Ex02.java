package accessModifier;

public class Ex02 {

	public static void main(String[] args) {

		Human ob1 = new Human();
		ob1.setName("이지은"); // ob1.name = "이지은" (x)

		ob1.setAge(30);

		System.out.println("이름: " + ob1.getName());
		System.out.println("나이: " + ob1.getAge());

		// getter 와 setter가 있으면 어짜피 필드에 모두 접근이 가능한데
		// 안써도 효과가 같지 않나요?

		// 클래스 작성자가 메서드를 작성하지 않으면
		// 접근 할 수 없으며, 클래스 작성자의 의도대로 움직이게 할 수 있다.

	}

}
