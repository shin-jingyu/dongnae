package com.marketdongnae.controller.member;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
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

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.member.AllDTO;
import com.marketdongnae.domain.member.Deal_viewDTO;
import com.marketdongnae.domain.member.KeywordVO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PageDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.domain.member.PointDTO;
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
	private final GoodsService goodsService;
	
	private String getFolder() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = simpleDateFormat.format(date);
		return str.replace("-", File.separator);
	}
	
	@GetMapping("detail")
	public void detail(Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		MemberDTO member = memberService.getMember(customUserDetails);
		model.addAttribute("member", member);
	}
	
	@PostMapping("detail/my_area")
	@ResponseBody
	public Map<String, List<AllDTO>> detail_do_area( ) {
		 CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 List<AllDTO> doList =  memberService.getDoList();
		 List<AllDTO> siList =  memberService.getSiList(customUserDetails.getDo_id());
		 Map<String, List<AllDTO>> dosimap = new HashMap<String, List<AllDTO>>();
		 dosimap.put("doList", doList);
		 dosimap.put("siList", siList);
		return dosimap;		
	}
	
	@PostMapping("detail/si_area")
	@ResponseBody
	public List<AllDTO> detail_si_area(@RequestBody int do_id ) {
		List<AllDTO> siList =  memberService.getSiList(do_id);
		return siList;		
	}
	
	@PostMapping("detail")
	public String regist_post(@ModelAttribute MemberDTO memberDTO, @RequestParam ("uploadFile") MultipartFile [] uploadFile) {
			String uploaderFolder = "/Users/hyeonjilee/git/dongnaeMarket/dongnae/src/main/webapp/resources/upload/member";
			// File uploadPath = new File(uploaderFolder, getFolder());		// @오류로 변경
			File uploadPath = new File(uploaderFolder);						// @오류로 변경
		    
			if (!uploadPath.exists()) {
		        uploadPath.mkdirs();
		    }
		    // MultipartFile 필드들을 반복문으로 처리
		    String[] picFileNames = new String[uploadFile.length];
		    MultipartFile picFile = uploadFile[0];
		        // 업로드한 이미지 있는지 확인
		        if (picFile != null && !picFile.isEmpty()) {
		            // 파일 업로드 처리 로직
		            picFileNames[0] = picFile.getOriginalFilename();
		            UUID uuid = UUID.randomUUID();
		            picFileNames[0] = uuid.toString() + "_" + picFileNames[0];
		            log.info("only-file-name" + picFileNames[0]);
		            //File saveFile = new File(uploadPath, picFileNames[0]); 	// @오류로 변경
		            File saveFile = new File(uploadPath, picFileNames[0]);		// @오류로 변경
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
		            memberDTO.setM_pic(picFileNames[0]);
		    		// memberDTO.setM_picpath(getFolder());	// @오류로 변경
		        }
		memberService.updateMember(memberDTO);
		return "redirect:/member/detail"	;
	}
	
	@GetMapping("changePassword")
	public void changePassword() {
	}

	@PostMapping("checkpsw")
	@ResponseBody
	public String checkpsw(@RequestParam Map<String, Object> passwordDTO) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String result = memberService.checkPassword(customUserDetails, passwordDTO);
		return result ; 
	}
	
	@PostMapping("changePassword")
	public String changePassword_post(@ModelAttribute PasswordDTO passwordDTO) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		memberService.changePassword(customUserDetails,passwordDTO.getNew_password());
		return "redirect:/logout" ;
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
		List<GoodsDTO> goodsListOnSale = goodsService.getGoodsListOnSaleList(customUserDetails.getMemberNumber());
		model.addAttribute("onSaleList", goodsListOnSale);
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
	
	@GetMapping("keyword")
	public void keyword() {
	}
}