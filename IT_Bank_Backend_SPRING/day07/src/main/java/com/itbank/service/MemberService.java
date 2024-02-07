package com.itbank.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {
	
	@Autowired private MemberDAO dao;
	@Autowired private HashComponent hashcomponent;

	public List<MemberDTO> getMemberList() {
		List<MemberDTO> list = dao.selectList();
		list.forEach(dto -> dto.setUserpw("********")); // 비밀번호 숨김 처리
		return list;
	}

	public MemberDTO getMember(int idx) {
		
		return dao.selectOne(idx);
	}

	public int add(MemberDTO dto) {
		String hash = hashcomponent.getHash(dto.getUserpw());
		dto.setUserpw(hash);
		return dao.insert(dto);
	}

	public MemberDTO login(MemberDTO dto) {
		// 사용자가 입력한 패스워드로 해시값을 생성한다. 
		String hash = hashcomponent.getHash(dto.getUserpw());
		
		// 만들어진 해쉬값을 이용하여  DB에 저장된 해시값과 비교한다.
		dto.setUserpw(hash);
		return dao.login(dto);
	}

	public int delete(int idx) {
		
		return dao.delete(idx);
	}

	public int modify(MemberDTO dto) {
		// 수정 탭에서 수정한 비밀번호를 해쉬처리하여 DB에 저장
		String hash = hashcomponent.getHash(dto.getUserpw());
		dto.setUserpw(hash);
		int row = dao.update(dto);
		
		return row;
	}

	public String resetPassWord(MemberDTO dto) {
		String newPassWord = UUID.randomUUID().toString().replace("-", "").substring(0,8);
		String hash = hashcomponent.getHash(newPassWord);
		System.out.println("newPassWord : " + newPassWord); 
		System.out.println("hash : " + hash); 
		
		
		dto.setUserpw(hash);
		int row = dao.updatePassWord(dto);
		return row != 0 ? newPassWord : null;
	}
}
