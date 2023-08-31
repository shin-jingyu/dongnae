package com.marketdongnae.controller.goods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.goods.SearchDTO;
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
	
//	@GetMapping(value = "goods_list")
//	public List<GoodsDTO> goods_List_Get() {
//		return goodsService.getGoodsList();
//	}
	@GetMapping(value = "search/{search}")
	public String searchGoods(@PathVariable(required = false) String search, Model model,
	                          @RequestParam(name = "category", required = false) Integer category) {

	    SearchDTO searchDTO = new SearchDTO();

	    if (search != null && !search.isEmpty()) {
	        searchDTO.setKeyword(search);
	    }

	    if (category != null) {
	        searchDTO.setCategory(category);
	    }
	    System.out.println(searchDTO);
	    List<GoodsDTO> goodsList = goodsService.getSearchGoods(searchDTO);
	    model.addAttribute("goodsLists", goodsList);
	    model.addAttribute("search", search);
	    return "goods/goods_list";
	}

	@GetMapping(value = "search")
	public String searchGoodsNoSearch(Model model,
	                                  @RequestParam(name = "category", required = false) Integer category) {
	    return searchGoods(null, model, category);
	
	}

	
	@GetMapping(value = "/goods_detail/{g_id}")
	public String goods_detail_get(@PathVariable("g_id") int g_id, Model model) {
		model.addAttribute("goods", goodsService.getGoodsDetail(g_id));
		return "goods/goods_detail";
	}
	
	
	@GetMapping(value = "goods_insert")
	public void goods_Insert_Get() {
		
	}
	
	@PostMapping(value = "goods_insert")
	public String goods_Add_Post(@ModelAttribute GoodsDTO goodsDTO, @RequestParam("uploadFile") MultipartFile [] uploadFile) {
		String uploaderFolder = "/Users/baegjuyeong/git/Spring_dongnaeMarket/dongnae/src/main/webapp/resources/upload/goods";
		File uploadPath = new File(uploaderFolder, getFolder());

	    if (!uploadPath.exists()) {
	        uploadPath.mkdirs();
	    }
	    
	    // MultipartFile 필드들을 반복문으로 처리
	    String[] picFileNames = new String[uploadFile.length];
	    for (int i = 0; i < uploadFile.length; i++) {
	        MultipartFile picFile = uploadFile[i];
	        if (picFile != null && !picFile.isEmpty()) {
	            // 파일 업로드 처리 로직
	            picFileNames[i] = picFile.getOriginalFilename();
	            UUID uuid = UUID.randomUUID();
	            picFileNames[i] = uuid.toString() + "_" + picFileNames[i];
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
	    }
	    
	    goodsDTO.setG_picpath(getFolder());
		goodsDTO.setG_pic01(picFileNames[0]);
		goodsDTO.setG_pic02(picFileNames[1]);
		goodsDTO.setG_pic03(picFileNames[2]);
	    goodsService.insertGoods(goodsDTO);
	    return "redirect:/";
	}
	
	@GetMapping(value = "eidt")
	public void goods_Update_Get() {
		
	}
	
	@PostMapping(value = "edit")
	public String goods_Update_Post(@ModelAttribute GoodsDTO goodsDTO, MultipartFile[] uploadFile) {
		 goodsService.updateGoods(goodsDTO);
		 
	    return "/goods/getList";
	}
	
	@ResponseBody
	@RequestMapping(value = "memberGetGoodsList" ,method = RequestMethod.POST)
	public Map<String, Object> memberGoodsList(@RequestParam(value = "m_number",required=false) int m_number) {
		Map<String, Object> maps = new HashMap<String, Object>();
		
		maps = goodsService.getGoodsList(m_number);
		
		return maps;
	}
	
	
	
}
