package com.marketdongnae.controller.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketdongnae.controller.goods.GoodsController;
import com.marketdongnae.domain.member.Deal_viewDTO;
import com.marketdongnae.domain.member.Do_areaDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.domain.member.Wish_viewDTO;
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
	
	private final String getSessionM_Id(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		return m_id;
	}
	
	@GetMapping("detail")
	public String detail(Model model, HttpServletRequest request) {
		String m_id =  getSessionM_Id(request);
		model.addAttribute("member",  memberService.getMember(m_id));
		return "member/detail" ;		
	}
	
	@PostMapping("update")
	public String modify(@ModelAttribute MemberDTO memberDTO) {		
		memberService.updateMember(memberDTO);
		return "redirect:/"	;
	}
	
	@GetMapping("changePassword")
	public String changePassword(@ModelAttribute ("password") PasswordDTO passwordDTO, HttpServletRequest request) {
		String m_id =  getSessionM_Id(request);
		passwordDTO.setM_id(m_id);
		return "member/changePassword" ;
	}
	
	
	@PostMapping("changePassword")
	public String changePassword_post(@ModelAttribute ("password") PasswordDTO passwordDTO , HttpServletRequest request) {
		String m_id =  getSessionM_Id(request);
		String result = memberService.changePassword(m_id, passwordDTO);
		if ( result == "fail") 
			return "member/changePassword";
		else 
			return "redirect:/";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("loginFail")
	public String loginFail(Model model) { 
		model.addAttribute("login", "fail");
		return "member/login";
	}
	// ("member/loginSuccess")는 CustomLoginSuccessHandler에서 이동함
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("regist")
	public String regist() {
		return"member/regist";
	}
	
	@PostMapping("regist")
	public String regist_post(@ModelAttribute("member") MemberDTO memberDTO) {
		memberService.regist(memberDTO);
		return "member/login";		
	}
	
	@PostMapping("regist/do_area")
	@ResponseBody
	public List<Do_areaDTO> regist_do_area_post() {
		 List<Do_areaDTO> doList =  memberService.getDoList();
		return doList;		
	}

	@GetMapping("soldList")
	public String soldList(Model model,HttpServletRequest request) {
		String m_id =  getSessionM_Id(request);
		model.addAttribute("soldList", memberService.getSoldList(m_id));
		return "member/soldList";		
	}
	
	@GetMapping("buyList")
	public String buyList(Model model, HttpServletRequest request) {
		String m_id =  getSessionM_Id(request);
		model.addAttribute("buyList", memberService.getBuyList(m_id));
		return "member/buyList";		
	}
	
	@GetMapping("onSaleList")
	public String onSaleList(Model model, HttpServletRequest request) {
		String m_id =  getSessionM_Id(request);
		model.addAttribute("onSaleList", memberService.getOnSaleList(m_id));
		return "member/onSaleList";		
	}

	@GetMapping("review")
	public String getReviewList( Model model, HttpServletRequest request) {
		String m_id =  getSessionM_Id(request);
		model.addAttribute("soldList", memberService.getSoldList(m_id));
		model.addAttribute("avgScore", memberService.getAvgScore(m_id));
		return "member/review";		
	}
	
	@GetMapping("point")
	public String review( Model model, HttpServletRequest request) {
		String m_id =  getSessionM_Id(request);
		model.addAttribute("dealList", memberService.getDealList(m_id));
		model.addAttribute("m_point", memberService.getPoint(m_id));
		return "member/point";		
	}
	
	@GetMapping("wishlist")
	public String wishlist(Model model, HttpServletRequest request) {
		String m_id =  getSessionM_Id(request);
		model.addAttribute("wish_viewList", memberService.getWish_viewList(m_id));
		return "member/wishlist";		
	}
	
	@GetMapping("cancelWish")
	public String cancelWish(HttpServletRequest request) {
		int wish_id = Integer.parseInt(request.getParameter("wish_id"));
		memberService.deleteWish(wish_id);
		return "redirect:/member/wishlist";
	}
	
}