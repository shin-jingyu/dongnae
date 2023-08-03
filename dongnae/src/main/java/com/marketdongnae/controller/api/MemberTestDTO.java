package com.marketdongnae.controller.api;

import org.springframework.stereotype.Repository;

@Repository
public class MemberTestDTO {
	private String name;
	private int age;
	
	@Override
	public String toString() {
		return "MemberTestDTO [name=" + name + ", age=" + age + "]";
	}
	public MemberTestDTO() {
		super();
	}
	public MemberTestDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
