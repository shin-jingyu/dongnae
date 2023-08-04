package com.marketdongnae.controller.member;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class TestItem {
	private String name ;
    private String price ;
	public TestItem(String name, String price) {
		this.name = name == null ? "dee" : name ;
		this.price = price== null ? "dee" : price ;
	}
    
    
    
}
