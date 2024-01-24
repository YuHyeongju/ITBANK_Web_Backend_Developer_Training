package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	
	@GetMapping("/member")
	public ModelAndView memberList() {
		ModelAndView mav = new ModelAndView("member-list");
		List<MemberDTO> list = ms.getMemberList();
		mav.addObject("list",list);
		return mav;
	}
	@PostMapping("/member")
	public ModelAndView memberSearchList(@RequestParam HashMap<String, String> paramMap) {
		// DTO에 정의 되지않은 값(jsp에서 보낸 searchType, searchKeyword)을 여러개 받을때는 HashMap를 사용할 수 있다.
		// 단 다른 DTO나 String, primitive type과 달리, 어노테이션 RequestParam을 명시해야한다.
		
		ModelAndView mav = new ModelAndView("member-list");
		List<MemberDTO> list = ms.getMemberSearchList(paramMap);
		mav.addObject("list",list);
		return mav;
	}
	
	@GetMapping("/member/add")
	public ModelAndView memberAdd() {
		ModelAndView mav = new ModelAndView("member-add");
		return mav;
	}
	@PostMapping("/member/add")
	public ModelAndView memberAdd(MemberDTO dto)
	{
		// form의 input name과 dto의 필드 이름이 일치하면 자동으로 파라미터가 입력된다.
		ModelAndView mav = new ModelAndView("redirect:/member");
		int row = ms.add(dto);
		System.out.println(row != 0 ? "추가성공":"추가실패");
		return mav;
	}
	
	@GetMapping("/member/delete/{idx}")
	public ModelAndView delete(@PathVariable("idx")int idx) {
		// PathVariable (경로변수) : 요청주소상의 특정 경로의 값을 정수 및 문자열 형태로 전달받아서 
		// 파라미터와 유사하게 사용할 수 있다.(쿼리스트링 형식을 쓰지않아도 된다.)
		ModelAndView mav = new ModelAndView("alert");
		int row = ms.delete(idx);
		
		String msg = row != 0? "삭제성공" : "삭제실패";
		String url = "/member";
		
		mav.addObject("msg", msg );
		mav.addObject("url",url);
		return mav;
	}
	
	@GetMapping("/member/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("member-modify");
		MemberDTO dto = ms.selectOne(idx);
		
		mav.addObject("dto",dto);
		return mav;
	}
	
	@PostMapping("/member/modify/{idx}")
	public ModelAndView modify(MemberDTO dto) {
		ModelAndView mav = new  ModelAndView("alert");
		int row = ms.update(dto);
		
		String msg = row != 0? "수정성공" : "수정실패";
		String url = "/member";
		
		mav.addObject("msg", msg );
		mav.addObject("url",url);
		
		return mav;
	}
	
}
