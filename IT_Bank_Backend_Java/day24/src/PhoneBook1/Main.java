package PhoneBook1;

import java.util.List;
import java.util.Scanner;

public class Main {
	static PhoneBookDTO getDTOFromUserInput(Scanner sc) {
		PhoneBookDTO dto = new PhoneBookDTO();

		System.out.print("이름 입력 : ");
		dto.setName(sc.nextLine()); // dto.name = sc.nextLine();

		System.out.print("전화번호 입력 : ");
		dto.setPnum(sc.nextLine());

		System.out.print("나이 입력 : ");
		dto.setAge(Integer.parseInt(sc.nextLine()));

		System.out.print("즐겨찾기 (Y/N) : ");
		dto.setFavorite(sc.nextLine());

		return dto;
	}

	public static void main(String[] args) {
		Handler handler = new Handler();	// 핸들러 객체 생성
		List<PhoneBookDTO> list = null;		//  PhoneBookDTO 타입의 리스트 초기화
		PhoneBookDTO dto = null;			// dto 초기화
		Scanner sc = new Scanner(System.in);
		int menu = -1;
		String name, pnum;
		int row = -1;

		MAIN: while (menu != 0) {
			System.out.println("메뉴출력");
			System.out.println("1. 전체 목록");
			System.out.println("2. 추가");
			System.out.println("3. 전화번호 수정");
			System.out.println("4. 즐겨찾기 수정");
			System.out.println("5. 삭제");
			System.out.println("0. 종료");
			System.out.print("입력: ");
			menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:

				list = handler.showList();	// 핸들러에서 showList 결과값을 받아서 리스트 저장
				list.forEach(System.out::println);	// 리스트를 출력
				break;

			case 2:

				dto = getDTOFromUserInput(sc);	// 입력받아서 dto에 저장
				row = handler.insertPhonebook(dto);	// 핸들러에 추가메서드에서 row를 받아서 저장
				System.out.println(row != 0 ? "추가성공" : "추가실패"); // row값으로 성공 실패 구분
				break;

			case 3:
				System.out.println("수정할 전화번호 입력: ");
				pnum = sc.nextLine();
				System.out.println("이름 입력: ");
				name = sc.nextLine();
				System.out.println(row != 0 ? "수정성공" : "수정실패");
				dto.setPnum(pnum);						// dto에 setPnum에게 전화번호 넘겨줌

				row = handler.updatePnum(name, pnum);	// 핸들러에 updatePnum 호출 후 결과를 row에 저장 
				break;

			case 4:
				System.out.println("즐겨찾기 등록 및 해제");
				System.out.println("즐겨찾기 상태를 변경할 사람의 이름 입력: ");
				name = sc.nextLine();
				row = handler.updatefavorite(name);	// 핸들러에 즐겨찾기 메소드 호출해서 결과를 row에 저장
				break;
			case 5:
				System.out.println("삭제할 사람의 이름 입력: ");
				name = sc.nextLine();	
				row = handler.delete(name);				// 핸들러에 삭제 함수 호출 row에 저장 
				System.out.println(row != 0 ? "삭제성공" : "삭제실패");	// row값으로 성공 실패 반환
				break;

			case 0:
				break MAIN;
			}

		}
		sc.close();
		System.out.println("프로그램을 종료합니다.");

	}// end of Main

}// end of class
