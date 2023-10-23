package loop;

public class Ex03 {

	public static void main(String[] args) {
		// for문 기본 연습 문제

		// 1) 1에서 10사이 정수의 합계를 구하여 출력
		int sum = 0;

		for (int i = 0; i <= 10; i++) {
			sum += i;

		}
		System.out.println("1에서 10사이 정수의 합계:  " + sum);
		System.out.println();

		// 2) 11에서 20사이 정수의 합계를 출력

		sum = 0;

		for (int i = 11; i <= 20; i++) {
			sum += i;

		}
		System.out.println("11에서 20사이 정수의 합계: " + sum);
		System.out.println();

		// 3) 5에서 0까지 세로로 출력

		for (int i = 5; i >= 0; i--) {
			System.out.println(i);
		}

	}

}
