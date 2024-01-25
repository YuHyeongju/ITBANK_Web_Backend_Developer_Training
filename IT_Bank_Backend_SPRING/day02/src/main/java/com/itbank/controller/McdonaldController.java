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

import com.itbank.mcdonald.McdonaldDTO;
import com.itbank.service.McdonaldService;

@Controller
public class McdonaldController {
	
	@Autowired  McdonaldService ms;
	
//	@GetMapping("/")
//	public ModelAndView mcdonaldList() {
//		ModelAndView mav = new ModelAndView("mcdonald-list");
//		List<McdonaldDTO> list = ms.getMcdonaldList();
//		mav.addObject("list", list);
//		return mav;
//	}
//	@GetMapping("/{category}")
//	public ModelAndView mcdonaldList(@PathVariable("category")String category) {
//		ModelAndView mav = new ModelAndView("mcdonald-list");
//		List<McdonaldDTO> list = ms.getMcdonaldList(category);
//		mav.addObject("list", list);
//		return mav;
//	}
	@GetMapping("/mcdonald-list/{category}")
	public ModelAndView mcdonaldList(@PathVariable("category")String category) {
		ModelAndView mav = new ModelAndView("mcdonald-list");
		List<McdonaldDTO> list = ms.getList(category);
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/")
	public ModelAndView mcdonaldSearchList(@RequestParam HashMap<String, String> paramMap) {
		ModelAndView mav  = new ModelAndView("mcdonald-list");
		List<McdonaldDTO> list = ms.getMcdonaldSearchList(paramMap);
		mav.addObject("list", list);
		return mav;
	}

	
	@GetMapping("/add")
	public ModelAndView mcdonaldAdd() {
		ModelAndView mav = new ModelAndView("mcdonald-add");
		return mav;
	}
	@PostMapping("/add")
	public ModelAndView mcdonaldadd(McdonaldDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/");
		int row = ms.add(dto);
		System.out.println(row != 0 ? "추가성공":"추가실패");
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView("view");
		McdonaldDTO dto = ms.getMcdonaldView(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public ModelAndView  mcdonaldDelete(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView("redirect:/");
		int row = ms.delete(idx);
		System.out.println(row != 0 ? "삭제성공":"삭제실패");
		return mav;
	}
	
	
	@GetMapping("/modify/{idx}")
	public ModelAndView mcdonaldModify(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView("mcdonald-modify");
		McdonaldDTO dto = ms.getMcdonaldView(idx);
		mav.addObject("dto",dto);
		return mav;
	}
	@PostMapping("/modify/{idx}")
	public ModelAndView mcdonaldmodify(McdonaldDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/view/{idx}");  // 처리할 메소드가 매핑 되어있어야한다.
		int row = ms.modify(dto);
		System.out.println(row != 0 ? "수정성공":"수정실패");
		mav.addObject("dto", dto);
		return mav;
	}
	
	
}
