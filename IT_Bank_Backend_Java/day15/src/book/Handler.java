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

	public void showOneBook(String searchBook) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].bookName.contains(searchBook) == true) {
				System.out.printf("책 이름: %s\n저자: %s\n책 번호: %d\n", arr[i].getBookName(), arr[i].getAuthor(),
						arr[i].getBookNum());
			}
		}
		System.out.println("그 책은 존재하지 않습니다.");
	}

	public void showAllBook() {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				System.out.printf("책이름: %s, 저자: %s, 책번호: %d\n", arr[i].getBookName(), arr[i].getAuthor(),
						arr[i].getBookNum());
			}
		}
	}
	public void sortBookByName() {	// 문자열 비교: compareTo
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {	
				if(arr[i] != null && arr[j] != null && arr[i].getBookName().compareTo(arr[j].getBookName()) > 0) {
					Book tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

}
