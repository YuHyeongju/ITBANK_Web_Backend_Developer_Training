package loop;

import java.util.Random;
import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int answer = ran.nextInt(100) + 1;
		int user;
		int count = 1;

		// 반복을 수행하면서 사용자에게 값을 입력받고,
		// 만약 정답이 입력값보다 작으면 Down
		// 정답이 입력 값보다 크면 UP
		// 일치하면 반복을 중단
		// 반복을 할 때 마다 횟수 증가
		// 반복이 끝나면 정답과 횟수를 출력하고 종료.

		while (true) {
			System.out.println("숫자를 입력하여 주세요: ");
			user = sc.nextInt();

			if (answer > user) {
				System.out.println("UP");

			} else if (answer < user) {
				System.out.println("DOWN");

			} else {
				System.out.println("정답을 맞추셨습니다.\n");
				break;
			}
			count++;
		}
		
		System.out.println("정답은 " + answer + "이고 " + count + "번만에 맞추셨습니다.");
		sc.close();
	}

}
