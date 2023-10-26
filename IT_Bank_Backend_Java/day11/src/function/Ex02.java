package function;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// 이름과 생년월일을 입력받아서
		// 이름, 올해 나이, 생일을 (yyyy-MM-dd) 형식으로
		// 출력하는 코드를 작성하기

		Scanner sc = new Scanner(System.in);
		String name;
		String birth;
		String result;


		System.out.print("이름 입력: ");
		name = sc.nextLine();

		while (true) {
			System.out.print("생년월일 입력(YYMMDD): ");
			birth = sc.nextLine();

			if (birth.length() == 6 && isNumeric(birth)) {
				break;
			}
			System.out.println("다시입력하여주세요 !!");
		}
		result = getInfo(name,birth);
		
		System.out.println(result);
		sc.close();
	}	
	static boolean isNumeric(String str){
		boolean flag = true;
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(('0' <=ch && ch<='9') == false ) {
				return false;	// 반복문 내부에서도 return을 만나면 반복을 중단하고 함수를 종료한다.
			}
		}
		return flag;
	}


	static String getInfo(String name, String birth) {
		String result = "";
		int year = Integer.parseInt(birth.substring(0, 2)); // string 형태를 유지하면서 0~2
		// 자리를 잘라서 int형으로 변환하여 저장

		year +=( 23 < year)? 1900: 2000;
		int month = Integer.parseInt(birth.substring(2,4));
		int date = Integer.parseInt(birth.substring(4));

		int age = 2023 - year;

		//System.out.printf("%s님은  %d살이고, %4d-%02d-%02d 출생입니다.", name, age, year, month);
		String form = "%s님은  %d살이고, %4d-%02d-%02d 출생입니다.";
		result = String.format(form, name, age ,year, month, date);

		return result;
		// String.format :printf 처럼 서식에 맞춰 문자열을 만들어 낸다.(출력하진않음)

	}

}
