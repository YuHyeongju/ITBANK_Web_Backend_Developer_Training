package student;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 1, 1, 100, 60, 76);

		String str = s1.info();

		System.out.println(str);

		Student s2 = new Student();
		s2.name = "홍길동";
		s2.ban = 1;
		s2.no = 1;
		s2.kor = 100;
		s2.eng = 60;
		s2.math = 76;

		System.out.println("이름: " + s2.name);
		System.out.println("총점: " + s2.getTotal());
		System.out.println("이름: " + s2.getAvg());
		System.out.println();

		Scanner sc = new Scanner(System.in);
		Handler handler = new Handler();
		int menu;
		String studentName;
		int studentBan;
		int studentNo;
		int jumsuKor;
		int jumsuEng;
		int jumsuMath;
		int row;
		String searchName;

		while (true) {
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 출력");
			System.out.println("3. 학생 정보 검색");
			System.out.println("4. 평균으로  정렬");
			System.out.println("5. 이름으로 정렬");
			System.out.println("0. 프로그램 종료");
			System.out.println("입력>>>");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.print("학생 이름 입력: ");
				studentName = sc.next();
				System.out.print("\n반 입력: ");
				studentBan = sc.nextInt();
				System.out.print("\n번호 입력: ");
				studentNo = sc.nextInt();
				System.out.print("\n국어 점수 입력: ");
				jumsuKor = sc.nextInt();
				System.out.print("\n영어 점수 입력: ");
				jumsuEng = sc.nextInt();
				System.out.print("\n수학 점수 입력: ");
				jumsuMath = sc.nextInt();
				
				row = handler.addStudent(studentName, studentBan, studentNo, jumsuKor, jumsuEng, jumsuMath);
				
				System.out.println();
				System.out.println(row != 0 ? "추가성공" : "추가실패");
				System.out.println();
				break;
				
			case 2:
				
				handler.showStudent();
				break;
				
			case 3:
				
				System.out.print("학생 이름 입력: ");
				searchName = sc.next();
				handler.studentSearch(searchName);
				System.out.println();
				break;
				
			case 4:	
				
				handler.sortStudentByAvg();
				handler.showStudent();
				break;
			case 5:
				handler.sortStudentByName();
				handler.showStudent();
			case 0:
				
				sc.close();
				return;
				
			default: 
				System.out.println("잘못 입력하셨습니다.");
				
			}
			
		}

	}

}
