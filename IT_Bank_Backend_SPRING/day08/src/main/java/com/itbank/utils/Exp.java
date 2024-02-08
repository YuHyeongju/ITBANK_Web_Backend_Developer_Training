package com.itbank.utils;

// enum 타입으 싱글톤 처럼, 기본생성자로 객체를 생성하지않고,
// 클래스의 정적메서드를 이용하여 생성한다.

interface IntOperator{	// 함수형 인터페이스 -> 람다식으로 함수를 구현하면서 객체 생성
	int calc(int x, int y);	// 함수를 전달하기위해 함수형 인터페이스가 준비되어있음.
	
}

public enum Exp {
	
	// private static final PLUS = "+";
	PLUS("+", (x,y) -> x + y),  // PLUS라는 이름으로 기호와 함수 전달, 규칙을 만듦
	MINUES("-",(x,y) -> x - y),
	MULTI("*",(x,y) -> x * y),
	DEVIDE("/",(x,y) -> x / y);
	
	private final String operator;
	private final IntOperator lambda;
	
	
	private Exp(String operator, IntOperator lambda) {
		this.operator = operator;
		this.lambda = lambda;
	}
	public String getOperator() { // 연산자가 무엇인가
		return operator;
	}
	public int getAnswer(int x, int y) { // 정답이 무엇인가
		return lambda.calc(x, y);
	}
}
