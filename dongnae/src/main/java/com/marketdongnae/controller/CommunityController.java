package com.marketdongnae.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.marketdongnae.domain.community.CommunityDTO;
import com.marketdongnae.service.CommunityService;

@Controller
public class CommunityController {
	@Autowired
	CommunityService communityService;

	@GetMapping("/community")
	public String getCommunity(Model model) {
		List<CommunityDTO> list = communityService.getCommunity();
		model.addAttribute("list", list);
		return "community/community";
	}

}
