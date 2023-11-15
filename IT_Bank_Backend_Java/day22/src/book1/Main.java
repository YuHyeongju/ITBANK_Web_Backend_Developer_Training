package book1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int menu; // 스위치와 연동하기위한 메뉴
		Scanner sc = new Scanner(System.in); // 입력 받기위한 스캐너
		Book[] arr = new Book[5];   // 여러 객체를 저장하기위한 배열
									// 배열은 자료형에 맞는 0값으로 초기화된다.
									// 참조형 변수(클래스 타입 변수)의 초기값은 null
		String name, publisher, author; // Book의 String 타입필드
		int price; // Book의 Int 타입필드

		// 초기값을 안주는 경우: 확정적으로 다음에서 입력을 받을 경우
		
		MAIN: while (true) { // 입력 + 출력(자료형 대입, 제어문 + 연산자 활용)

			System.out.println("1. 추가"); // 사용자 메뉴 출력
			System.out.println("2. 목록");
			System.out.println("0. 종료");
			System.out.println("메뉴입력: ");
			menu = Integer.parseInt(sc.nextLine());

			switch (menu) { // 사용자가 입력한 메뉴에 따라서 서로 다른 코드 수행 (분기문)
			case 1: // 도서 추가

				System.out.print("도서이름 입력: ");
				name = sc.nextLine();

				System.out.print("저자 입력: ");
				author = sc.nextLine();

				System.out.print("출판사 입력: ");
				publisher = sc.nextLine();

				System.out.print("가격 입력: ");
				price = Integer.parseInt(sc.nextLine());
				
				// 4개의 값을 입력 받았다면 하나의 객체로 구성하기위해 생성자 호출
				// 배열의 10칸중에서 빈칸을 하나 찾아서 거기에 객체를 생성하고 값을 넣어준다.
				// 다음 칸에도 똑같은 값을 넣으면 안되니까 break 수행

				for (int i = 0; i < arr.length; i++) { // 배열의 처음부터 끝까지 순회하면서
					if (arr[i] == null) {			// 빈칸을 찾았다면
						arr[i] = new Book();		// 객체를 생성하고
						arr[i].name = name;			// Scanner로 입력받은 값을 객체의 속성으로 대입
						arr[i].author = author;
						arr[i].publisher = publisher;
						arr[i].price = price;
						break;
						// 클래스안에 있으면 arr[i]가 this로 변경된다.
					}

				}
				break; // 추가하고나서 case 0 으로 넘어가면 안되니 break

				// for문 안에서 입력을 받아도 되지만 강사님은 for문이 긴 것을 좋아하지 않는다고
				// 하시기 때문에 밖에서 입력하는 것을 선호하신다고한다.

			case 2: // 전체 도서 출력
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] != null) { // 배열의 각 초기값 null을 처리(회피)하기 위한 if
						System.out.printf("%s %s %s: %,d원\n", arr[i].name, arr[i].author, arr[i].publisher,
								arr[i].price);
					}

				}
				break;

			case 0: // 종료
				System.out.println("프로그램을 종료합니다.");
				break MAIN;

			}

		}
		// 마무리 & 종료
		sc.close();
	}
}
