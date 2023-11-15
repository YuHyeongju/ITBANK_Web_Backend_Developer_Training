package book3;

import java.util.Scanner;

public class Main {

// case 1 입력부분 , Scanner를 매개변수로 전달받아서 객체를 생성하고, 그 객체를 반환하는 함수.
	
	static Book getBookFromuserInput(Scanner sc) { // 나중에 이 부분은 화면으로 바뀔 것이기 떄문에 
		Book book = new Book();					   // handler로 보낸 것들은 화면에 보이지 않는 
		String name, publisher, author;			   // 백엔드적인 요소가 될 것이기 때문에 보냈다.
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

	public static void main(String[] args) {
		Handler handler = new Handler();
		Scanner sc = new Scanner(System.in);
		Book book = new Book();
		String name;
		int menu;
		int row = 0; // 추가 및 삭제가 정상적으로 수행되었는지 확인하기 위한 변수

		// 입력 및 출력 (자료형 + 대입, 제어문 + 연산자 활용)
		while (true) {

			System.out.println("1. 추가"); // 사용자 메뉴 출력
			System.out.println("2. 목록");
			System.out.println("3. 삭제");
			System.out.println("0. 종료");
			System.out.println("메뉴입력: ");
			menu = Integer.parseInt(sc.nextLine());

			switch (menu) { // 사용자가 입력한 메뉴에 따라서 서로 다른 코드 수행 (분기문)
			case 1: // 도서 추가
				book = getBookFromuserInput(sc);
				row = handler.insertBook(book);
				System.out.println(row != 0 ? "추가성공" : "추가실패");
				break;

			case 2: // 도서 전체 출력
				handler.showList();
				break;

			case 3:
				// 배열 내부의 도서중에서 이름이 일치하는 객체를 찾아서 제거

				System.out.println("삭제할 책이름을 입력하여주세요: ");
				name = sc.nextLine();
				row = handler.deleteBook(name);	// 입력받은 이름을 name에 저장하여 delete 메서드에 인자 값으로 전달
				System.out.println(row != 0 ? "삭제성공" : "삭제실패");

				break;

			case 0: // 종료
				sc.close();
				System.out.println("프로그램을 종료합니다.");

			}

		}

	}
}
