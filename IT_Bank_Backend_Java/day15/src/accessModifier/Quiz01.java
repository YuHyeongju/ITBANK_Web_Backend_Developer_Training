package accessModifier;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		// Human 클래스를 이용하여 비어있는 상태의 객체를 하나 생성하세요.

		Scanner sc = new Scanner(System.in);

		Human ob = new Human();		// 새로운 객체를 생성하고, ob가 그 객체를 가리키도록 한다.

		// 본인의 이름과 나이를 키보드로 입력하여 그 값을 ob에 저장.
		// 한 줄에 출력하시오.

		System.out.print("이름 입력: ");
		String name = sc.nextLine();

		System.out.print("나이 입력: ");
		int age = sc.nextInt();

		ob.setName(name);
		ob.setAge(age);
		
		System.out.println();
		System.out.println("이름: " + ob.getName());
		System.out.println("나이: " + ob.getAge());
		
		sc.close(); // 열었으면 닫아야함. 나중에 db로 가면 상황이 복잡해진다.
	}
	

}
