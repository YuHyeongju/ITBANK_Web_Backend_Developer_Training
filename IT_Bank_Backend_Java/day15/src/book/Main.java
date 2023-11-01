package book;

import java.util.Scanner;

// 사용자와 상호작용(입출력)
// 입력값에 따라서 handler의 함수를 호출

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Handler handler = new Handler();
		int menu;
		String bookName;
		String author;
		int bookNum;
		int row;

		

		while (true) {
			System.out.println("1.책 정보 등록");
			System.out.println("2.책 정보 출력");
			System.out.println("0.프로그램 종료");
			System.out.println("입력 >>>");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.print("책 이름 입력>>");
				bookName = sc.next();
				System.out.print("저자 입력>>");
				author = sc.next();
				System.out.print("책 번호 입력>>");
				bookNum = sc.nextInt();
				row = handler.addBook(bookName, author, bookNum);

				System.out.println(row != 0 ? "추가성공" : "추가실패");
				break;

			case 2:
				handler.showBook();
				break;
			case 0:
				sc.close();
				return;

			default:
				System.out.println("잘못 입력하셨습니다.");

			}

		}

	}
}
