package variable;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("안녕하세요");
		System.out.println("제 이름은 손흥민 입니다.");
		System.out.println("올해 나이는 " + 30 + "살 입니다.");
		System.out.println();// 내용을 적지 않아도 실행되고, 한 줄 아래로 띄워준다.

		String name = "손흥민";
		int age = 30;

		System.out.println(name + "의 나이는 " + age + " 살 입니다.");
		// 변수에 담긴 값을 바꾸면 동일한 코드로 다른 값을 처리할 수 있다.

		name = "김윤영";
		age = 24;

		System.out.println(name + "의 나이는 " + age + " 살 입니다.");
		
		
	}
}
