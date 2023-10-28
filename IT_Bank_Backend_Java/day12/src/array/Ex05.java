package array;

public class Ex05 {

	public static void main(String[] args) {
		int n1 = 10, n2  = 20;
		
		
		System.out.printf("n1: %d, n2: %d\n",n1,n2);
		// 두변수의 값을 교환하여 다시 출력하기
		
		int tmp = n1; // n1의 값을 임시변수에 넣어둔다.
		n1 = n2 ;     // n2의 값을 n1 에게 준다.
		n2 = tmp;	  // n2는 처음에 따로 뺴두었던 임시 변수의 값을 받아옴
		
		System.out.printf("n1 : %d, n2: %d\n", n1, n2);
	}

}
