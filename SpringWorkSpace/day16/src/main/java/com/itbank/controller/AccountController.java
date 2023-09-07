package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.AccountVO;
import com.itbank.service.AccountService;



@Controller
@RequestMapping("/account")
public class AccountController { 
 
	@Autowired
	private AccountService as;
	
	@GetMapping("/view")
	public ModelAndView view() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", as.getAccounts());
		
		return mav;
	}
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(AccountVO input, HttpSession session) throws Exception {
		
		
		session.setAttribute("user",as.login(input));
		
		
		
		return "redirect:/account/view";
		//접두어로 redirect:를 주면 리다이렉트 메시지를 전달한다.
		//cpath는 줄 필요없다.
		
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		
		return "redirect:/account/view";
	}
	@GetMapping("/myPage")
	public void myPage() {}
	
	@GetMapping("/signUp")
	public void signUp() {}
	
	@PostMapping("/signUp")
	public ModelAndView signUp(AccountVO input) throws Exception {
		ModelAndView mav = new ModelAndView();
		int row = as.addAccount(input);
		
		mav.addObject("row", row);
		mav.addObject("path", "/account/login");
		mav.addObject("msg", "가입성공");
		mav.setViewName("msg");
		
		return mav;
	}
	@GetMapping("/find")
	public void find() {}
	
	@PostMapping("/find")
	public ModelAndView find(String email) {
		
		ModelAndView mav = new ModelAndView();
		String msg = "ID는 " + as.findId(email);
		
		mav.addObject("row", 1);
		mav.addObject("msg", msg);
		mav.addObject("path", "/account/login");
		mav.setViewName("msg");

		return mav;
	}
	
	@PostMapping("/findPw")
	public ModelAndView findPw(AccountVO input) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		String msg = "임시 PW는 " + as.findPw(input);
		
		mav.addObject("row", 1);
		mav.addObject("path", "/account/login");
		mav.addObject("msg", msg);
		mav.setViewName("msg");
	
		return mav;
	}
	@PostMapping("/update")
	public ModelAndView update(AccountVO input) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		int row = as.updateAccount(input);
		
		mav.addObject("row", row);
		mav.addObject("path", "/account/logout");
		mav.addObject("msg", "수정 성공, 다시 로그인 해주세요.");
		mav.setViewName("msg");
		
		
		return mav;
	}
	@GetMapping("/delete/{userid}")
	public ModelAndView delete (@PathVariable String userid) {
		ModelAndView mav = new ModelAndView();
		int row = as.deleteAccount(userid);
		
		mav.addObject("row", row);
		mav.addObject("path", "/account/logout");
		mav.addObject("msg", "탈퇴완료. 이용해주셔서 감사합니다.");
		mav.setViewName("msg");
		
		
		
		return mav;
	}
	
	
	// @ExceptionHandler
		// - 현재 클래스에서 발생한 예외를 처리하는 어노테이션
		// - 패키지 단위로 예외를 묶어서 처리하라면 @ControllerAdvice로 처리 가능
		@ExceptionHandler(NullPointerException.class)
		public ModelAndView npe(NullPointerException e) {
			
			ModelAndView mav = new ModelAndView();
			
			mav.addObject("row", 0);
			mav.addObject("msg", e.getMessage());
			mav.setViewName("msg");
			
			return mav;
		}
}
