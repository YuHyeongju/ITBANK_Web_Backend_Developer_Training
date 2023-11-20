package schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	static ScheduleDTO getScheduleForUser(Scanner sc)  {
		ScheduleDTO ob = new ScheduleDTO();
		SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			System.out.println("일정명 입력: ");
			ob.setTitle(sc.nextLine()); 
			System.out.println("시작날짜 입력(-사용): ");
			ob.setStart_date(inputFormatter.parse(sc.nextLine()));
			System.out.println("끝 날짜 입력(-사용): ");
			ob.setEnd_date(inputFormatter.parse(sc.nextLine()));
		}catch( ParseException e) {
			e.printStackTrace();
		}
		return ob;
	}
	
	
	
	public static void main(String[] args) {
		Handler handler = new Handler();
		Scanner sc = new Scanner(System.in);
		int row = -1;
		Date date = null; // java.util.Date는 java.sql.Date의 슈퍼클래스이다.
		List<ScheduleDTO> list = null;
		ScheduleDTO dto = null;
		int menu = -1;
		Date now = handler.getSysdate(); // 시스템 시간을 핸들러에서 호출하여 now에 저장
		int month;								 // 좌변과 우변의 자료형은 같아야함.
		String title;
		
		MAIN: while (menu != 0) {
			System.out.println("=== DB기준 현재시간 ===");
			System.out.println(now);
			System.out.println("123. sql 버전출력");
			System.out.println("1. 전체 출력");
			System.out.println("2. 월별 출력");
			System.out.println("3. 일정 등록");
			System.out.println("4. 일정 삭제");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택: ");
			menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 123:
				//오라클 데이터베이스 버전정보를 문자열로 출력하기
				// select banner from v$version
				String version = handler.getVersion(); // 핸들러의 getVersion을 호출해서
				System.out.println(version);		   // version 변수에 저장
				break;								   // version 변수 출력
				
			case 1:
				list = handler.selectAll();
				for (ScheduleDTO ob : list) {
					System.out.printf("%s:%s ~ %s\n", 
							ob.getTitle(), 
							ob.getStart_date(), 
							ob.getEnd_date()

					);

				}
				break;
			case 2:
				System.out.println("조회할 월 입력: ");
				month = Integer.parseInt(sc.nextLine());
				list = handler.selectMonth(month);
				for(ScheduleDTO ob : list) {
					System.out.printf("%s: %s ~ %s\n",
							ob.getTitle(),
							ob.getStart_date(),
							ob.getEnd_date());
				};
				
				
				break;
			case 3:
				dto = getScheduleForUser(sc);
				row = handler.insertSchedule(dto);
				System.out.println(row != 0 ? "추가성공" : "추가실패");
				break;
			case 4:
				System.out.println("삭제할 일정이름입력: ");
				title = sc.nextLine();
				row = handler.deleteSchedule(title);
				System.out.println(row != 0 ? "삭제성공" : "삭제실패");
				break;
			case 5:
				break MAIN;

			}
			System.out.println(); // 결과 출력하고 한 줄 띄우기
		} // end of while

	}

}
