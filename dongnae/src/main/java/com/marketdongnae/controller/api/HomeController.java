package com.marketdongnae.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketdongnae.service.member.MemberService;

@RestController("apiHomeController")
@RequestMapping("/api/")
public class HomeController {
	@Autowired
	private TestService service;

	
	@RequestMapping("test")
	public List<MemberTestDTO> list() {
		List<MemberTestDTO> list = service.getList(1, "field", "query");
		return list;
	}
}
