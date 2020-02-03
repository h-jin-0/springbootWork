package com.cos.springboot.model;

import java.sql.Timestamp;

import lombok.Getter;

@Getter
public class Mem{

	private int id;
	private String username;
	private String password;
	private String email;
	private Timestamp createDate;
	
}
