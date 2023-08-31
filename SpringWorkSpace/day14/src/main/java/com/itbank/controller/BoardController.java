package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardVO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	@GetMapping(value = {"/view/{page}","/view"})
	public ModelAndView view(@PathVariable(required = false) Integer page,
							String type, String search) {
		// @PathVariable에 꼭 값이 전달되지 않아도 되면 (required = false)를 주면된다
		if(page == null) {
			page = 1;
		}
		
		
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("map" , bs.getBoards(page,type,search));
		mav.setViewName("board/view");
		return mav;
	}
	@GetMapping("/viewOne/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", bs.getBoard(idx));
		mav.setViewName("board/viewOne");
		
		return mav;
	}
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public ModelAndView write(BoardVO input) {//BoardVO에 제목 작성자 내용 다들어있어서 매개변수로 사용
		
		ModelAndView mav = new ModelAndView();
		int row = bs.addBoard(input);
		
		String msg = "추가";
		msg+= (row == 0)? "실패" : "성공";
		
		mav.addObject("row",row); //mav에 row 추가 
		mav.addObject("msg",msg); //mav에 msg 추가
		mav.addObject("path","/board/view");
		mav.setViewName("msg"); //뷰를 msg로 설정
		
		return mav;
	}
	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		int row = bs.delBoard(idx);
		
		String msg = "삭제";
		msg += (row == 0)? "실패":"성공";
		
		mav.addObject("row",row);
		mav.addObject("msg", msg);
		mav.addObject("path","/board/view");
		mav.setViewName("msg");
		
		return mav;
	}
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", bs.getBoard(idx));
		mav.setViewName("board/write");
		
		return mav;
	}
	@PostMapping("/update/{idx}")
	public ModelAndView update(BoardVO input) {
		ModelAndView mav = new ModelAndView();
		int row = bs.updateBoard(input);
		
		String msg = "수정";
		msg += (row == 0)? "실패" : "성공";
		
		mav.addObject("row", row);
		mav.addObject("msg", msg);
		mav.addObject("path", "/board/view");
		mav.setViewName("msg");
		
				
		return mav;
	}
}
