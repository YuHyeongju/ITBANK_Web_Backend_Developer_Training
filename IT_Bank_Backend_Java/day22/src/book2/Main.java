package book2;

import java.util.Scanner;

public class Main {
	static void showList(Book[] arr) {
		// 배열을 전달받아서 배열 내부의 각 객체를 서식에 맞게 출력하는 함수(case 2)
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) { // 배열의 각 초기값 null을 처리(회피)하기 위한 if
				System.out.printf("%s %s %s: %,d원\n", arr[i].getName(), arr[i].getAuthor(), arr[i].getPublisher(),
						arr[i].getPrice()); // getter를 이용하여 출력
			}

		}

	}

// case 1 입력부분 , Scanner를 매개변수로 전달받아서 객체를 생성하고, 그 객체를 반환하는 함수.	
	static Book getBookFromUserInput(Scanner sc) {
		Book book = new Book();
		String name, publisher, author;
		int price;
		
		
		System.out.print("도서이름 입력: ");
		name = sc.nextLine();

		System.out.print("저자 입력: ");
		author = sc.nextLine();

		System.out.print("출판사 입력: ");
		publisher = sc.nextLine();

		System.out.print("가격 입력: ");
		price = Integer.parseInt(sc.nextLine());

		book.setName(name);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setPrice(price);
		return book;

	}

	// 도서 이름을 전달받아서 배열 안에서 일치하는 객체를 찾아서 삭제하는 함수
	static int deleteBook(String name, Book[] arr) {
		int row = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].getName().equals(name)) {
				arr[i] = null; // 참조변수가 객체를 참조하지 않도록 한다.
				row = 1; // 모두에게서 잊혀진 참조변수는 소멸됨
				break; // 삭제했다는 결과를 반환하기 위해 row값을 1로 설정
			} // 하나 지웠으면 중단한다.
		}
		return row;
	}
	// . 을 사용했는데 값이 null이면 NullPointerException 출력됨
	// 리스트를 사용하면 이런 문제가 없어짐 - 리스트는 크기가 알아서 줄어듦
	// 참조변수에 null을 넣으면 참조하는 객체가 소멸했기때문에 더 이상 참조 할 수 없음.
	
	// arr = {null, null,null,null,null}

	// 입력, 출력( 자료형 + 대입 연산자 활용)  
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book book = new Book();
		Book[] arr = new Book[5];
		String name;
		int menu;
		int row = 0; // 추가 및 삭제가 정상적으로 수행되었는지 확인하기 위한 변수

		while (true) {

			System.out.println("1. 추가"); // 사용자 메뉴 출력
			System.out.println("2. 목록");
			System.out.println("3. 삭제");
			System.out.println("0. 종료");
			System.out.println("메뉴입력: ");
			menu = Integer.parseInt(sc.nextLine());

			switch (menu) { // 사용자가 입력한 메뉴에 따라서 서로 다른 코드 수행 (분기문)
			case 1: // 도서 추가
				
				book = getBookFromUserInput(sc);
				
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == null) {
						arr[i] = book;
						
						break;
					}

				}
				break;

			case 2: // 도서 전체 출력
				showList(arr);
				break;

			case 3:
				// 배열 내부의 도서중에서 이름이 일치하는 객체를 찾아서 제거

				System.out.println("삭제할 책 이름을 입력하여주세요: ");
				name = sc.nextLine();

				row = deleteBook(name, arr);
				System.out.println(row != 0 ? "삭제성공" : "삭제실패");

				break;

			case 0: // 종료
				sc.close();
				System.out.println("프로그램을 종료합니다.");

			}

		}

	}
}
