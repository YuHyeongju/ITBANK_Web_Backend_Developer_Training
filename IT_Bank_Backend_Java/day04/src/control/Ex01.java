package control;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		// 제어문 
		// control statement
		// 코드의 흐름 및 상태를 제어하는 구문
		// 1) 분기문: 조건에 따라 서로 다른 코드를 실행한다. (if, switch~case)
		// 2) 반복문: 조건에 따라 특정 코드를 반복 수행한다. (while, for)
		// 3) 기타 : 반복 흐름을 강제로 끊거나, 함수 진행을 강제로 종료한다. (break, continue, return)
		
		// 분기문과 반복문은 특정 조건에 의해서 수행되므로 비교연산, 논리연산 등을 활용하여 boolean타입의 값을 
		// 다루는 연습이 필요함.
		
		
		//> , < , >= , <= , == ,!=		일반적으로 수치에 대한 비교를 수행하여 boolean을 만들어낸다.
		//&&, || , ! 					boolean을 이용하여 새로운 boolean을 만들어냄
		
		//사용자의 "입력값"이 무엇이냐에 따라, 어떤 크기의 값이냐에 따라
		//조건을 생성하고, 조건에 따라 서로 다른 코드를 수행.
		//분기문 뿐만 아니라, 반복문도 boolean 타입을 사용하기 때문에
		//한글로 번역했을 때 , "만약에" 라는 형식의 구문이 등장하는 경우가 많다.
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		System.out.printf("정수 입력: ");
		num = sc.nextInt();
		
		boolean isOdd = num % 2 != 0; //입력값이 짝수가 아니면 
		
		if(isOdd) {					 //1 증가 (짝수로 만듦)
			num++;
		}
		while(true) {				//무한반복
			num /= 2;
			
			if(num < 10) {			//num 값이 10보다 작으면 while의
					
				break;				//조건과 상관없이 반복문을 중단하고 빠져나간다.
			}
		}
		
		System.out.println("num : " + num);
		
		sc.close();
		
		
		
		
		
		
	}
}
