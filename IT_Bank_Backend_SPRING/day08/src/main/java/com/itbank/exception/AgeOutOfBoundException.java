package com.itbank.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class AgeOutOfBoundException extends Exception{

	private static final long serialVersionUID = 1L;

	
	
	@Override
	public String getMessage() {
		return "나이의 값이 범위를 초과합니다.(0 ~ 100)";
	}

	
}
