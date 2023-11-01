package accessModifier;

import java.util.Scanner;

// 이 프로그램에서 다룰 단일 데이터의 형태: Human

//이 프로그램의 내부 기능을 담당하는 형태
class Hander5 {
	// 프로그램에서 사용되는 상세 기능을 함수로 구현하면 된다.
	// 필요한 변수가 있다면 필드로 생성해도된다.

	// 객체 형태의 데이터를 저장하기위한 자료구조(배열)
	private Human[] arr = new Human[5];

	// 이름과 나이를 전달받아서, Human형태의 객체를 생성하고, 배열에 추가하는 함수
	// 추가되면 1, 아니면 0을 반환함.
	public int add(String name, int age) {
		int row = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = new Human();
				arr[i].setName(name);
				arr[i].setAge(age);
				row = 1; // 1개의 데이터를 추가했다는 의미
				break;
			}
		}

		return row;
	}

	public void showList() {		// 전체 내용 출력 함수
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				System.out.printf("%s : %d살\n", arr[i].getName(), arr[i].getAge());
			}
		}
	}

}

// 이 프로그램의 입출력 및 ui를 담당하는 형태
public class Ex05 {

	public static void main(String[] args) {
		// Human 타입의 객체를 저장할 수 있는 배열을 준비
		// while, switch ~ case를 이용하여 메뉴를 선택하는 형식
		// 메뉴 선택에 따라 입력 및 출력을 수행하는 프로그램

		Scanner sc = new Scanner(System.in);
		Hander5 handler = new Hander5();
		int menu;
		String name;
		int age;
		int row;

		while (true) {
			System.out.println("1.입력 ");
			System.out.println("2.출력 ");
			System.out.println("0.종료 ");
			System.out.println("선택 >>>");
			menu = sc.nextInt();
			switch (menu) {
			case 1: // 빈칸을 찾아서 빈칸에 데이터를 입력하고 반복탈출
					// 만약 모든 칸이 채워져서 빈 칸이 없으면 메시지 출력
				System.out.print("이름 입력: ");
				name = sc.next();
				System.out.print("나이 입력: ");
				age = sc.nextInt();
				row = handler.add(name, age);	// 입력값을 받아서 넘기면 
												// handler가 알아서 처리하고
												// 그 결과만 main()에게 보고함.
				System.out.println(row != 0 ? "추가성공" : "추가실패");
				
				break;
				
			case 2: 
				handler.showList();
				
				break;
				
			case 0:
				sc.close();
				return;
				
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
			System.out.println();
		}

	}

}
