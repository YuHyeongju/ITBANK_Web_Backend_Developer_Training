package array;

import java.util.Arrays;

public class Ex06 {

	public static void main(String[] args) {
		// 배열에서의 최소값/최대값을 구하려는 작업이 필요할 때
		// 배열이 값들이 크기순으로 이미 정렬되어 있다면 훨씬 구하기 쉽다
		// 배열을 정렬하기 위해서는 서로 다른 두 값의 크기를 비교하여 "자리를 바꿔야함."
		
		
		// 선택 정렬 알고리즘
		// 배열의 각 자리에 맞는 값을 선택하여 자리를 교체하면서 정렬을 수행하는 알고리즘
		
		int[] arr = {4,8,2,7,6};
		
		System.out.println(Arrays.toString(arr));  // 배열을 문자열 형식을 바꾸어 출력
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) { // i 째 인덱스와 i + 1 번째 인덱스 비교
				if(arr[i] > arr[j] ) {					
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}											// 코드를 안보고 쓸 수 있었으면 좋겠다. -> 시험에 내겠다.
		System.out.println(Arrays.toString(arr));
	}

}
