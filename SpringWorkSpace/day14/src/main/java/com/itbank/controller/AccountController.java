package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String login(AccountVO input, HttpSession session) {
		
		
		session.setAttribute("user",as.login(input));
		
		
		
		return "redirect:/account/view";
		//접두어로 redirect:를 주면 리다이렉트 메시지를 전달한다.
		//cpath는 줄 필요없다.
		
	}
}
