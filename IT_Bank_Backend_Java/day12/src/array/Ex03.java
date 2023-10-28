package array;

public class Ex03 {

	public static void main(String[] args) {
		
		// 정수형 배열을 참조 할 수 있는 참조변수를 생성하고 null로 초기화하세요. 
		int[] arr = null;
		
//		System.out.println("배열의 길이 " + arr.length);
		
		
		// 배열을 리터럴 형식으로 초기화하는 것은 배열 선언시에만 가능함.
		// arr = {1,2,3,4,5};
		
		int[] arr2 = new int[] {1,2,3,4,5};
		
		arr = new int[] {1,3,5,7,9};
		
		//배열에는 index가 존재하고, index는 항상 0부터 시작함.
		/*
		 * 			index [0][1][2][3][4]
		 * 			arr = {1,3,5,7,9};
		 * 			arr[0] = 1;
		 * 			arr[1] = 3;
		 * 			arr[2] = 5;
		 * 			arr[3] = 7;
		 * 			arr[4] = 9;
	
		 */
		System.out.println("arr[0] : " + arr[0]);
		System.out.println("arr[1] : " + arr[1]);
		System.out.println("arr[2] : " + arr[2]);
		System.out.println("arr[3] : " + arr[3]);
		System.out.println("arr[4] : " + arr[4]);
		System.out.println();
		
		for(int i = 0; i < 5; i++) {
			System.out.printf("arr[%d] : %d\n", i , arr[i]);
		}
		System.out.println();
		
		for(int i = 0; i < 5; i++) {
			//System.out.println((i+1)*10); 10,20,30,40,50 출력
			arr[i] = (i + 1 ) * 10;
		}
		// 값이 다시 바뀌었는지 확인 
		for(int i = 0; i < 5; i++) {
			System.out.printf("arr[%d] : %d\n", i , arr[i]);
		}
		System.out.println();
		
		// 1) arr의 각 값에 5씩 더한 이후 출력하세요.
		for(int i = 0; i < 5; i++) {
			
			arr[i] += 5;
			System.out.printf("arr[%d] : %d\n", i , arr[i]);
		}
		System.out.println();
		// 2) arr의 각 요소 (element, member) 중에서 3의 배수만 골라서 모두 합친 값을 출력
		// 배열의 길이 : 배열의 전체 크기 / 단일 자료형이 크기
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {
			if(arr[i] % 3 == 0) {
				sum += arr[i];
			}
		}
		System.out.println("3의배수의 합계: " +  sum);
	}

}
