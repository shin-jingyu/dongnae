package com.marketdongnae.controller.goods;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketdongnae.service.goods.CategoryService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
@RequestMapping("/api/")
public class GoodsCategoryController {

	private CategoryService categoryService;
	
	@RequestMapping(value =  "getCategories")
	public Map<String, Object> getCategories(){
		return categoryService.getCategoryData();
	}
	
}
