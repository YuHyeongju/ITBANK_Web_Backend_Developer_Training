package updown;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// 스캐너 생성
		Random ran = new Random();				// 랜덤값 생성
		int cpu, user, count = 0;				// 변수 생성, 초기화

		cpu = ran.nextInt(100) + 1; // 게임시작 전에 컴퓨터가 숫자 랜덤 생성(0 제외)

		while (true) {
			System.out.println("숫자 입력(1 ~ 100): ");
			user = sc.nextInt();						// 사용자에게 숫자 입력 받기
			count++;									// 횟수 증가
			if (user == cpu) {							// 랜덤으로 나온 숫자와 입력받은 수가 같으면 break;
				break;
			} else if (user < cpu) {					// 입력한 수보다 랜덤으로 나온 수가 크면 up
				System.out.println("UP");
			} else if (user > cpu) {					// 반대의 경우, down
				System.out.println("Down");
			}

		}
		System.out.printf("정답: %d회만에 정답을 맞추었음\n", count); // 몇 회만에 맟추었는지 카운트 횟수 출력
		sc.close();		// 스캐너 종료 (cpu, count값을 새로 지정하면 다시 실행 가능)

	}

}
