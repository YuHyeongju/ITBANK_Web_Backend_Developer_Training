package test;

import java.util.Random;

// 선택정렬 함수를 만들어야합니다.
// 중복없는 랜덤정수 6개로 구성된 배열을 반환하는 함수를 만들어야한다.
// (1 ~ 45 사이의 랜덤정수)

public class test01 {
	static void getNum(int[] arr) {
		Random ran = new Random();

		for (int i = 0; i < 6; i++) {
			arr[i] = ran.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
				}
			}

		}

	}

	static int[] selectionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}

	
	public static void main(String[] args) {

		System.out.println("응시자: 유형주\n");
		int[] arr = new int[6];
		for (int i = 0; i < 5; i++) {
			getNum(arr);
			selectionSort(arr);
			System.out.printf("%2d,%2d,%2d,%2d,%2d,%2d\n", arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
		}

	}
}
