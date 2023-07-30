package com.marketdongnae.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marketdongnae.security.CustomAuthenticationProvider;
import com.marketdongnae.security.CustomUserDetails;
import com.marketdongnae.service.MemberService;
import com.marketdongnae.service.TestService;


@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	@Autowired 
	CustomAuthenticationProvider customAuthenticationProvider;
	@Autowired
	BCryptPasswordEncoder passwordEncoder ; 
	
	@GetMapping("/member/detail")
	public ModelAndView detail() {
		// 로그인 기능구현 전이라 일단 고정아이디 값으로 테스트 중 : test1
		// String m_id = (String) map.get("m_id");
		String m_id = "test1";
		Map<String, Object> member =  memberService.getMember(m_id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("isFaile", false);
		mv.addObject("member", member);
		mv.setViewName("/member/detail");
		return mv;		
	}
	
	@PostMapping("/member/update")
	public ModelAndView modify(@RequestParam Map<String, Object> map) {		
		ModelAndView mv = new ModelAndView();
		memberService.updateMember(map);
		mv.setViewName("/home");
		return mv;		
	}
	
	@GetMapping("/member/point")
	public ModelAndView review() {
		// 기능구현 전이라 일단 고정 값으로 테스트 중 : testId2, 1
		String m_id = "test1";
		String b_id = "1";
		Map<String, Object> member =  memberService.getMember(m_id);
		Map<String, Object> buy =  memberService.getBuy(b_id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", member);
		mv.addObject("buy", buy);
		mv.setViewName("/member/point");
		return mv;		
	}
	
	@GetMapping("/member/buyList")
	public ModelAndView buyList() {
		int m_number = 1;
		List<Map<String, Object>> buyList =  memberService.getBuyList(m_number);
		ModelAndView mv = new ModelAndView();
		mv.addObject("buyList", buyList);
		mv.setViewName("/member/buyList");
		return mv;		
	}
	
	
	@GetMapping("/member/soldList")
	public ModelAndView soldList() {
		int m_number = 1;
		List<Map<String, Object>> soldList =  memberService.getSoldList(m_number);
		ModelAndView mv = new ModelAndView();
		mv.addObject("isFaile", false);
		mv.addObject("soldList", soldList);
		mv.setViewName("/member/soldList");
		return mv;		
	}
	
	@GetMapping("/member/review")
	public ModelAndView getReviewList() {
		int m_number = 1;
		
		List<Map<String, Object>> soldList =  memberService.getSoldList(m_number);
		int sum = 0 ;
		for (Map<String, Object> sold : soldList) {
			sum += (int) sold.get("s_score");
		}
		int avgScore = (int) Math.ceil(sum/ soldList.size()) ;
		ModelAndView mv = new ModelAndView();
		mv.addObject("soldList", soldList);
		mv.addObject("avgScore", avgScore);
		mv.setViewName("/member/review");
		return mv;		
	}
	
	@GetMapping("/member/login")
	public ModelAndView login() {
		return new ModelAndView("member/login");
	}
	
	@GetMapping("/member/loginFail")
	public ModelAndView login_fail(HttpServletRequest request) { 
		// 나중에 ajax로 바꿀 예정 
		ModelAndView mv = new ModelAndView();
		mv.addObject("login", "fail");
		mv.setViewName("/member/login");
		return mv;
	}
	
	
	@GetMapping("/member/regist")
	public ModelAndView regist() {
		return new ModelAndView("member/regist");
	}
	
	@PostMapping("/member/regist")
	public ModelAndView regist_post(@RequestParam Map<String, Object> map) {
		System.out.println("가입하기 POST");
		ModelAndView mv = new ModelAndView();
		String pwd1 = (String) map.get("m_pwd");
		String pwd2 = passwordEncoder.encode(pwd1);
		map.put("m_pwd", pwd2);
		memberService.regist(map);
		System.out.println(map.toString());
		mv.setViewName("/member/login");
		return mv;		
	}
	
	
	
	
}