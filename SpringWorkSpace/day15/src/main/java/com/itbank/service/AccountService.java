package com.itbank.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.SHA512;
import com.itbank.model.AccountDAO;
import com.itbank.model.AccountVO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO dao;
	
	@Autowired
	private SHA512 hash;

	public List<AccountVO> getAccounts() {
		return dao.selectAll();
	}

	public AccountVO login(AccountVO input) throws Exception {
		String userpw = input.getUserpw();
		userpw = hash.getHsah(userpw);
		input.setUserpw(userpw);
		
		input = dao.selectOne(input);
		
		if (input == null) {	// 로그인 실패
			String msg = "일치하는 계정이 존재하지 않습니다";
			throw new NullPointerException(msg);
		}
		
		return input; 
	}

	
	public int addAccount(AccountVO input) throws Exception {
		// 해시 처리 후
		String userpw = input.getUserpw();
		userpw = hash.getHsah(userpw); 
		
		// 해시 처리된 userpw를 VO에 저장 
		input.setUserpw(userpw);
		
		return dao.insert(input);
	}

	
	public String findId(String email) {
		
		String userid = dao.selectId(email);
		
		if (userid == null) {
			String msg = "일치하는 정보가 존재하지 않습니다";
			throw new NullPointerException(msg);
		}
		
		return userid;
	}

	
	public String findPw(AccountVO input) throws Exception {
		
		String newPw = UUID.randomUUID().toString();
		newPw = newPw.substring(0, 6);
		
		input.setUserpw(hash.getHsah(newPw));
		int row = dao.updatePw(input);
		
		if (row == 0) {
			String msg = "일치하는 정보가 존재하지 않습니다";
			throw new NullPointerException(msg);
		}
		
		return newPw;
	}

}