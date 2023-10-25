package function;

public class Ex03 {
	// 두 정수 중에서 가장 큰 수 반환
	static int getMaxNum(int n1, int n2) {

		return n1 > n2 ? n1 : n2;

	}

	// 세 정수 중에서 가장 큰 수 반환
	static int getMaxNum(int n1, int n2, int n3) {
		int max = 0;

		max = n1;
		if (max < n2) {
			max = n2;
		}
		if (max < n3) {
			max = n3;
		}

		return max;
		
		
		
	}
	static int getMaxNum(int... arr) { 			// 같은 자료형의 여러 매개변수 개수가 일정하지 않을때
									   			// 가변인자: 인자의 개수가 일정하지 않다.
		int max = 0;					
		for(int i = 0; i < arr.length; i++) {	// 매개변수들을 순서대로 조회하면서  
			int num = arr[i];					// 각 숫자를 num이라 할 때 
			if(max  < num) {					// 기존 최대값보다 더 큰 값이 있으면
				max = num;						// 그 값을 최대값에 담는다.
			}
			
		}	
		// for(int num : arr){					향상된 for문
		// 	if(result < num)
		//		result = num;
		//	}
		
		
		return max;
	}

	public static void main(String[] args) {
		int num1 = getMaxNum(10, 20);
		int num2 = getMaxNum(3, 4, 5);
		int num3 = getMaxNum(1, 2, 3, 4 , 5, 60 , 700 , -8, 900);
		
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		System.out.println("num3: " + num3);
	}

}
// 오버로딩 개념 필기
// 같은 이름의 메서드를 중복하여 정의하는것
// 매개변수의 개수나 타입이 달라야 오버로딩을 할 수 있다.