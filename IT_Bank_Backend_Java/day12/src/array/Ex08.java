package array;

import java.util.Arrays;
import java.util.Random;

public class Ex08 {
	
	
	static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	static void plus(int num) {
		num += 1;
	}
	
	
	

	public static void main(String[] args) {
		
		int n1 = 5;							// 기본타입: 데이터를 변수에 직접 저장
		System.out.println("n1 : " + n1);
		plus(n1);
		System.out.println("n1:" + n1);
		
		
		
		
		Random ran = new Random();
		int[] arr = new int[1000000];
		for(int i = 0; i < arr.length; i++) {	// 참조타입: 참조하는 위치를 넘겨받음
			arr[i] = ran.nextInt(arr.length);
		}
		System.out.println(Arrays.toString(arr));
		
		long start = System.currentTimeMillis();
		selectionSort(arr);
		long end = System.currentTimeMillis();
		
		System.out.println(Arrays.toString(arr));
		System.out.printf("%.2f sec\n", (end - start) / 1000.0);
	}

}
