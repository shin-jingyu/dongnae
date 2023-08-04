package com.marketdongnae.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.communityDetailDTO;
import com.marketdongnae.service.Community.CommunityService;

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
	
	@GetMapping("/insertCommunity")
	public String insertCommunity() {
		return "community/insertCommunity";
	}
	
	@PostMapping("/insertCommunity")
	public String insertCommunityPost(@ModelAttribute communityDetailDTO communityDetailDTO) {
		System.out.println("글등록");
		communityService.insertCommunity(communityDetailDTO);
		return "redirect:community";
	}
	
	@GetMapping("/updateCommunity")
	public ModelAndView update(@RequestParam String mu_id) {
		CommunityAllDTO detailDTO = communityService.communityDetail(mu_id);
		return new ModelAndView("community/updateCommunity","update",detailDTO);
	}
	
}
