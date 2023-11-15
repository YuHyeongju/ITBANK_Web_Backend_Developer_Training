package book4;

import java.util.ArrayList;

// 데이터 저장소(배열 -> 리스트 -> 파일 -> DB)를 직접 참조하거나, 연결할 수 있음.

// 프로그램의 주요 기능(목록/추가/삭제 등)을 모아둔 클래스

// 저장 구조 변경 -> 기능 코드가 간결해졌다.

public class Handler {

	// private Book[] arr = new Book[10];
	// 배열에서 리스트로 전환 (배열의자료형은 리스트 제네릭 타입이 된다.) 
	private ArrayList<Book> list = new ArrayList<>();

	// array.length list.size()
	// arr[i] list.get(i)
	// arr[i] = ob list.add(ob)
	// arr[i] = null list.remove(i)
	// list.remove(ob)

	public void showList() {
//		// 배열을 전달받아서 배열 내부의 각 객체를 서식에 맞게 출력하는 함수
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i)); // 리스트는 디폴트 값이 null 이다.
//
//		}
//		// 향상된 for문(index를 사용하지 않음)
//		for(Book ob : list) {
//			System.out.println(ob);
//		}
		
		// 람다식 + 컬렉션forEach()
		list.forEach(ob -> System.out.println(ob));
		
//		// 메서드 참조
//		list.forEach(System.out::println); 

//		정적 메소드 참조 (:: 메서드 참조 연산자)
		
//		문법
//		ContainingClass::staticMethodName
//		정적 메소드가 포함된 클래스::정적 메소드명 

// 		출력할 때는  toString이 오버라이딩 되어있다는 전제하에 가능함.		
		
	}

	public int insertBook(Book ob) {
		int row = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] == null) {
//				arr[i] = ob;
//				row = 1;
//				break;
//			}
//
//		}
		boolean flag = list.add(ob); 	// 추가 성공하면  true반환
		row = flag ? 1 : 0;				// true이면 row가 1, 아니면 row가 0 
		return row;
	}

	public int deleteBook(String name) {
		int row = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] != null && arr[i].getName().equals(name)) {
//				arr[i] = null; // 참조변수가 객체를 참조하지 않도록 한다.
//				row = 1; // 모두에게서 잊혀진 참조변수는 소멸됨
//				break; // 삭제했다는 결과를 반환하기 위해 row값을 1로 설정
//			} // 하나 지웠으면 중단한다.
//		}
		boolean flag = list.removeIf(ob -> ob.getName().equals(name)); // 조건에 맞으면 리스트에 구성요소를 삭제
		row = flag ? 1 : 0;
		return row;
		
		// remove는 같으면 전부 삭제하기때문에 객체에 고유성을 확보할 수 있는 키 값이 하나 더 필요해진다.
		// ex) 동명이인일 경우 식별할 회원 Id가 필요해진다.
	}

}
