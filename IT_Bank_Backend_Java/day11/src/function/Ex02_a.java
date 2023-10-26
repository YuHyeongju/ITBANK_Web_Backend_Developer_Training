package function;

import java.util.Scanner;

public class Ex02_a {

	public static void main(String[] args) {
		// 함수 없이 메인함수에서 모든 것을 처리

		Scanner sc = new Scanner(System.in);
		String name;
		String birth;
		String result;
		boolean isNumeric = true;

		System.out.print("이름 입력: ");
		name = sc.nextLine();

		while (true) {
			System.out.print("생년월일 입력(YYMMDD): ");
			birth = sc.nextLine();

			for (int i = 0; i < birth.length(); i++) {
				char ch = birth.charAt(i);
				if (('0' <= ch && ch <= '9') == false) {
					isNumeric = false;
				} else {
					isNumeric = true;
				}

			}
			if (birth.length() == 6 && isNumeric == true) {
				break;
			} else {
				isNumeric = false;
				System.out.println("다시입력하여주세요 !!");
			}

		}

		int year = Integer.parseInt(birth.substring(0, 2));
		year += (23 < year) ? 1900 : 2000;
		int month = Integer.parseInt(birth.substring(2, 4));
		int date = Integer.parseInt(birth.substring(4));

		int age = 2023 - year;

		String form = "%s님은  %d살이고, %4d-%02d-%02d 출생입니다.";
		result = String.format(form, name, age, year, month, date);

		System.out.println(result);
		sc.close();
	}

}
