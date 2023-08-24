package com.itbank.service;

import com.itbank.dto.PersonDTO;

public class Ex05Service {
	
	public String isAdult(PersonDTO per) {
		String result ="미성년자";
		if(per.getAge() >=20) {
			result = "성인";
		}
		return result;
	}
	
}
