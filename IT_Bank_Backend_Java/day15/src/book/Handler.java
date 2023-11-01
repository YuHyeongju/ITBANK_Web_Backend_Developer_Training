package book;

// 1) 단일데이터의 배열
// 2) 데이터를 제어하기위한 함수들

public class Handler {

	private Book[] arr = new Book[5];

	public int addBook(String bookName, String author, int bookNum) {
		int row = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = new Book();
				arr[i].setBookName(bookName);
				arr[i].setAuthor(author);
				arr[i].setBookNum(bookNum);
				row = 1;
				break;
			}
		}

		return row;
	}

	public void showBook() {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				System.out.printf("책이름: %s, 저자: %s, 책번호: %8d\n", arr[i].getBookName(), arr[i].getAuthor(),
						arr[i].getBookNum());
			}
		}
	}

}
