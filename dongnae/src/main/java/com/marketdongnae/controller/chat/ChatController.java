package com.marketdongnae.controller.chat;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketdongnae.domain.chatting.ChatRoom;
import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.security.CustomUserDetails;
import com.marketdongnae.service.chatting.ChattingService;
import com.marketdongnae.service.goods.GoodsService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class ChatController {
	
	private final GoodsService goodsService;
	private final ChattingService chatService;

	@GetMapping("/chat")
	public void chat(Model model, @RequestParam("g_id") Integer g_id) {
	    // g_id 값을 사용하여 원하는 작업을 수행
	    CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    log.info("==================================");
	    log.info("@ChatController, GET Chat / Username : " + user.getUsername());
	    ChatRoom roomVO = new ChatRoom();
	    GoodsDTO goods = goodsService.getGoodsDetail(g_id);
	    
	    roomVO.setSeller_M_Number(goods.getM_number());
	    roomVO.setG_id(goods.getG_id());
	    roomVO.setBuyer_M_Number(user.getM_number());
	    
	    
	    
	    model.addAttribute("roomVO",roomVO);
	    model.addAttribute("goods", goodsService.getGoodsDetail(g_id));
	    model.addAttribute("userid", user.getUsername());
	}
}
