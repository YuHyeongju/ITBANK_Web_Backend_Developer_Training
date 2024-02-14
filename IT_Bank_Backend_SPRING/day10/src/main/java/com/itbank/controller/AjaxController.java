package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@RestController // 문서 내용을 응답하지 않고, 순수 데이터를 응답하기위한 AJAX 전용 컨트롤러
				// 모든 함수에 자동으로 @ResponseBody가 적용된다.(포워드 및 리다이렉트가 기본값이 아니다.)
public class AjaxController {
		@Autowired private MemberService ms;
	
		// AJAX 요청에 대응하는 컨트롤러 함수는 기본자료형, 배열, 리스트, 맵, DTO 등 여러 타입 반환 가능
		// 반환 값이 viewName이 아니라 그 자체임을 명시해야함 -> @ResponseBody를 작성해줘야함.
		@GetMapping("/ex01Ajax") // 다른 자원으로 이동하는 것이 아니라 return 값이 바로 보여지는 형태 
		@ResponseBody
		public int ex01Ajax(int n1, int n2) {
			return n1 + n2;
		}
		
		
		
		@PostMapping("/ex03Ajax")
		@ResponseBody
		public HashMap<String, Object> ex03Ajax(@RequestBody HashMap<String, Object> param){ //POST를 사용하면서 값을 하나만 
			HashMap<String, Object> map = new HashMap<String, Object>();					// 전달하는 경우는 잘 없어서 HashMap으로 받아서 처리함.  
			int count = ms.checkDuplicate(param);
			map.put("count", count);
			map.put("msg", count != 0 ? "이미 사용중인 아이디입니다.":"사용 가능합니다.");
			// String result = objectMapper.writeValueAsString(map);
			// 원래 자바 객체를 JSON 규칙에 맞춰 문자열로 변환한 다음 반환해야 하지만, ObjectMapper가 자동으로 변환을 처리한다.
			
			return map;
		}
		@GetMapping("/ex04Ajax")
		public List<MemberDTO> ex04Ajax(){
			return ms.getMemberList();
		}
	
}
