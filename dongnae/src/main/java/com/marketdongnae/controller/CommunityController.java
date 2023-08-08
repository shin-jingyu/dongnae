package com.marketdongnae.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.HeartDTO;
import com.marketdongnae.domain.community.communityDetailDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.service.Community.CommunityService;
import com.marketdongnae.service.member.MemberService;

@Controller
public class CommunityController {
	@Autowired
	CommunityService communityService;
	@Autowired
	MemberService memberService ;
	
	
	
	@GetMapping("/community")
	public ModelAndView getCommunity() {
		ModelAndView view = new ModelAndView();
		List<CommunityAllDTO> list = communityService.communityAll();
		view.addObject("list",list);
		view.setViewName("community/community");
		
		return view;
	}
	
	
	
	@GetMapping("/communityDetail")
	public ModelAndView view(@RequestParam String mu_id,String m_id){
		// view 처리
		ModelAndView view = new ModelAndView();
		//member 정보처리
		MemberDTO memberDTO = memberService.getMember(m_id);
		// 상세정보
		communityService.updateCount(mu_id);
		CommunityAllDTO detailDTO = communityService.communityDetail(mu_id);
		view.addObject("community", detailDTO);
		view.addObject("member", memberDTO);	
		view.setViewName("community/communityDetail");
		return view;
	}
	
	
	
	@GetMapping("/insertCommunity")
	public ModelAndView insertCommunity(@RequestParam String m_id) {
		MemberDTO memberDTO= memberService.getMember(m_id);
		System.out.println(m_id);
		return new ModelAndView("community/insertCommunity","member",memberDTO);
	}
	@PostMapping("/insertCommunity")
	public String insertCommunityPost(@ModelAttribute communityDetailDTO communityDetailDTO ) {
		System.out.println("글등록");
		communityService.insertCommunity(communityDetailDTO);
		return "redirect:community";
	}
	
	
	
	@GetMapping("/updateCommunity")
	public ModelAndView update(@RequestParam String mu_id) {
		CommunityAllDTO detailDTO = communityService.communityDetail(mu_id);
		return new ModelAndView("community/updateCommunity","community",detailDTO);
	}
	@PostMapping("/updateCommunity")
	public String updateCommunityPost(@ModelAttribute communityDetailDTO communityDetailDTO) {
		System.out.println("글 수정하기 ");
		communityService.updateCommunity(communityDetailDTO);
		return "redirect:community";
	}
	
	
	@GetMapping("/deleteCommunity/{mu_id}")
	public String deleteCommunity(@PathVariable("mu_id") int mu_id) {
		System.out.println("글삭제");
		System.out.println("community mu_id= "+mu_id);
		communityService.deleteCommunity(mu_id);
		return "redirect:/community";
	}
	@ResponseBody
	@PostMapping("/heart")
	public String heart(HeartDTO heartDTO) {
		return null;
	}

	
}
