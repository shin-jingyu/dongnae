package com.marketdongnae.controller.member;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestBody;
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
import com.marketdongnae.domain.member.PointDTO;
import com.marketdongnae.domain.member.Si_areaDTO;
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
	
	
	@GetMapping("detail")
	public void detail() {
	}
	
	@PostMapping("detail/do_area")
	@ResponseBody
	public List<Do_areaDTO> detail_do_area() {
		 List<Do_areaDTO> doList =  memberService.getDoList();
		return doList;		
	}
	
//	@PostMapping("detail/si_area_default")
//	@ResponseBody
//	public List<Si_areaDTO> detail_si_area_default(Principal principal, Model model) {
//		m= memberService.getMember(principal.getName());
//		int do_id = memberService.getDoId(memberDTO.getSi_id());
//		List<Si_areaDTO> siList =  memberService.getSiList(do_id);
//		model.addAttribute("do_id", do_id);
//		return siList;		
//	}

	@PostMapping("detail/si_area")
	@ResponseBody
	public List<Si_areaDTO> detail_si_area(@RequestBody int do_id) {
		 List<Si_areaDTO> siList =  memberService.getSiList(do_id);
		return siList;		
	}
	
	@PostMapping("update")
	public String modify(@ModelAttribute MemberDTO memberDTO) {		
		memberService.updateMember(memberDTO);
		return "redirect:/"	;
	}
	
	@GetMapping("changePassword")
	public void changePassword(Principal principal, @ModelAttribute ("password") PasswordDTO passwordDTO ) {
		passwordDTO.setM_id(principal.getName());
		memberService.getSoldList(principal.getName());
	}
	
	
	@PostMapping("changePassword")
	public String changePassword_post(Principal principal, @ModelAttribute ("password") PasswordDTO passwordDTO  ) {
		String result = memberService.changePassword(principal.getName(), passwordDTO);
		if ( result == "fail") 
			return "member/changePassword";
		else 
			return "redirect:/";
	}
	
	@GetMapping("login")
	public void login() {
	}
	
	@GetMapping("loginFail")
	public String loginFail(Model model) { 
		model.addAttribute("login", "fail");
		return "member/login";
	}
	// ("member/loginSuccess")는 CustomLoginSuccessHandler에서 이동함
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request ) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("regist")
	public void regist() {
	}
	
	@PostMapping("regist")
	public String regist_post(@ModelAttribute MemberDTO memberDTO) {
		memberService.regist(memberDTO);
		return "member/login";		
	}
	
	@PostMapping("regist/do_area")
	@ResponseBody
	public List<Do_areaDTO> regist_do_area() {
		 List<Do_areaDTO> doList =  memberService.getDoList();
		return doList;		
	}

	@PostMapping("regist/si_area")
	@ResponseBody
	public List<Si_areaDTO> regist_si_area(@RequestBody int do_id) {
		 List<Si_areaDTO> siList =  memberService.getSiList(do_id);
		return siList;		
	}

	@GetMapping("soldList")
	public void soldList(Principal principal,  Model model) {
		model.addAttribute("soldList", memberService.getSoldList(principal.getName()));
	}
	
	@GetMapping("buyList")
	public void buyList(Model model, Principal principal ) {
		model.addAttribute("buyList", memberService.getBuyList(principal.getName()));
	}
	
	@GetMapping("onSaleList")
	public void onSaleList(Model model, Principal principal ) {
		model.addAttribute("onSaleList", memberService.getOnSaleList(principal.getName()));
	}

	@GetMapping("review")
	public void getReviewList( Model model, Principal principal ) {
		model.addAttribute("soldList", memberService.getSoldList(principal.getName()));
		model.addAttribute("avgScore", memberService.getAvgScore(principal.getName()));
	}
	
	@GetMapping("point")
	public void point( Model model, Principal principal ) {
		model.addAttribute("pointList", memberService.getPointList(principal.getName()));
		model.addAttribute("m_point", memberService.getPoint(principal.getName()));
	}
	
	@PostMapping("point")
	public String point_post(@ModelAttribute PointDTO pointDTO ) {
		memberService.putPoint(pointDTO) ;
		return "redirect:/member/point";		
	}
	
	@GetMapping("wishlist")
	public void wishlist(Model model , Principal principal) {
		model.addAttribute("wish_viewList", memberService.getWish_viewList(principal.getName()));
	}
	
	@GetMapping("cancelWish")
	public String cancelWish( HttpServletRequest request ) {
		int wish_id = Integer.parseInt(request.getParameter("wish_id"));
		memberService.deleteWish(wish_id);
		return "redirect:/member/wishlist";
	}
	
	@PostMapping("checkId")
	@ResponseBody
	public String checkId(@RequestBody String checkId) {
		System.out.println("###"+checkId);
		String msg =  memberService.checkId(checkId);
		return msg ; 
	}
	
}