package control;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		int num1;
		int num2;
		int year, month, day;
		String gender = null;

		System.out.println("주민등록번호 13자리 입력 (xxxxxx-yyyyyyy)");
		System.out.printf("입력: ");
		input = sc.next();

		num1 = Integer.parseInt(input.split("-")[0]);
		num2 = Integer.parseInt(input.split("-")[1]);

		System.out.println("주민등록번호 앞자리 : " + num1);
		System.out.println("주민등록번호 뒷자리 : " + num2);
		System.out.println();

		// 4자리의 출생년도, 2자리의 출생월, 2자리의 출생일
		// 그리고 성별은 문자열로 준비하여 모두 출력하세요.
		// 980319-1124610

		year = num1 / 10000; // 앞에 두자리만 남음
		month = num1 / 100 % 100; // 가운데를 추출하기위해 /100 하면 앞에 네자리가 남는데 그상태에서
									// %100 연산을 해주면 출생월이 나머지로 남음
		day = num1 % 100; // 6자리에서 나머지 연산 해서 출생일을 남김

//		day = num1 % 100;				num1	year	month	day
//										930516	?		?		16
//		num1 /= 100;					9305	?		?		16
//										9305	?		5		16
//		month = num1 % 100;				9305	93		5		16
//		
//		year = num1 / 100;

		switch (num2 / 1000000) { // 뒷자리 케이스 9, 0, 1,2,3,4로 시작
		case 9:
			year += 1800;
			gender = "남성";
			break;
		case 0:
			year += 1800;
			gender = "여성";
			break;
		case 1:
			year += 1900;
			gender = "남성";
			break;
		case 2:
			year += 1900;
			gender = "여성";
			break;
		case 3:
			year += 2000;
			gender = "남성";
			break;
		case 4:
			year += 2000;
			gender = "여성";
			break;

		}

		System.out.printf("출생년도: %d년, 출생월: %d월, 출생일: %d일, 성별:%s", year, month, day, gender);

//		정수서식
//		%d       	: 정수를 그대로 출력합니다.
//		%6d			: 정수를 그대로 출력합니다. 자릿수가 6보다 작으면 출력이 왼쪽에 채워집니다.
//		%-6d  		: 정수를 그대로 출력합니다.자릿수가 6보다 작으면 출력이 오른쪽에 채워집니다.
//		%06d		: 정수를 그대로 출력합니다. 자릿수가 6보다 작으면 왼쪽에 0이 채워집니다.
//		%.2d 		: 정수의 최대 2 자리를 인쇄합니다.
//		
//		문자열 서식
//		%s       	: 문자열을 그대로 출력합니다.
//		%15s    	: 문자열을 그대로 출력합니다. 문자열의 길이가 15 자보다 작 으면 출력이 왼쪽에 채워집니다.
//		%-6s  		: 문자열을 그대로 출력합니다. 문자열의 길이가 6 자보다 작 으면 오른쪽에 출력이 채워집니다.
//		%.8d 		          ㅊㅍㅍㅍㅍ: 문자열의 최대 8자를 인쇄합니다.

	}
	// 이클립스 디버깅
	// 1) 중단점을 설정한다.
	// 2) F11을 눌러서 디버깅을 시작한다.
	// 3) F6번을 누를때 마다 한죽씩 실행되고, 우측에서 변수의 값을 확인할 수 있다.

}
