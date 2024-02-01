package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itbank.model.UploadDTO;
import com.itbank.service.UploadService;

@Controller
@RequestMapping("/ex03")
public class Ex03Controller {
	@Autowired private  UploadService us;
	
	//GET, POST 메서드를 구분하고 싶다면 <View-Controller>태그로 쓸 수 있다.

	@GetMapping
	public ModelAndView ex03() {
		ModelAndView mav = new ModelAndView();
		List<UploadDTO> list = us.getList();
		mav.addObject("list", list);
		return mav;
		
		
	}
	@PostMapping
	public String ex03(UploadDTO dto) {
		int row  = us.upload(dto);
		System.out.println(row != 0 ? "등록 성공" : "등록 실패");
		return "redirect:/ex03";
	}
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable ("idx") int idx, RedirectAttributes rttr) {
		int row = us.delete(idx);
		rttr.addFlashAttribute("msg", row != 0 ? "삭제성공":"삭제실패");
		return "redirect:/ex03";
	}
}