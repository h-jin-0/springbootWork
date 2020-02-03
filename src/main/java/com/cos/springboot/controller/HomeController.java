package com.cos.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springboot.dto.RequestMemberDto;
import com.cos.springboot.dto.RequestUserDto;
import com.cos.springboot.dto.ResponceData;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	//﻿http:localhost:8080/home/
	@GetMapping({"","/"})
	public String home() {
		
		return "home";
	}
	
	//﻿http:localhost:8080/home/
	@GetMapping("/hello")
	public String hello_get() {
		//DB select - model에 담고 이동
		return "hello";
	}
	
	@PostMapping("/hello")
	public @ResponseBody ResponceData hello_post(@RequestBody RequestUserDto requestUserDto) {
		//DB insert
		System.out.println(requestUserDto.getId());
		return new ResponceData(200,"ok");
	}
	
	@DeleteMapping("/hello")
	public @ResponseBody ResponceData hello_delete(@RequestBody RequestUserDto requestUserDto) {
		//DB delete
		System.out.println(requestUserDto.getId());
		return new ResponceData(200,"ok");
	}
	
	@PutMapping("/hello")
	public @ResponseBody ResponceData hello_put(@RequestBody RequestMemberDto requestMemberDto) {
		//DB put
		System.out.println(requestMemberDto.getUsername());
		System.out.println(requestMemberDto.getPhone());
		return new ResponceData(200,"ok");
	}
}
