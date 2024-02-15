package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.Product2DTO;
import com.itbank.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired private ProductService ps;

	@GetMapping("/function")
	public ModelAndView function() {
		ModelAndView mav = new ModelAndView("/product/function");
		
		return mav;
	}
	@GetMapping("/view/{idx}")
	public ModelAndView Product(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView("/product/view");
		Product2DTO  dto = ps.getProduct(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<Product2DTO> list = ps.getProductList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/insert")
	public void insert() {}
		
	@PostMapping("/insert")
	public String insert(Product2DTO dto) {
		
		int row = ps.productInsert(dto);
		System.out.println(row != 0 ? "등록 성공": "등록실패");
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView("/product/modify");  
		Product2DTO dto = ps.getProduct(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	@PostMapping("/modify/{idx}")
	public String modify(Product2DTO dto) {
		
		int row = ps.productModify(dto);
		System.out.println(row != 0 ? "수정 성공":"수정 실패");
		
		return "redirect:/product/list";
	}
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx")int idx) {
		int row = ps.productDelete(idx);
		System.out.println(row != 0 ? "삭제성공" : "삭제실패");
		return "redirect:/product/list";
	}
	
}

