package function;

public class Ex02 {

	static int add(int n1, int n2) {
		int answer = 0;
		int sum = 0;
		sum = n1 + n2;
		return answer;

	}

	static int getMinNumber(int n1, int n2, int n3) {
		int min = 0;

		min = n1;
		if (min > n2) {
			min = n1;
		}
		if (min > n3) {
			min = n3;
		}
		return min;
	}

	static String upperCase(String Str) {
		String answer = "";

		for (int i = 0; i < Str.length(); i++) {
			char ch = Str.charAt(i); 				// Str에 i번째 문자를 ch에 넣어줌.
			if (i == 0 && 'a' <= ch && ch <= 'z') { // 첫 글자이고, ch가 소문자일때 대문자로 변환
				ch -= 32;
			}
			answer += ch;

		}
		return answer;
	}

	static String substring(String str, int from, int to) {
		String answer = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (from <= i && i < to) {
				answer += ch;
			}

		}
		/*
		 for(int i = from; i < to; i++){	from 부터 to까지  str에서 문자를 
		 	answer += str.charAt(i);		뽑아서 answer에 저장
		 }
		
		 */
		return answer;
	}

	public static void main(String[] args) {
		// 1) 두 정수의 덧셈을 반환하는 함수를 작성하세요.
		int q1 = add(1, 2);
		System.out.println("q1 : " + q1);

		// 2) 세 정수를 전달받아서 가장 작은 수를 반환하는 함수 getMinNumber를 작성하세요.
		int q2 = getMinNumber(15, 23, 9);
		System.out.println("q2 : " + q2);

		// 3) 문자열 하나를 전달받아서, 첫 글자를 대문자로 변환하는 함수 upperCase를 작성하세요.
		String q3 = upperCase("hello");
		System.out.println("q3 : " + q3);

		// 4) 문자열 하나와 정수 두개를 전달받아서 문자열의 from번째 글자부터 to 글자 이전까지 글자를 잘라낸
		// 새로운 문자열을 반환하는 함수 substring을 작성하세요.
		String q4 = substring("Hello, world!!", 0, 5);
		System.out.println("q4 : " + q4);
 
		String t4 = substring("Hello, world!!", 6, 12);
		System.out.println("q4 :" + t4);
		
	}

}
