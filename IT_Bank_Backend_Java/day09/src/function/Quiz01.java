package function;

public class Quiz01 {
	
	static String getSign(int num) {
		String answer = String.valueOf(num);
		return answer;
	}
	
	static int getReverseNum(int num) {				//	정수 거꾸로 뒤집는 알고리즘
		int answer = 0;								//	나눗셈을 활용한 자릿수 구분
													//	num		answer	|				| 	
		while(num != 0) {							//  1234	0		|	123		4	|	1	432
			answer *= 10;							//  1234	0		|	123		40	|	1	4320
			answer += num % 10 ;   					//  1234	4		|	123		43	|	1	4321
			num /= 10;								//  1234	4		|	12		43	|	0	4321
		}											
		return answer;
	}
	
	static int pow(int n3, int n4) {
		int answer =  1; 
		
		for(int i = 0;  i < n4; i++) {
			answer *= n3;
		}
		return answer;
	}
	
	
	static int remainder(int n5, int n6) {
		int answer = 0;
		
		answer = n5 % n6;
		
		return answer;
	}
	
	static String getReverseStr(String str) {
		String answer = "";
		
		for(int i = str.length() - 1; i != -1; i--) { //마지막 
			answer += str.charAt(i);
		}
		return answer;
	}
	
	

	public static void main(String[] args) {
		// 1) 정수를 하나 전달받아서, 양수, 음수, 0을 문자열로 반환하는 함수 getSign
		int q1 = 0;
		System.out.println("결과: " + getSign(q1));
		
		// 2) 정수를 하나 전달받아서 정수의 배치를 거꾸로 뒤집어 반환하는 함수 getReverseNum
		int q2 = getReverseNum(1234);
		System.out.println("결과: " + q2);
		
		// 3) 두 정수를 전달받아서 n3의 n4제곱수를 반환하는 함수 pow
		int q4 = pow(2,10);
		System.out.println("결과값: " + q4 );
		
		// 4) 두 정수를 전달 받아서 n5을  n6로 나누었을때 나머지를 반환하는 함수 remainder
		
		int q5 = remainder(100,6); 	

		System.out.println("결과값: " + q5);
		
		
		// 5) 문자열을 하나 전달받아서, 문자열을 거꾸로 배치한 값을 반환하는 함수 getReverseStr
		 String q6 =getReverseStr("my name is apple");
		
		System.out.println("거꾸로 배치한 값: " + q6);
		
		//	함수 호출 코드에 마우스를 올려보세요.
		//	함수 호출 코드에 마우스를 올린 상태로 컨트롤 클릭하면 함수의 정의로 이동
		int test = Integer.parseInt("1234");
		System.out.println(test);
		
	}

}
