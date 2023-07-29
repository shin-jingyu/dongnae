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
	public String goods_Add_Post(@ModelAttribute GoodsDTO goodsDTO, MultipartFile[] uploadFile) {
		
		//mac 기준 경로설정
		String uploaderFolder = "/Users/nohbin/Desktop/upload";
		
		// upload date 별 file 생성
		File uploadPath = new File(uploaderFolder, getFolder());
		log.info("upload path : " + uploadPath);
		String filePath = uploadPath.toString();
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		log.info("Upload FilePath  : " + filePath);
		GoodsPictureDTO goodsPictureDTO = new GoodsPictureDTO();
		
	    String[] picFileNames = new String[6];

	    // MultipartFile 필드들을 반복문으로 처리
	    for (int i = 0; i < uploadFile.length; i++) {
	        MultipartFile picFile = uploadFile[i];
	        if (picFile != null && !picFile.isEmpty()) {
	            // 파일 업로드 처리 로직
	            picFileNames[i] = picFile.getOriginalFilename();
	            UUID uuid = UUID.randomUUID();
	            picFileNames[i] = uuid.toString() + "_" + picFileNames[i];
	            log.info("only-file-name" + picFileNames[i]);
	            File saveFile = new File(uploadPath, picFileNames[i]);
	            try {
	            	uploadFile[i].transferTo(saveFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    } // FOR END
		
	    goodsPictureDTO.setFilePath(filePath);
	    goodsPictureDTO.setG_pic01(picFileNames[0]);
	    goodsPictureDTO.setG_pic01(picFileNames[1]);
	    goodsPictureDTO.setG_pic01(picFileNames[2]);
	    
	    goodsDTO.setGoodsPictureDTO(goodsPictureDTO);
	    
//	    goodsService.insertGoods(goodsDTO);
	    
	    return null;
	    
	}
	
	
}
