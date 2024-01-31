package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@Controller
@RequestMapping("/member") // 컨트롤러에도 mapping을 사용할 수 있다.
public class MemberController {
	
	@Autowired private MemberService ms;
	
	
	@GetMapping("list") // @RequestMapping 어노테이션을 사용하면 매핑주소와 getMapping주소를 합친다. /member/list 주소가 합쳐짐 
	public ModelAndView memberList() {
		ModelAndView mav = new ModelAndView(); 
		// ModelAndView 에서도 viewName을 비워두면 void와 마찬가지로 작동한다.
		// 요청주소를 구성하는 문자열을 viewName으로 활용한다.
		// "/WEB-INF/views/member/list.jsp"
		
		List<MemberDTO> list = ms.getMemberList();
		mav.addObject("list", list);
		return mav;
	}
	@GetMapping("/{idx}")
	public ModelAndView member(@PathVariable("idx") int idx) { // id를 사용하면 주소창에 사용자의 userid를 노출시키지 않을 수 있다.
		//@PathVAriable을 사용한다면 반드시 viewName을 지정한다.
		// 요청주소가 제각각이므로 JSP이름을 고정시켜야한다.
		ModelAndView mav = new ModelAndView("/member/info");
		MemberDTO dto = ms.getMember(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(MemberDTO dto, String url, HttpSession session) {
		MemberDTO login = ms.login(dto);
		session.setAttribute("login", login);
		if(url == null) {
			url = "/";
		}
		return "redirect:" + url; // 주소를 전달받으면 지정한 페이지로 이동 없으면 대문으로 이동
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = ms.add(dto);
		System.out.println(row !=0 ? "추가 성공":"추가 실패");
		return "redirect:/member/login";
	}
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		int row = ms.delete(idx);
		System.out.println(row != 0? "삭제 성공": "삭제 실패" );
		return "redirect:/member/list";
	}
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable ("idx") int idx) {
		ModelAndView mav = new ModelAndView("/member/modify");
		MemberDTO dto = ms.getMember(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	@PostMapping("/modify/{idx}") 
	public String modify(MemberDTO dto) {// 매개변수에 @PathVariable("idx")를 적지않아도 dto에 있으면 알아서 들어온다.
		// Mapping의 {idx}는 DTO의 필드 이름과 일치하면 자동으로 값이 입력된다.
		System.out.println(dto.getIdx());
		
		int row = ms.modify(dto);
		System.out.println(row != 0? "수정 성공": "수정 실패");
		
		//return "redirect:/member/" + dto.getIdx(); 
		return "redirect:/member/{idx}"; // Mapping의 {idx}는 리다이렉트 경로로 사용 할 수 있다.
	}
	@GetMapping("/resetPassword") //void는 요청주소를 그대로 jsp로 사용한다.
	public void resetPassWord() {}
	
	@PostMapping("/resetPassword")
	public ModelAndView resetPassWord(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("alert");
		String password = ms.resetPassWord(dto);
		mav.addObject("msg", "변경된 비밀번호는 [" + password + "] 입니다." );
		mav.addObject("url", password != null ? "/member/login" : "");
		return mav;
		
	}
	
	
}
