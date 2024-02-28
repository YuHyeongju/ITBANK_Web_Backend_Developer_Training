package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.ScheduleDTO;
import com.itbank.repository.ScheduleDAO;

@RestController
@RequestMapping("/schedules")
@CrossOrigin(origins = { // crossorigin을 사용하더라도 특정 컴퓨터에게만 자원을 가져갈수 있도록 허용할 수 있음.
						 // origin가 없으면 모든 사람이 내 자원을 가져갈 수 있음.
						 // localhost로 접속하면 내 자신의 데이터를 조회할 수 없다.
						// 도메인이 없어서 ip를 쓰는데 도메인을 앞에 쓰면 그 도메인을 사용하여 접속 했을때만 자원을 사용할 수 있게 된다.
						// 따라서 ip로 접근해야 내 것이 뜬다.
		"http://192.168.112.19:8080",
		"http://192.168.112.30:8080",
		"http://192.168.112.21:8080",
		"http://192.168.112.14:8080",
		"http://192.168.112.23:8080"
		
})
public class SchduleController {
	
	@Autowired  ScheduleDAO dao;
	
	@GetMapping
	// 메서드에 @CrossOrigin을 추가하면 이 메서드를 실행 할 때만 crossorigin 적용 받음.
	// ex) 등록하는 내용은 본인만 볼 수 있도록 한다.
	public  List<ScheduleDTO> selectList(){
		return dao.selectList();
	}
	@PostMapping
	public int add(@RequestBody ScheduleDTO dto) {
		// JSON으로 전달되는 데이터를 DTO로 mapping하려면 @RequestBody를 사용한다.
		// 자바 객체에서  반환하면 JSON형식의 문자열로 변환하기 위해서 @ResponseBody를 사용한다.(생략)
		// @RestController 내부의 모든 함수는 @ResponseBody가 기본 적용 된다. 
		int row = 0;
		System.out.println(dto.getsDate());
		System.out.println(dto.getMemo());
		row = dao.insert(dto);
		return row;
	}
	@DeleteMapping("/{idx}")
	public int delete(@PathVariable("idx") int idx) {
		int row  = 0;
		row = dao.delete(idx);
		return row;
	}
}
