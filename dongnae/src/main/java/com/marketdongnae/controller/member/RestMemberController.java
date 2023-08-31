package com.marketdongnae.controller.member;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.member.KeywordDTO;
import com.marketdongnae.domain.member.KeywordVO;
import com.marketdongnae.security.CustomUserDetails;
import com.marketdongnae.service.member.MemberService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/keywordapi/")
@AllArgsConstructor
public class RestMemberController {
	
	private MemberService memberService;
	/*
	@PostMapping(value = "keyword")
	public ResponseEntity<String> create(@RequestBody KeywordVO keyword){
		int insertCount = memberService.registKeyword(keyword); 
		return insertCount == 1 ? new ResponseEntity<String>("success" , HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "keywordList")
	public ResponseEntity<KeywordDTO> getKeywordList(){
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext () .getAuthentication ().getPrincipal ();
		return new ResponseEntity<KeywordDTO>(memberService.getListKeyword(customUserDetails.getM_number()) , HttpStatus.OK);
	}
	
	@DeleteMapping(value = "delete_{key_id}")
	public ResponseEntity<String> delete(@PathVariable("key_id") int key_id){
		return memberService.deleteKeyword(key_id) == 1 ? new ResponseEntity<String>("success" , HttpStatus.OK) : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "keywordGoodsList")
//	public ResponseEntity<List<GoodsDTO>> getGoodsList(){
	public List<GoodsDTO> getGoodsList(){
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext () .getAuthentication ().getPrincipal ();
		// return new ResponseEntity<List<GoodsDTO>>(memberService.getListKeywordGoods(customUserDetails.getM_number()) , HttpStatus.OK);
		return memberService.getListKeywordGoods(customUserDetails.getM_number()) ;
	}
	
	
	@GetMapping(value = "keywordGoodsList")
	public ModelAndView getGoodsList(){
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext () .getAuthentication ().getPrincipal ();
		List<GoodsDTO> listKeywordGoods = memberService.getListKeywordGoods(customUserDetails.getM_number());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("goodsLists", listKeywordGoods);
		mav.setViewName("/member/keyword");
		return mav ;
	}
	*/
	
}
