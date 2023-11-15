package book3;

// 데이터 저장소(배열 -> 리스트 -> 파일 -> DB)를 직접 참조하거나, 연결할 수 있음.

// 프로그램의 주요 기능(목록/추가/삭제 등)을 모아둔 클래스

public class Handler {

	private Book[] arr = new Book[10];

	public void showList() {
		// 배열을 전달받아서 배열 내부의 각 객체를 서식에 맞게 출력하는 함수
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) { 									// 배열의 각 초기값 null을 처리(회피)하기 위한 if
				System.out.printf("책이름: %s\n저자: %s\n출판사: %s\n가격: %,d원\n", arr[i].getName(), arr[i].getAuthor(),
						arr[i].getPublisher(), arr[i].getPrice()); // getter를 이용하여 출력
			}

		}

	}

	public int insertBook(Book ob) {
		int row = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				arr[i] = ob;
				row = 1;
				break;
			}

		}
		return row;
	}

	public int deleteBook(String name) {
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

}
