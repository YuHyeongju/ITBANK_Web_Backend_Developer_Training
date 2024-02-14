package com.itbank.controller;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class Ex03Controller {
	//@RequestBody : 요청에 담긴 내용이 파라미터로 그대로 사용된다.
	//@ResponseBody : 반환하는 내용 그 자체가 응답이다.
	
	private ObjectMapper objectMapper = new ObjectMapper(); 
	
//	@Autowired private MemberService ms;
	
	@GetMapping("/ex03")
	public void ex03() {}
	
//	@PostMapping("/ex03Ajax")
//	@ResponseBody
//	public HashMap<String, Object> ex03Ajax(@RequestBody HashMap<String, Object> param){ //POST를 사용하면서 값을 하나만 
//		HashMap<String, Object> map = new HashMap<String, Object>();					// 전달하는 경우는 잘 없어서 HashMap으로 받아서 처리함.  
//		int count = ms.checkDuplicate(param);
//		map.put("count", count);
//		map.put("msg", count != 0 ? "이미 사용중인 아이디입니다.":"사용 가능합니다.");
//		// String result = objectMapper.writeValueAsString(map);
//		// 원래 자바 객체를 JSON 규칙에 맞춰 문자열로 변환한 다음 반환해야 하지만, ObjectMapper가 자동으로 변환을 처리한다.
//		
//		return map;
//	}
}
