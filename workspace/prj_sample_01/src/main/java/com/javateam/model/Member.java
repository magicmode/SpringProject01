package com.javateam.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Member {
	
	@Id
	@Pattern(regexp="\\d{4,6}", message="아이디는 4~6자의 숫자입니다.")
	private String id;
	
	@NotNull
	@Size(min=2, max=20, message="이름은 2~20자 입니다.")
	private String name;
	
	@NotNull
	@Size(min=2, max=20, message="이름은 2~20자 입니다.")	
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
