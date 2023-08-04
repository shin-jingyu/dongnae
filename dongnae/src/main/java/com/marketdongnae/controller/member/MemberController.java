package com.marketdongnae.controller.member;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketdongnae.controller.GoodsController;
import com.marketdongnae.domain.member.BuyDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.SoldDTO;
import com.marketdongnae.security.CustomAuthenticationProvider;
import com.marketdongnae.security.CustomUserDetails;
import com.marketdongnae.service.goods.GoodsService;
import com.marketdongnae.service.member.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/member/")
public class MemberController {
	
	private final MemberService memberService;
	private final CustomAuthenticationProvider customAuthenticationProvider;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("detail")
	public ModelAndView detail(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		MemberDTO member =  memberService.getMember(m_id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("isFaile", false);
		mv.addObject("member", member);
		mv.setViewName("/member/detail");
		return mv;		
	}
	
	@PostMapping("update")
	public ModelAndView modify(@RequestParam Map<String, Object> map) {		
		ModelAndView mv = new ModelAndView();
		ObjectMapper objectMapper = new ObjectMapper();
		MemberDTO memberDTO = objectMapper.convertValue(map, MemberDTO.class);
		memberService.updateMember(memberDTO);
		mv.setViewName("/home");
		return mv;		
	}
	
	@GetMapping("changePassword")
	public ModelAndView changePassword(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		mv.addObject("m_id", m_id);
		return mv;	
	}
	
	@PostMapping("changePassword")
	public ModelAndView changePassword_post(@RequestParam Map<String, Object> map
			, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		MemberDTO member =  memberService.getMember(m_id);
		
		// 입력한 현재 비밀번호가 맞는지 확인
		String rawPwd = (String) map.get("current_password"); 
		String encodedPwd = (String) member.getM_pwd();
		if( !passwordEncoder.matches(rawPwd , encodedPwd) ) {
			mv.addObject("password", "wrongCurrent");
			mv.setViewName("/member/changePassword");
			return mv;
		};
		
		// 새 비밀번호와 확인이 일치하는지 확인
		String newPwd = (String) map.get("new_password");
		String confirmPwd = (String) map.get("new_password_confirm");
		if( !newPwd.equals(confirmPwd) ) {
			mv.addObject("password", "WrongConfirm");
			mv.setViewName("/member/changePassword");
			return mv;
		};
		
		// 새 비밀번호로 변경
		String newEncodePwd = passwordEncoder.encode(newPwd);
		map.put("new_password", newEncodePwd);
		memberService.changePassword(map);
		
		mv.setViewName("redirect:/");
		return mv;		
	}
	
	@GetMapping("point")
	public ModelAndView review(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		// 기능구현 전이라 일단 고정 값으로 테스트 중 : b_id
		String b_id = "1";
		MemberDTO member =  memberService.getMember(m_id);
		BuyDTO buy =  memberService.getBuy(b_id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", member);
		mv.addObject("buy", buy);
		mv.setViewName("/member/point");
		return mv;		
	}
	
	@GetMapping("buyList")
	public ModelAndView buyList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		MemberDTO member =  memberService.getMember(m_id);
		int m_number =  member.getM_number();
		List<BuyDTO> buyList =  memberService.getBuyList(m_number);
		ModelAndView mv = new ModelAndView();
		mv.addObject("buyList", buyList);
		mv.setViewName("/member/buyList");
		return mv;		
	}
	
	
	@GetMapping("soldList")
	public ModelAndView soldList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		MemberDTO member =  memberService.getMember(m_id);
		int m_number = member.getM_number();
		List<SoldDTO> soldList =  memberService.getSoldList(m_number);
		ModelAndView mv = new ModelAndView();
		mv.addObject("isFaile", false);
		mv.addObject("soldList", soldList);
		mv.setViewName("/member/soldList");
		return mv;		
	}
	
	@GetMapping("review")
	public ModelAndView getReviewList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		MemberDTO member =  memberService.getMember(m_id);
		int m_number =  member.getM_number();
		List<SoldDTO> soldList =  memberService.getSoldList(m_number);
		int sum = 0 ;
		for (SoldDTO sold : soldList) {
			sum += (int) sold.getS_score();
		}
		int avgScore = (int) Math.ceil(sum/ soldList.size()) ;
		ModelAndView mv = new ModelAndView();
		mv.addObject("soldList", soldList);
		mv.addObject("avgScore", avgScore);
		mv.setViewName("/member/review");
		return mv;		
	}
	
	@GetMapping("login")
	public ModelAndView login() {
		return new ModelAndView("member/login");
	}
	
	@GetMapping("loginFail")
	public ModelAndView loginFail() { 
		// 나중에 ajax로 바꿀 예정 
		ModelAndView mv = new ModelAndView();
		mv.addObject("login", "fail");
		mv.setViewName("/member/login");
		return mv;
	}
	
	// /member/loginSuccess는 CustomLoginSuccessHandler에서 이동함
	
	@GetMapping("logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		session.invalidate();
		mv.setViewName("redirect:/"); // 왜 홈화면이 아니라 로그인창으로 연결되지?
		return mv;
	}
	
	@GetMapping("regist")
	public ModelAndView regist() {
		return new ModelAndView("member/regist");
	}
	
	@PostMapping("regist")
	public ModelAndView regist_post(@RequestParam Map<String, Object> map) {
		System.out.println("가입하기 POST");
		ModelAndView mv = new ModelAndView();
		String pwd1 = (String) map.get("m_pwd");
		String pwd2 = passwordEncoder.encode(pwd1);
		map.put("m_pwd", pwd2);
		ObjectMapper objectMapper = new ObjectMapper();
		MemberDTO memberDTO = objectMapper.convertValue(map, MemberDTO.class);
		memberService.regist(memberDTO);
		System.out.println(map.toString());
		mv.setViewName("/member/login");
		return mv;		
	}
	
	
	
	
}