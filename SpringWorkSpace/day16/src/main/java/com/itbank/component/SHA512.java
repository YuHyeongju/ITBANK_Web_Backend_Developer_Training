package com.itbank.component;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class SHA512 {
	
	public String getHsah(String userpw) 
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		// - MessageDigest 싱글톤으로 관리되는 객체
		
		md.reset();		// 이전에 남은 해시 정보를 초기화
		md.update(userpw.getBytes("UTF-8"));
		
		String hashpw = String.format("%0128x", new BigInteger(1, md.digest())); //128글자의 랜덤해쉬값 생성
		
		return hashpw;
	}
}
