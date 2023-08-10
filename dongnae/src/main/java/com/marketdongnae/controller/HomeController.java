package com.marketdongnae.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.service.goods.GoodsService;

import lombok.AllArgsConstructor;


/**
 * Handles requests for the application home page.
 */
@Controller
@AllArgsConstructor
public class HomeController {
	
	private final GoodsService goodsService; 
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<GoodsDTO> goodsList =  goodsService.getGoodsList();
		
		model.addAttribute("goodsList", goodsList);
		return "main";
	}
	
}
