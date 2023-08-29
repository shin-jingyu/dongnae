package com.marketdongnae.controller.member;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	private String getFolder() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = simpleDateFormat.format(date);
		
		return str.replace("-", File.separator);
	}
	
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
	public String regist_post(@ModelAttribute MemberDTO memberDTO, @RequestParam ("uploadFile") MultipartFile [] uploadFile) {
		String uploaderFolder = "/Users/hyeonjilee/git/dongnaeMarket/dongnae/src/main/webapp/resources/upload/member";
		File uploadPath = new File(uploaderFolder, getFolder());

	    if (!uploadPath.exists()) {
	        uploadPath.mkdirs();
	    }
	    // MultipartFile 필드들을 반복문으로 처리
	    String[] picFileNames = new String[uploadFile.length];
	        MultipartFile picFile = uploadFile[0];
	        if (picFile != null && !picFile.isEmpty()) {
	            // 파일 업로드 처리 로직
	            picFileNames[0] = picFile.getOriginalFilename();
	            UUID uuid = UUID.randomUUID();
	            picFileNames[0] = uuid.toString() + "_" + picFileNames[0];
	            log.info("only-file-name" + picFileNames[0]);
	            File saveFile = new File(uploadPath, picFileNames[0]);
	            System.out.println("파일명 확인 !!!: " + picFileNames[0]);
	            try {
	            	uploadFile[0].transferTo(saveFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
		memberDTO.setM_pic(picFileNames[0]);
		memberDTO.setM_picpath(getFolder());
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