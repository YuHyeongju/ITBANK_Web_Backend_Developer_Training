package exception;

import java.util.Scanner;

public class Ex04 {
	static int getDivide(int n1, int n2) throws ArithmeticException { // 0으로 나누는 문제를 main에게 전가시킴
		return n1 / n2; // callee: 호출당하는 함수(알바생)
						// employee
	}

	public static void main(String[] args) throws Exception{ // caller: 다른 함수를 호출하는 함수(사장님)
		// 예외 전가(throws) 
		// employer
		// callee에서 발생한 예외를 caller에게 전가시킴

		int n1, n2, answer;
		Scanner sc = new Scanner(System.in);

		System.out.println("정수 2개 입력: ");
		n1 = sc.nextInt();
		n2 = sc.nextInt();

		answer = getDivide(n1,n2);
		System.out.printf("%d / %d = %d\n", n1, n2, answer);
		
		
//		try {
//			answer = getDivide(n1, n2);
//			System.out.printf("%d / %d = %d\n", n1, n2, answer);
//		} catch (ArithmeticException e) {
//			System.out.println("숫자를 0으로 나눌 수 없습니다.");
//			answer = 0;
//		}
// main에 throws Exception를 걸수도 있으나 추천하지 않음.
		sc.close();

	}

}
