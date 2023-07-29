package com.marketdongnae.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.goods.GoodsPictureDTO;
import com.marketdongnae.service.goods.GoodsService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/goods/")
public class GoodsController {

	private final GoodsService goodsService;
	
	private String getFolder() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date();
		
		String str = simpleDateFormat.format(date);
		
		return str.replace("-", File.separator);
	}
	
	@GetMapping(value = "getList")
	public List<GoodsDTO> goods_List_Get() {
		return goodsService.getList();
	}
	
	@PostMapping(value = "addGoods")
	public void goods_Add_Post(@ModelAttribute GoodsDTO goodsDTO, MultipartFile[] uploadFile) {
		
		//mac 기준 경로설정
		String uploaderFolder = "/Users/nohbin/Desktop/upload";
		
		
		File uploadPath = new File(uploaderFolder, getFolder());
		log.info("upload path : " + uploadPath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		GoodsPictureDTO goodsPictureDTO = new GoodsPictureDTO();
		
		 
	}
	
	
}
