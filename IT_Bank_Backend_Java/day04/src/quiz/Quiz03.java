package quiz;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {
		//서로 다른 세 정수를 입력받은 다음 가장 큰 수를 하나 출력하세요.
		
		int num1,num2,num3;
		int max;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("첫번째  정수를 입력하여주세요: ");
		num1 = sc.nextInt();
		
		System.out.printf("두번째  정수를 입력하여주세요: ");
		num2 = sc.nextInt();
		
		System.out.printf("세번째  정수를 입력하여주세요: ");
		num3 = sc.nextInt();
		
		if(num1 > num2 && num2 > num3) {
			max = num1;
		}else if(num1 < num2 && num2 > num3) {
			max = num2;
		}else {
			max = num3;
		}
		
		
		// 최적화
//		max = num1; //값이 없으니 일단 첫번째 수를 대입해둔다.
		
//		if(num2 > max) {
//			max = num2;
//		}if(num3 > max) {
//			max = num3;
//		}
		
		System.out.println("가장 큰 수:  " + max);
		
		sc.close();
	}
	

}
