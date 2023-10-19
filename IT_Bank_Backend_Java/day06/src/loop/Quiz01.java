package loop;

public class Quiz01 {

	public static void main(String[] args) {
		// 1) 자신의 이름을 5회 반복하여 출력하세요.

		String name = "유형주";
		int i = 0;
		while (i < 5) {
			System.out.println(name);
			i++;
		}
		System.out.println();

//		for (int i = 0; i < 5; i++) {
//			System.out.println("유형주");
//		}

		// 2) 0부터 5까지 한 줄에 출력하세요.

		int num = 0;

		while (num < 6) {

			System.out.println(num);
			num++;
		}
		System.out.println();

		// 3) 5부터 0까지 한 줄에 출력하세요.

		num = 5;
		while (num >= 0) {
			System.out.println(num);
			num--;
		}
		System.out.println();

		// 4) 1부터 100까지 합계를 구하여 출력하세요.

		num = 1;
		int sum = 0;

		while (num <= 100) {
			sum += num;
			num++;
		}
		System.out.println("1에서 100까지의 합: " + sum);
		
		System.out.println();

		// 5) 1부터 100까지의 정수 중, 7의 배수만 한 줄에 출력하세요.

		num = 1;

		while (num < 101) {
			num++;
			if (num % 7 == 0) {
				System.out.println(num);
			}

		}
		
		/*
		 * num = 7;							초기값 변경
		 * while( num <101 ){				조건은 그대로
		 * System.out.print(i + " ");		
		 * i += 7;							7씩 증가해야하기 때문에 if를 쓰지 않아도 됨.
		 * }
		 * System.out.println();
		 * 
		 * 
		 * */
	}

}
