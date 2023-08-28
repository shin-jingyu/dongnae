package com.marketdongnae.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marketdongnae.domain.member.AllDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.service.member.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/")
public class LoginController {
	private final MemberService memberService;
	
	@GetMapping("login")
	public String login(HttpServletRequest request) {
		String uri = request.getHeader("Referer");
		if(uri != null && uri.contains("/login")) {
			request.getSession().setAttribute("prevPage", uri);
		}
		return "member/login";
	}
	
	@GetMapping("loginFail")
	public String loginFail(Model model) { 
		model.addAttribute("message", "아이디와 비밀번호를 확인해주세요.");
		return "member/login";
	}
	
	@GetMapping("logout")
	public String logout( ) {
		return "redirect:/login";
	}
	
	
	
	@GetMapping("regist")
	public String regist() {
		return "member/regist";
	}
	
	@PostMapping("regist")
	public String regist_post(@ModelAttribute MemberDTO memberDTO) {
		memberService.regist(memberDTO);
		return "redirect:/login";	
	}
	
	@PostMapping("checkId")
	@ResponseBody
	public String checkId(@RequestBody String checkId) {
		String msg =  memberService.checkId(checkId.replace("=", ""));
		return msg ; 
	}
	
	@PostMapping("checkId_post")
	@ResponseBody
	public String checkId_post(@RequestBody String checkId) {
		String msg =  memberService.checkId(checkId.replace("=", ""));
		return msg ; 
	}
	
	@PostMapping("regist/do_area")
	@ResponseBody
	public List<AllDTO> regist_do_area() {
		 List<AllDTO> doList =  memberService.getDoList();
		return doList;		
	}

	@PostMapping("regist/si_area")
	@ResponseBody
	public List<AllDTO> regist_si_area(@RequestBody int do_id) {
		 List<AllDTO> siList =  memberService.getSiList(do_id);
		return siList;		
	}
	

}