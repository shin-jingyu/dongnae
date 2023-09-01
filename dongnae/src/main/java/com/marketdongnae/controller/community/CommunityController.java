package com.marketdongnae.controller.community;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.JsonObject;
import com.marketdongnae.domain.community.CategoryDTO;
import com.marketdongnae.domain.community.CommentDTO;
import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.HeartDTO;
import com.marketdongnae.domain.community.PageDTO;
import com.marketdongnae.domain.community.communityDetailDTO;
import com.marketdongnae.security.CustomUserDetails;
import com.marketdongnae.service.Community.CommunityService;

@Controller
public class CommunityController {
	@Autowired
	CommunityService communityService;
	
	
	@GetMapping("/community/main")
	public String getCommunity(Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<CategoryDTO> categorys = communityService.category();
		
		List<CommunityAllDTO> list = communityService.communityAll();
		Collections.reverse(list); 
		
		List<CommunityAllDTO> sorted = new ArrayList<>(list);
		sorted.sort((dto1, dto2) -> Integer.compare(dto2.getMu_c(), dto1.getMu_c()));
		model.addAttribute("sorted", sorted);
		model.addAttribute("member", customUserDetails);
		model.addAttribute("categorys", categorys);
		model.addAttribute("list",list);
		return "community/community";
	}
	
	@GetMapping("/community/page")
	public String communityPage(@ModelAttribute PageDTO page,Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<CategoryDTO> categorys = communityService.category();
		page.setCount(communityService.counts());
		List<CommunityAllDTO> list = communityService.listPage(page.getDisplayPost(), page.getPostNum());
		List<CommunityAllDTO> sorted = new ArrayList<>(list);
		 sorted.sort((dto1, dto2) -> Integer.compare(dto2.getMu_c(), dto1.getMu_c()));
		model.addAttribute("page", page);
		model.addAttribute("sorted", sorted);
		model.addAttribute("member", customUserDetails);
		model.addAttribute("categorys", categorys);
		model.addAttribute("list",list);
		return "community/communityPage";
	}
	
	@GetMapping("/community/pageCategory")
	public String getpageCategory(Model model,@ModelAttribute PageDTO page) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		page.setCount(communityService.pageCategoryCount(page.getCa_l()));
		List<CommunityAllDTO> list = communityService.pageCategory(page.getDisplayPost(), page.getPostNum(), page.getCa_l());
		List<CategoryDTO> categorys = communityService.category();
		model.addAttribute("category", categorys);
		model.addAttribute("member",customUserDetails);
		model.addAttribute("list",list);
		model.addAttribute("page", page);
		return "community/communityCategory";
	}
	
	
	@GetMapping("/community/categorySearch")
	public String categorySearch(Model model, @ModelAttribute PageDTO page) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		page.setCount(communityService.listPageSearchsCount(page.getCa_l(),page.getKeyword(),page.getSearchType()));
		List<CommunityAllDTO> list = communityService.listPageSearchs(page.getDisplayPost(), page.getPostNum(), page.getCa_l(), page.getKeyword(),page.getSearchType());
		List<CategoryDTO> categorys = communityService.category();
		model.addAttribute("member",customUserDetails);
		model.addAttribute("categorys",categorys);
		model.addAttribute("page", page);
		model.addAttribute("list",list);
		return "community/categorySearch";
	}
	
	
	@GetMapping("/community/communitySearch")
	public String communitySearch(@ModelAttribute PageDTO page,Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		page.setCount(communityService.listPageSearchCount(page.getSearchType(), page.getKeyword()));
		List<CommunityAllDTO>list = communityService.listPageSearch(page.getDisplayPost(), page.getPostNum(), page.getSearchType(), page.getKeyword());
		List<CategoryDTO> categorys = communityService.category();
		model.addAttribute("categorys", categorys);
		model.addAttribute("member",customUserDetails);
		model.addAttribute("list",list);
		model.addAttribute("page", page);
		return "community/communitySearch";
	}
	
	
	@GetMapping("/community/communityDetail")
	public String communityDetail(@ModelAttribute CommunityAllDTO communityAllDTO,Model model){
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<CategoryDTO> categorys = communityService.category();
		List<CommentDTO> lists  = communityService.selectComment(communityAllDTO.getMu_id());
		int heartview = communityService.heartview(customUserDetails.getM_number(),communityAllDTO.getMu_id());
		communityService.updateCount(communityAllDTO.getMu_id());
		communityAllDTO = communityService.communityDetail(communityAllDTO.getMu_id());
		model.addAttribute("member",customUserDetails);
		model.addAttribute("categorys", categorys);
		model.addAttribute("comment",lists);
		model.addAttribute("communityDetail", communityAllDTO);
		model.addAttribute("heartview", heartview);
		return "community/communityDetail";
	}
	@ResponseBody  
	@PostMapping("/heart") 
	public int heart(@ModelAttribute HeartDTO heart) { 
		 int result = communityService.insertHeart(heart);
		 return result;
	 }

	@GetMapping("/community/insertCommunity")
	public String insertCommunity(Model model) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		List<CategoryDTO> categorys = communityService.category();
		model.addAttribute("categorys",categorys);
		model.addAttribute("member",customUserDetails);
		return "community/insertCommunity";
	}
	
	@PostMapping("/community/insertCommunity")
	public String insertCommunityPost(@ModelAttribute communityDetailDTO communityDetailDTO) {
		communityService.insertCommunity(communityDetailDTO);
		return "redirect:/community/main";
	}
	
	
	@ResponseBody
	@PostMapping("/community/upload")
	public String upload( @RequestParam("file") MultipartFile[] upload,HttpSession session) {
		JsonObject jsonObject = new JsonObject();
		String fileRoot = "C:\\Users\\jingyu\\git\\Spring_dongnaeMarket\\dongnae\\src\\main\\webapp\\resources\\upload\\community\\"; 
		@SuppressWarnings("unchecked")
	    List<String> uploadedImageNames = (List<String>) session.getAttribute("uploadedImageNames");
		if (uploadedImageNames == null) {
	        uploadedImageNames = new ArrayList<>();
	    }
		for (MultipartFile multipartFile : upload) {
			 String originalFileName = multipartFile.getOriginalFilename(); // 오리지날 파일명
		      String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 파일 확장자
		      String savedFileName = UUID.randomUUID() + extension; // 저장될 파일 명
		      File targetFile = new File(fileRoot + savedFileName);
	        try {
	            InputStream fileStream = multipartFile.getInputStream();
	            FileUtils.copyInputStreamToFile(fileStream, targetFile); // 파일 저장
	            jsonObject.addProperty("url","/resources/upload/community/"+savedFileName); 
	            jsonObject.addProperty("responseCode", "success");
	            uploadedImageNames.add(savedFileName);    
	        } catch (IOException e) {
	            FileUtils.deleteQuietly(targetFile); // 저장된 파일 삭제
	            jsonObject.addProperty("responseCode", "error");
	            e.printStackTrace();
	        }
	        
		}
		session.setAttribute("uploadedImageNames", uploadedImageNames);
		jsonObject.addProperty("uploadedImageNames", uploadedImageNames.toString());
		String a = jsonObject.toString();
		return a;	
	}
	
	@ResponseBody
	@PostMapping("/deleteSummernoteImageFile")
	public void deleteSummernoteImageFile(@RequestParam("file") List<String> fileNames) {
	    // 폴더 위치
	    String filePath = "C:\\Users\\jingyu\\git\\Spring_dongnaeMarket\\dongnae\\src\\main\\webapp\\resources\\upload\\community\\";
	    for (String fileName : fileNames) {
		    // 해당 파일 삭제
		    Path path = Paths.get(filePath, fileName);
		    try {
		        Files.delete(path);
		    } catch (Exception e) {
		       e.printStackTrace();
		    }
	    }
	}
	
	@GetMapping("/community/updateCommunity")
	public String update(@ModelAttribute CommunityAllDTO detailDTO,Model model) {
		List<CategoryDTO> categorys = communityService.category();
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		detailDTO = communityService.communityDetail(detailDTO.getMu_id());
		model.addAttribute("categorys", categorys);
		model.addAttribute("member",customUserDetails);
		model.addAttribute("community",detailDTO);
		
		return "community/updateCommunity";
	}
	
	@PostMapping("/community/updateCommunity")
	public String updateCommunityPost(@ModelAttribute communityDetailDTO communityDetailDTO,HttpSession session ) {
	
		communityService.updateCommunity(communityDetailDTO);
		session.removeAttribute("uploadedImageNames");
		return "redirect:/community/communityDetail?mu_id="+communityDetailDTO.getMu_id();
									
		
	}
	
	@ResponseBody
	@GetMapping("/community/deleteCommunity")
	public String deleteCommunity(@RequestParam("mu_id") int mu_id) {
		
		communityService.deleteCommunity(mu_id);
		return "success";
	}
	
	
	 @PostMapping("/comment")
	 public String comment(@ModelAttribute CommentDTO commentDTO) {
		 communityService.insertComment(commentDTO);
		 int m_ids = commentDTO.getMu_id();
		 String mu_id = String.valueOf(m_ids);

		 return "redirect:/community/communityDetail?mu_id="+mu_id+"&&m_number="+commentDTO.getM_number();
	 }
	 @ResponseBody
	 @PostMapping("/updateComment")
	 public String updateComment (@ModelAttribute CommentDTO CommentDTO ) {
		 
		 communityService.updateComment(CommentDTO);
		 return "success";
	 }
	 
	 @ResponseBody
	 @PostMapping("/deleteComment")
	 public String deleteComment (@ModelAttribute CommentDTO commentDTO) {
		communityService.deleteComment(commentDTO);
		 return "success";
	 }
	 
	
}
