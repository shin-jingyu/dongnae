package com.marketdongnae.controller.goods;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketdongnae.domain.goods.WishGoodsDTO;
import com.marketdongnae.security.CustomUserDetails;
import com.marketdongnae.service.goods.GoodsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/restgoods/")
@AllArgsConstructor
public class RestGoodsController {

	private final GoodsService goodsService;
	
	@RequestMapping(value = "goodsWish")
	public Map<String, Object> goodsWish(@AuthenticationPrincipal CustomUserDetails user , WishGoodsDTO wish) {
		Map<String, Object> map = new HashMap<String, Object>();
		wish.setM_number(user.getM_number());
		goodsService.goodsWish(wish);
		map.put("result", "succes");
		return map;
	}
	
	@RequestMapping(value = "checkWishGoods")
	public Map<String, Object> checkWishGoods(@AuthenticationPrincipal CustomUserDetails user , WishGoodsDTO wish){
		Map<String, Object> map = new HashMap<String, Object>();
		wish.setM_number(user.getM_number());
		map.put("checkWishGoods", goodsService.checkWishGoods(wish));
		map.put("result", "succes");
		return map;
	}
	
	@RequestMapping(value = "getCountWishGoods")
	public Map<String, Object> getCountWishGoods(int g_id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count"	, goodsService.getCountWishGoods(g_id));
		return map;
	}
	
}
