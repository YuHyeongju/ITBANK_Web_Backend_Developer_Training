package loop;

public class Ex02 {

	public static void main(String[] args) {
		// 횟수로 반복하는 경우

		for (int i = 0; i < 5; i++) {
			System.out.println((char)('A' + i) + " ");
//			System.out.println((char)('A' + 0 )+ " ");
//			System.out.println((char)('A' + 1 )+ " ");
//			System.out.println((char)('A' + 2 )+ " ");
//			System.out.println((char)('A' + 3 )+ " ");
//			System.out.println((char)('A' + 4 )+ " ");

		}
		System.out.println();

		// 2) 특정 요소의 길이를 횟수로 지정하여 반복하기
		int[] arr = { 4, 8, 2, 7, 6 }; // int형 변수 5개 묶음

//		for(int i = 0; i < 5; i++)
		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			System.out.println(num + " ");
		}
		System.out.println();

//		3) 특정 묶음요소(배열 , 리스트등...)의 각 맴버 요소를 기준으로 반복
		// 향상된 for문
		for (int num : arr) { // iterable : 순회(순서대로 조회) 가능한 요소이다.
			System.out.println(num + " ");
		}
		System.out.println();

		// 프로그램의 목적: 편리하게 작업을 수행하기 위해서
		// 데이터를 처리하여 출력하는 작업
		// 데이터의 수가 한 두개가 아님
		// 통상적인 프로그램은 처리해야 할 데이터의 갯수가 많다. <- for문을 사용 할 수 밖에 없는 이유

		// for문의 기본구조
		int cnt = 0; 					// 반복횟수를 제어할 변수
		while (cnt < 5) { 				// 반복조건
			System.out.println(cnt); 	// 종속문장
			cnt++; 						// 횟수에 대한 증감
		}
		System.out.println();

		for (int i = 0; i < 5; i++) { // for(1;2; 4;){
			System.out.println(i); 	  //   3
		} 							  // }
		System.out.println();

	}

}
