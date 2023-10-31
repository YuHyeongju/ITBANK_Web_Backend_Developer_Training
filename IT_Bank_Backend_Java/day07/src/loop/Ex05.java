package loop;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) throws Exception {
		// 입력받은 숫자를 이용하여 진행 상황 출력하기
		Scanner sc = new Scanner(System.in);
		int maxSize = 100;
		int currentSize;

		System.out.print("현재 진행률 출력: ");

		currentSize = sc.nextInt();

		System.out.print("[");
		for (int i = 0; i < maxSize / 2; i++) {	// 총 칸의 크기는 50칸
			if (i == maxSize / 2 / 2) {			// 50칸의 절반위치에 진행률 숫자 표시
				System.out.printf("%2d %%", currentSize);

			} else if (i < currentSize / 2) {//	입력 퍼센트의 절반보다 작으면
				System.out.print("#");		//	#을 이용하여 현재 진행된 영역표시
			} else {						// 	입력 퍼센트의 절반보다 같거나 크면
				System.out.print("_");		//	공백 혹은 언더바를 이용하여 아직 진행되지 않음을 표시
			}
			Thread.sleep(200); // 진행속도를 늦추기
		}
		System.out.println("]");
		sc.close();

	}

}
