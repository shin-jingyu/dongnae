package com.marketdongnae.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/")
public class LoginController {
	
	@GetMapping("login")
	public String login(Model model) {
		return "member/login";
	}
	
	@GetMapping("loginFail")
	public String loginFail(Model model) { 
		model.addAttribute("login", "fail");
		System.out.println("E####fail");
		return "member/login";
	}
	// ("member/loginSuccess")는 CustomLoginSuccessHandler에서 이동함
	
	@GetMapping("logout")
	public String logout( ) {
		return "redirect:/login";
	}

}