package operater;

public class Ex06 {

	public static void main(String[] args) {
		//비트 연산
		int n1 = 4;
		int n2 = 5;
		
		int a1 = n1 & n2; //비트 & 연산은 이진수 일 때 각 자리가 모두 1이면 1, 아니면 0
		int a2 = n1 | n2; //비트 | 연산은 이진수 일 때 각 자리 중 하나라도 1이 있으면 1, 아니면 0  
		int a3 = n1 << 1; //비트 시프트 연산 << 은 이진수 모양에서 각 자릿수를 왼쪽으로 옮기기
		int a4 = n1 >> 1; //비트 시프트 연산 >> 은 이진수 모양에서 각 자릿수를 오른쪽으로 옮기기
		int a5 = n1 << 2; //왼쪽으로 2번 시프트
		
		
		System.out.println("n1: " + Integer.toBinaryString(n1));
		System.out.println("n2: " + Integer.toBinaryString(n2));
		System.out.println(a1);
		//toBinaryString: 십진수를 넣으면 이진수로 변환하여 출력
		
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(a5);
	}

}
