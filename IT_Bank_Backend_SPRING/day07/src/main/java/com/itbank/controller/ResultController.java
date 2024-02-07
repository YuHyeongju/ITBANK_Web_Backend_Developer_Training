package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.itbank.model.SurveyDTO;
import com.itbank.service.ResultService;

@Controller
@RequestMapping("/result")
public class ResultController {
	@Autowired private ResultService rs;
	
	@GetMapping("/list")
	public ModelAndView resultList() {
		ModelAndView mav = new ModelAndView();
		List<SurveyDTO> list = rs.getResultList();
		mav.addObject("list", list);
		
		return mav;
	}
	
}
