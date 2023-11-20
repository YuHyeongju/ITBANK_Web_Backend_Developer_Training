package phonebook2;

import java.util.List;
import java.util.Scanner;

public class Main {

	static PhonebookDTO getDTOFromUserInput(Scanner sc) { // 값을 Scanner로 입력받아 
		PhonebookDTO dto = new PhonebookDTO();			  // dto에 값을 전달 

		System.out.println("이름 입력: ");
		dto.setName(sc.nextLine());

		System.out.println("전화번호 입력: ");
		dto.setPnum(sc.nextLine());

		System.out.println("나이 입력: ");
		dto.setAge(Integer.parseInt(sc.nextLine()));

		System.out.println("즐겨찾기 여부 입력 (Y/N): ");
		dto.setFavorite(sc.nextLine());

		return dto;

	}

	public static void main(String[] args) throws Exception {
		Handler handler = new Handler();
		List<PhonebookDTO> list  = null;
		PhonebookDTO dto = null;
		Scanner sc = new Scanner(System.in);
		String name, pnum;
		int idx;
		int row = -1;
		int menu = -1;

		MAIN: while (menu != 0) {
			System.out.println("메뉴선택");
			System.out.println("1. 전체 출력");
			System.out.println("2. 추가");
			System.out.println("3. 전화번호수정");
			System.out.println("4. 즐겨찾기 수정");
			System.out.println("5. 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력: ");
			menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				
				list = handler.showList();				// 헨들러에서 리스트 불러오기
				list.forEach(System.out :: println);	// 출력
				System.out.println();
				break;
			
			case 2:
				
				dto = getDTOFromUserInput(sc);// 수정할 정보 입력
				row = handler.insertPhonebook(dto);
				System.out.println(row != 0 ? "추가성공" : "추가실패");
				break;
				
			case 3: // 수정할 전화번호 입력하고 이름이 맞으면 전화번호 수정 
				
				System.out.print("이름 입력: ");
				name = sc.nextLine();
				System.out.println("수정할 전화번호 입력: ");
				pnum = sc.nextLine();
				System.out.println(row != 0? "수정완료":"수정실패");
				row = handler.updatePnum(name,pnum); // 핸들러의 updatePnum 호출후 결과를 row에 저장
				break;
				
			case 4:
				
				System.out.println("즐겨찾기 등록 및 해제  ");
				System.out.print("즐겨찾기를 수정할 이름 입력: ");
				name = sc.nextLine();
				row = handler.updateFavorite(name);	// 핸들러에게 이름 전달하고 결과를 row에 저장
				System.out.println(row != 0 ? "수정성공":"수정실패");
				break;
				
			case 5:
				System.out.print("삭제할 인덱스 입력: ");
				idx = Integer.parseInt(sc.nextLine());
				row = handler.delete(idx); // 핸들러에게 삭제할 이름 주고 결과를 row에 저장
				System.out.println(row != 0 ? "삭제성공" : "삭제실패");
				break;
				
			case 0:
				break MAIN;
			}

		}
		sc.close();
		System.out.println("프로그램 종료");
	}// end of main
}// end of class
