package com.itbank.service;

import org.springframework.stereotype.Service;


import com.itbank.dto.PersonDTO;

@Service  //비지니스 로직을 처리할 스프링 빈
public class Ex04Service {

	public String isAdult(PersonDTO per) {
		String result = "미성년자";
		if (per.getAge() >= 20) {
			result ="성인";
		}
		return result;
	}

}
