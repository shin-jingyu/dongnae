package com.marketdongnae.controller.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.member.KeywordVO;
import com.marketdongnae.security.CustomUserDetails;
import com.marketdongnae.service.member.MemberService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/keywordapi/")
@AllArgsConstructor
public class RestMemberController {
	
	private MemberService memberService;

	@GetMapping(value = "keywordList")
	public List<KeywordVO>  getKeywordList(){
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext () .getAuthentication ().getPrincipal ();
		List<KeywordVO> keywordList = memberService.getListKeyword(customUserDetails);
		return keywordList;
	}
	
	@GetMapping(value = "keywordGoodsList")
	public List<GoodsDTO> getGoodsList(){
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext () .getAuthentication ().getPrincipal ();
		List<GoodsDTO> listKeywordGoods = memberService.getListKeywordGoods(customUserDetails);
		return listKeywordGoods;
	}
	
	@PostMapping(value = "insertKeyword" )
	public String insert (HttpServletRequest request) throws Exception{
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext () .getAuthentication ().getPrincipal ();
		// keyword = keyword.replace("=", "");
		String keyword = request.getParameter("msg");
		if( memberService.is_exist_Keyword(customUserDetails, keyword) ) {
			throw new Exception("이미 있는 키워드");
		}
		memberService.insertKeyword(customUserDetails, keyword); 
		return "success";
	}
	
	
	@DeleteMapping(value = "delete/{key_id}")
	public String delete(@PathVariable("key_id") int key_id){
		memberService.deleteKeyword(key_id);
		return "success";
	}
}
