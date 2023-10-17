package quiz;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		// 두 정수를 입력 받아서 더 큰 정수를 화면에 출력하세요.

		int num1, num2;
		Scanner sc = new Scanner(System.in);

		System.out.println("첫번째 수 입력: ");
		num1 = sc.nextInt();

		System.out.println("두번째 수 입력: ");
		num2 = sc.nextInt();

		if (num1 > num2) {
			
			System.out.println("첫번째 수가 더 큽니다.");
			
		} else if (num1 < num2) {
			
			System.out.println("두번째 수가 더 큽니다.");
			
		} else {
			
			System.out.println("두 수의 크기가 같습니다.");
			
		}

		sc.close();

	}

}
