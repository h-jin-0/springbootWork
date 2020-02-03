package com.cos.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springboot.dto.RequestMemJoinDto;
import com.cos.springboot.dto.RequestMemUpdateDto;
import com.cos.springboot.dto.RequestMemberDto;
import com.cos.springboot.dto.RequestUserDto;
import com.cos.springboot.model.Mem;
import com.cos.springboot.repository.MemRepository;

@Controller
public class MemController {

	@Autowired
	private MemRepository memRepository;

	
	@GetMapping("/mem/api/join")
	public String memJoin() {
		
		return "/mem/join";
	}
	// username,password,email
	@PostMapping("/mem/api/join")
	public @ResponseBody ResponseEntity<String> memApiJoin(@RequestBody RequestMemJoinDto requestMemJoinDto) {

		int result = memRepository.save(requestMemJoinDto);

		if (result == 1) {
			
			return new ResponseEntity<String>("ok", HttpStatus.CREATED);
			// 성공시에 insert일땐 201(created)사용하고 나머지는 200사용(ok)
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/mem")
	public String mems(Model model) {
		List<Mem> mems = memRepository.findAll();

		model.addAttribute("mems", mems);

		return "mem/list";
	}

	@GetMapping("/mem/{id}")
	public String update(@PathVariable int id, Model model) {
		Mem mem = memRepository.findById(id);

		model.addAttribute("mem", mem);

		return "mem/update";
	}

	@PutMapping("/mem/api/update")
	public @ResponseBody ResponseEntity<?> updateProc(@RequestBody RequestMemUpdateDto requestMemUpdateDto) {
		// <?> 물음표 해두고 밑에서 원하는 타입 적고 데이터 넣으면 된다.

		int result = memRepository.update(requestMemUpdateDto);

		if (result == 1) {

			return new ResponseEntity<String>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}

	}
	@DeleteMapping("/mem/api/delete")
	public @ResponseBody ResponseEntity<?> deleteProc(@RequestBody RequestUserDto requestUserDto) {

		int result = memRepository.delete(requestUserDto.getId());

		if (result == 1) { 

			return new ResponseEntity<String>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}

	}
	

}
