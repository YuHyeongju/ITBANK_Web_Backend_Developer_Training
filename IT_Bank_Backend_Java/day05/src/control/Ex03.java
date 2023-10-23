package control;

public class Ex03 {
	public static void main(String[] args) {
		// swtich 에는 정확한 값의 일치 비교가 가능한 형태로 변수가 와야한다.
		// 따라서 근사치를 처리하는 부동소수점 방식의 실수는 처리 불가

		int num = 5;
		double db = 2.1;
		String str = "A";

		/*
		 * Cannot switch on a value of type double. Only convertible int values, strings
		 * or enum variables are permitted  문자열 비교는 가능
		 */

		switch (str) {
		case "A": // if(str == "A") x
					// if(str.equals("A")) o

			System.out.println("one");
			break;
		case "B":
			System.out.println("two");
			break;

		}
		//switch에 변수 혹은  변수를 포함하는 연산식도 가능하다.
		int num2 = 125;
		
		switch(num2 % 2) {
		case 0 : System.out.println("짝수"); break;
		case 1: System.out.println("홀수");
		}

	}
}
