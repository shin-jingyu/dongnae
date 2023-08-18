package com.marketdongnae.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marketdongnae.domain.member.Deal_viewDTO;
import com.marketdongnae.domain.member.Do_areaDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PageDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.domain.member.PointDTO;
import com.marketdongnae.domain.member.Si_areaDTO;
import com.marketdongnae.security.CustomAuthenticationProvider;
import com.marketdongnae.security.CustomUserDetails;
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
	
	@GetMapping("detail")
	public void detail(Model model) {
		 CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("member", customUserDetails);
	}

	
	@PostMapping("detail/do_area")
	@ResponseBody
	public List<Do_areaDTO> detail_do_area( ) {
		 List<Do_areaDTO> doList =  memberService.getDoList();
		return doList;		
	}
	
	@PostMapping("detail/si_area")
	@ResponseBody
	public List<Si_areaDTO> detail_si_area(@RequestBody int do_id ) {
		List<Si_areaDTO> siList =  memberService.getSiList(do_id);
		return siList;		
	}
	
	@PostMapping("detail")
	public String modify(@ModelAttribute MemberDTO memberDTO) {		
		memberService.updateMember(memberDTO);
		return "redirect:/member/detail"	;
	}
	
	@GetMapping("changePassword")
	public void changePassword(@ModelAttribute ("password") PasswordDTO passwordDTO ) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		passwordDTO.setM_number((int) customUserDetails.getM_number());
		memberService.getSoldList(customUserDetails);
	}
	
	@PostMapping("changePassword")
	public String changePassword_post(@ModelAttribute ("password") PasswordDTO passwordDTO , HttpSession session ) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String result = memberService.changePassword(customUserDetails, passwordDTO);
		if ( result == "fail") 
			return "member/changePassword";
		else 
			session.invalidate();
			return "redirect:/member/login";
	}


	@GetMapping("soldList")
	public void soldList(@RequestParam(value = "p", defaultValue = "1" ) int nowpage ,  Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PageDTO pageDTO = memberService.getDealPageDTO(nowpage, customUserDetails, "sold");
		List<Deal_viewDTO> soldList = memberService.getDealPageList(customUserDetails,  "sold", pageDTO);
		model.addAttribute("soldList", soldList);
		model.addAttribute("page", pageDTO);
	}
	
	@GetMapping("buyList")
	public void buyList(@RequestParam(value = "p", defaultValue = "1" ) int nowpage,  Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PageDTO pageDTO = memberService.getDealPageDTO(nowpage, customUserDetails, "buy");
		List<Deal_viewDTO> buyList = memberService.getDealPageList(customUserDetails, "buy", pageDTO);
		model.addAttribute("buyList", buyList);
		model.addAttribute("page", pageDTO);
	}


	@GetMapping("onSaleList")
	public void onSaleList( @RequestParam(value = "p", defaultValue = "1" ) int nowpage , Model model ) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PageDTO pageDTO = memberService.getDealPageDTO(nowpage, customUserDetails, "onSale");
		List<Deal_viewDTO> onSaleList = memberService.getDealPageList( customUserDetails, "onSale", pageDTO);
		model.addAttribute("onSaleList", onSaleList);
		model.addAttribute("page", pageDTO);
	}

	@GetMapping("review")
	public void getReviewList( @RequestParam(value = "p", defaultValue = "1" ) int nowpage , Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PageDTO pageDTO = memberService.getDealPageDTO(nowpage, customUserDetails, "sold");
		List<Deal_viewDTO> soldList = memberService.getDealPageList(customUserDetails,  "sold", pageDTO);
		model.addAttribute("soldList", soldList);
		model.addAttribute("page", pageDTO);
		model.addAttribute("avgScore", memberService.getAvgScore(customUserDetails));
	}
	
	@GetMapping("point")
	public void point( @RequestParam(value = "p", defaultValue = "1" ) int nowpage , Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PageDTO pageDTO = memberService.getPageDTO("point","p_id",  nowpage, customUserDetails);
		model.addAttribute("pointList", memberService.getPageList("point", pageDTO, customUserDetails ));
		model.addAttribute("page", pageDTO);
		
		model.addAttribute("m_point", memberService.getPoint(customUserDetails));
	}
	
	@PostMapping("point")
	public String point_post(@ModelAttribute PointDTO pointDTO ) {
		memberService.putPoint(pointDTO) ;
		return "redirect:/member/point";		
	}

	@GetMapping("wishlist")
	public void wishlist( @RequestParam(value = "p", defaultValue = "1" ) int nowpage , Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		PageDTO pageDTO = memberService.getPageDTO("wish_view","wish_id",  nowpage, customUserDetails);
		model.addAttribute("wishList", memberService.getPageList("wish_view", pageDTO, customUserDetails ));
		model.addAttribute("page", pageDTO);
	}
	
	@GetMapping("cancelWish")
	public String cancelWish( HttpServletRequest request ) {
		int wish_id = Integer.parseInt(request.getParameter("wish_id"));
		memberService.deleteWish(wish_id);
		return "redirect:/member/wishlist";
	}

}