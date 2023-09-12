package com.marketdongnae.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.security.CustomUserDetails;
import com.marketdongnae.service.goods.GoodsService;
import com.marketdongnae.service.member.MemberService;

import lombok.AllArgsConstructor;


/**
 * Handles requests for the application home page.
 */
@Controller
@AllArgsConstructor
public class HomeController {
	
	private final GoodsService goodsService; 
	private final MemberService memberService; 
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		
		List<GoodsDTO> goodsList =  goodsService.getGoodsList();
		model.addAttribute("goodsList", goodsList);
		
//		if(request.getSession() != null) {
//		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		MemberDTO member = memberService.getMember(customUserDetails);
//		model.addAttribute("m_point", member.getM_point());
//		} else {
//			model.addAttribute("m_point", "0");
//		}
		
		return "common/main";
	}
	
	@GetMapping("/pay")
    public void pay(@RequestParam(name = "g_id") Integer g_id, Model model) {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    model.addAttribute("goods", goodsService.getGoodsDetail(g_id));
	    model.addAttribute("userid", user.getUsername());
    }
	
	@PostMapping(value = "/doPay")
		public String doPay() {
			
		return "common/main";		
		
	}
	
	
}
