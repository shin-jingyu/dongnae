package com.marketdongnae.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.service.goods.GoodsService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/goods/")
public class GoodsController {

	private final GoodsService goodsService;
	
	
	@GetMapping(value = "getListgoods")
	public List<GoodsDTO> goods_List_Get() {
		return goodsService.getGoodsList();
	}
	
	@PostMapping(value = "insertgoods")
	public String goods_Add_Post(@ModelAttribute GoodsDTO goodsDTO, MultipartFile[] uploadFile) {
	    goodsService.processUploadAndInsertGoods(goodsDTO, uploadFile);
	    return "/goods/getList";
	}
	
	@PostMapping(value = "updategoods")
	public String goods_Update_Post(@ModelAttribute GoodsDTO goodsDTO, MultipartFile[] uploadFile) {
		 goodsService.processUploadAndUpdateGoods(goodsDTO, uploadFile);
	    return "/goods/getList";
	}
	
}
