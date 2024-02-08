package com.itbank.service;

import org.springframework.stereotype.Service;

import com.itbank.utils.Exp;



/*
 * enum을 사용하는 이유는 다음과 같습니다:
 * 
 * 가독성: enum은 코드를 읽고 이해하기 쉽게 만듭니다. 상수의 의미를 직관적으로 파악할 수 있고, enum을 사용하면 여러 개의 상수를
 * 하나의 그룹으로 묶어서 관리할 수 있습니다. 안정성: enum은 컴파일 시점에서 타입 안정성을 제공합니다. 잘못된 값을 할당하는 실수를
 * 방지하고, IDE의 자동완성 기능을 통해 올바른 값을 선택할 수 있도록 도와줍니다. 제한된 선택지: enum은 특정한 값을 제한된 선택지로
 * 정의할 수 있습니다. 예를 들어, 주간 요일을 표현하는 enum을 사용하면 월요일부터 일요일까지의 선택지가 명확하게 제공되므로, 잘못된
 * 값을 입력하는 경우를 방지할 수 있습니다. 스위치 케이스의 사용: enum은 switch 문과 함께 사용할 때 특히 유용합니다. enum을
 * 사용하면 switch 문의 가독성을 높일 수 있고, 모든 경우에 대한 처리를 보장할 수 있습니다. 추가 기능: enum은 필요에 따라
 * 메서드와 필드를 추가할 수 있습니다. 이를 통해 enum 상수마다 다른 동작을 정의하거나, 상수에 대한 추가 정보를 저장할 수 있습니다.
 * 이러한 이유로 enum은 코드의 가독성과 유지보수성을 높이고, 잠재적인 오류를 사전에 방지할 수 있는 강력한 도구로 사용됩니다.
 */




@Service
public class Ex01Service {

	// 0 으로 나누었을때 문제가 발생하면 직접처리하지않고 컨트롤러(caller)에게 예외를 전가시킨다.
	// 1) 예외 발생 유형과 원인을 파악해야한다.
	// 2) 컨트롤러 하위의 스프링 빈에서는 예외를 전가시켜서 컨트롤러까지 도달시킨다.
	// 예외를 전가시키고 싶지 않으면 try catch로 처리해도 상관없다.
	public int calc(int n1, String operator, int n2) throws ArithmeticException {
		int answer = 0;
		
//		if(operator.equals("+")) {
//			answer = n1 + n2;
//		}
//		if(operator.equals("-")) {
//			answer = n1 - n2;
//		}if(operator.equals("*")) {
//			answer = n1 * n2;
//		}if(operator.equals("/")) {
//			answer = n1 / n2;
//		}
		
//		switch (operator) { // switch는 문자열 비교를 할 수 있음.
//		case "+":
//			answer = n1 + n2;
//			break;
//		case "-":
//			answer = n1 - n2;
//			break;
//		case "*":
//			answer = n1 * n2;
//			break;
//		case "/":
//			answer = n1 / n2;
//			break;
//		}
		
		Exp oper = Exp.valueOf(operator); // PLUS, MINUS, MULTI, DIVIDE
		answer = oper.getAnswer(n1, n2);
		// 변경점
		// enum을 사용함으로써 분기문으로 처리하던 것을 더이상 분기문으로 처리하지 않도록 바꾸었다.
		// EXP에는 특정 값만 들어올 수 있고, 다른 값이 들어오면 작업을 중단하고 예외를 발생시킨다.
		
		System.out.println(Exp.PLUS); // 클래스를 로드하는 시점에 객체가 이미 만들어저 있음. 
		System.out.println(Exp.MINUES);  // 카테고리를 분류할 떄 활용 할 수 있겠다.
		System.out.println(Exp.MULTI);
		System.out.println(Exp.DEVIDE);
		
		
		return answer;
	}

}
