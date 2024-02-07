package com.itbank.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ResultDTO;
import com.itbank.model.SurveyDTO;
import com.itbank.service.SurveyService;

@Controller
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	private SurveyService ss;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<SurveyDTO> list  = ss.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	public ModelAndView dupkey() {
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("url", "/survey/list");
		mav.addObject("msg", "이미 참여한 설문입니다.");
		
		return mav;
	}
	

	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public ModelAndView write(SurveyDTO dto) {
		ModelAndView mav = new ModelAndView("alert");
		System.out.println(dto.getWriter());
		int row = ss.insert(dto);
		String url = "/survey/list";
		String msg = row != 0 ? "작성 성공": " 작성 실패";
		mav.addObject("url", url);
		mav.addObject("msg", msg);
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/survey/view");
		SurveyDTO dto = ss.getSurvey(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	@PostMapping("/view/{idx}")
	public ModelAndView view(ResultDTO dto) {
		ModelAndView mav = new ModelAndView("alert");
		int row = ss.surveyInsert(dto);
		String msg = row != 0? "참여 성공": "참여 실패";
		String url="/survey/list";
		mav.addObject("url", url);
		mav.addObject("msg", msg);
		
		return mav;
	}
}
