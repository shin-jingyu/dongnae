package com.marketdongnae.controller;



import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.Property;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;


import com.marketdongnae.domain.community.CommentDTO;
import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.HeartDTO;
import com.marketdongnae.domain.community.PageDTO;
import com.marketdongnae.domain.community.communityDetailDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.security.CustomUserDetails;
import com.marketdongnae.service.Community.CommunityService;
import com.marketdongnae.service.member.MemberService;

@Controller
public class CommunityController {
	@Autowired
	CommunityService communityService;
	@Autowired
	MemberService memberService ;
	
	 
	
	@GetMapping("/community")
	public ModelAndView getCommunity(@RequestParam(value = "num", defaultValue = "1") int num) {
		ModelAndView view = new ModelAndView();
		PageDTO page =new PageDTO();
		
		page.setNum(num);
		page.setCount(communityService.counts());
		
		List<CommunityAllDTO> list = null;
	
		list = communityService.listPage(page.getDisplayPost(), page.getPostNum());
		
		view.addObject("list",list);
		view.addObject("page", page);
		view.addObject("select", num);
		view.setViewName("community/community");
		
		return view;
	}
	
	@ResponseBody
	@GetMapping("/communitySearch")
	public ModelAndView communitySearch(@RequestParam(value = "num", defaultValue = "1") int num,
										@RequestParam(value = "keyword") String keyword,
										@RequestParam(value = "searchType") String searchType) {
		ModelAndView view = new ModelAndView();
		PageDTO page =new PageDTO();
		
		page.setNum(num);
		page.setCount(communityService.listPageSearchCount(searchType, keyword));
		
		page.setSearchType(searchType);
		page.setKeyword(keyword);
		List<CommunityAllDTO> list = null;
		list = communityService.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
		
		view.addObject("list",list);
		view.addObject("page", page);
		view.addObject("select", num);
		view.setViewName("community/communitySearch");
		
		return view;
	}
	
	
	@GetMapping("/communityDetail")
	public ModelAndView communityDetail(@RequestParam("mu_id") String mu_id ,
										@RequestParam("m_number") String m_number,
										@RequestParam(value = "num", defaultValue = "1") int num){
		ModelAndView view = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mu_id", mu_id);
		map.put("m_number", m_number);	
		
		CommunityAllDTO communityDetail = communityService.communityDetail(mu_id);
		communityService.updateCount(mu_id);
		
		HeartDTO heartview = communityService.heartview(m_number, mu_id); 
		 
		PageDTO page =new PageDTO();
		page.setNum(num);
		
		List<CommentDTO> lists  = communityService.selectComment(Integer.parseInt(mu_id));
		view.addObject("page", page);
		view.addObject("comment",lists);
		view.addObject("communityDetail", communityDetail);
		view.addObject("heartview", heartview); 
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
		return "redirect:/community";
	}
	
	
	
	@GetMapping("/updateCommunity")
	public ModelAndView update(@RequestParam String mu_id,
							   @RequestParam(value = "num", defaultValue = "1") int num) {
		ModelAndView view = new ModelAndView();
		CommunityAllDTO detailDTO = communityService.communityDetail(mu_id);
		
		PageDTO page =new PageDTO();
		page.setNum(num);
		view.addObject("page", page);
		
		view.addObject("community",detailDTO);
		view.setViewName("community/updateCommunity");
		return view;
	}
	@PostMapping("/updateCommunity")
	public String updateCommunityPost(@ModelAttribute communityDetailDTO communityDetailDTO,
			 						  @RequestParam(value = "num", defaultValue = "1") int num) {
		System.out.println("글 수정하기 ");
		communityService.updateCommunity(communityDetailDTO);
		return "redirect:/communityDetail?mu_id="+communityDetailDTO.getMu_id()+
									   "&&m_number="+communityDetailDTO.getM_number()+	
									   "&&num="+num;
	}
	
	@ResponseBody
	@GetMapping("/deleteCommunity")
	public String deleteCommunity(@RequestParam("mu_id") int mu_id) {
		System.out.println("글삭제");
		System.out.println("community mu_id= "+mu_id);
		communityService.deleteCommunity(mu_id);
		return "success";
	}
	
	
	
	
	 @PostMapping("/heart") 
	 public  @ResponseBody  int heart(@ModelAttribute HeartDTO heart) { 
		  
		  int result = communityService.insertHeart(heart);
		  System.out.println(result);
		 return result;
	 }
	
	 @PostMapping("/comment")
	 public String comment(@ModelAttribute CommentDTO commentDTO) {
		 communityService.insertComment(commentDTO);
		 int m_ids = commentDTO.getMu_id();
		 String mu_id = String.valueOf(m_ids);

		 return "redirect:/communityDetail?mu_id="+mu_id+"&&m_number="+commentDTO.getM_number();
	 }
	 @ResponseBody
	 @PostMapping("/updateComment")
	 public String updateComment (@ModelAttribute CommentDTO CommentDTO ) {
		 // String data= null;
		 communityService.updateComment(CommentDTO);
		 return "success";
	 }
	 
	 @ResponseBody
	 @PostMapping("/deleteComment")
	 public String deleteComment (@ModelAttribute CommentDTO commentDTO) {
		communityService.deleteComment(commentDTO);
		 return "success";
	 }
	 
	
}
