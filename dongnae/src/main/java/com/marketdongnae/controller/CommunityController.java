package com.marketdongnae.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.CommunityDetailDTO;
import com.marketdongnae.service.CommunityService;

@Controller
public class CommunityController {
	@Autowired
	CommunityService communityService;

	@GetMapping("/community")
	public String getCommunity(Model model) {
		List<CommunityAllDTO> list = communityService.communityAll();
		model.addAttribute("list", list);
		return "community/community";
	}
	
	@GetMapping("/communityDetail")
	public ModelAndView view(@RequestParam String mu_id){
		communityService.updateCount(mu_id);
		CommunityAllDTO detailDTO = communityService.communityDetail(mu_id);
		
		return new ModelAndView("community/communityDetail","community",detailDTO);
	}
	
}
