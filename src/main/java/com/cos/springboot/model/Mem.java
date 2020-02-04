package com.cos.springboot.model;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Mem{

	private int id;
	private String username;
	private String password;
	private String email;
	private String profile;
	private Timestamp createDate;
	
	@Builder
	public Mem(String username, String password, String email, String profile, Timestamp createDate) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.profile = profile;
		this.createDate = createDate;
	}

}
