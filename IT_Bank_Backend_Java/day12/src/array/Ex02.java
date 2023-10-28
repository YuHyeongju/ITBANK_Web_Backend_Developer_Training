package array;

import java.util.Arrays;

public class Ex02 {

	public static void main(String[] args) {
		// 배열은 일반 변수가 여러개 모여 있다고 생각하면 사용하기 편함.
		
		// 배열의 생성
		int[] arr1 = null;					 // 배열을 가리킬 변수만 생성했음 . 실제 배열 x
											 // 대상을 가리키는 형식의 참조 변수이지만
		                                     // 지금 당장은 가리킬 대상이 없다.
		
		
		int[] arr2 = {1,2,3,4,5};			 // {} 안에 값을 지정하여 생성
		int[] arr3 = new int[] {6,7,8,9,10}; // 배열을 구성할 값을 지정하여 배열을 생성
											 // 이때 배열의 각 값은 자료형에 대응되는 0값으로 자동 초기화가 이루어짐.
											 // 따라서 아래의 배열의 값은 {0,0,0,0,0}이다.
		
		int[] arr4 = new int[5];			 // 배열을 생성할 때는 길이 혹은 값 중 에서 하나의 방법으로만 지정한다.
											 // 둘다 지정하는 것은 문법에 맞지 않음.
	 //int[] arr5 = new int[5] {1,2,3,2,1};  // 문법 틀림
		
		System.out.println("arr1: " + arr1); // null은 가리키는 대상이 없다는 뜻이다.
		
		System.out.println("arr2: " + arr2); // 자바의 배열은 그대로 출력하면 내부 값을 확인 할 수 없음.
		
										     // 값으 확인하려면 반복문을 이용하여 출력할 수 있음.
		for(int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i] + " ");
		}
		System.out.println();

		//java.util.Arrays 클래스의 toString() 함수를 이용하여 변환 후 출력할 수 있다.
		System.out.println("arr4: " + Arrays.toString(arr4));
		
		arr4[0] = 11;	// 배열 이름에 []를 붙이고  안에 index를 적어준다.
		arr4[1] = 33;	// 배열을 구성하는 여러 맴버 요소 중 하나에 접근한다.
		arr4[2] = 55;	// 배열은 여러 변수를 묶은 형태이기 때문에 
		arr4[3] = 77;	// 배열 내  멤버 요소는 변수를 다루는 것과 동일하다.
		arr4[4] = 99;	// 단, index가 length와 같을 수 없음에 항상 주의해야함.  
						// index 의 최대값은 length -1 이다.
		//arr4[5] = -1;	// java.lang.ArrayIndexOutOfBoundsException- 배열의 길이 보다 안에 데이터가 더 길다.
		System.out.println("arr4 : " + Arrays.toString(arr4));
	}

}
