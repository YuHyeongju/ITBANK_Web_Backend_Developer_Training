package function;

public class Ex02 {

	static int getBigNumber(int num1, int num2) { //매개변수 <- 인자
		int big = num1 > num2? num1: num2;
		return big;	//반환값
	}
	// 함수의 입력과 출력(stdin, stdout) x
	// 함수의 생산과 소비(produces, consumes)
	
	public static void main(String[] args) {
		//  두 정수 중에서 큰수를 반환하는 함수 만들기.
		int n1 = 3 , n2 = 5;
		int n3 = getBigNumber(n1,n2);
		System.out.printf("%d, %d 중에서 큰 수는 %d입니다.\n", n1,n2,n3);

	}

}
