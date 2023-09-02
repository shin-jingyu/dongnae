package com.marketdongnae.service.Community;


import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketdongnae.domain.community.CategoryDTO;
import com.marketdongnae.domain.community.CommentDTO;
import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.HeartDTO;
import com.marketdongnae.domain.community.communityDetailDTO;

import com.marketdongnae.mapper.CommunityMapper;






@Service("CommunityService")
public class CommunityServiceImpl implements CommunityService {
	@Autowired
	private CommunityMapper communityMapper ;
	
	

    private  String extractImageUrlFromContent(String content) {
    	  Document doc = Jsoup.parse(content);
		    Elements imgTags = doc.select("img"); // img 태그들을 선택

		    for (Element imgTag : imgTags) {
		        String imageUrl = imgTag.attr("src"); // img 태그의 src 속성 추출
		        if (!imageUrl.isEmpty()) {
		            return imageUrl; // 이미지 URL이 비어있지 않다면 반환
		        }
		    }

	    return ""; // 이미지가 없을 경우 빈 문자열 반환
    }

	
	@Override
	public List<CommunityAllDTO> communityAll() {
		List<CommunityAllDTO> list = communityMapper.communityAll();
		 for (CommunityAllDTO dto : list) {
	            String content = dto.getMu_detail();
	            String imageUrl = extractImageUrlFromContent(content); // 이미지 URL 추출 메서드 호출
	            dto.setPreviewImageUrl(imageUrl);
	        }
		return list;
	}

	@Override
	public CommunityAllDTO communityDetail(int mu_id) {
	
		return communityMapper.communityDetail(mu_id);
	}

	@Override
	public void updateCount(int mu_id) {
		communityMapper.updateCount(mu_id);
		
	}

	@Override
	public void insertCommunity(communityDetailDTO community) {
		communityMapper.insertCommunity(community);
		
	}
	

	@Override
	public void updateCommunity(communityDetailDTO community) {
		communityMapper.updateCommunity(community);
	}

	@Override
	public void deleteCommunity(int mu_id) {
		communityMapper.deleteCommunity(mu_id);
	}

	
	@Override
	public int heartview(int m_number, int mu_id) {
	
		return communityMapper.heartview(m_number,mu_id);
	}
	
	@Override public int insertHeart(HeartDTO heart) { 
		
		int result =0;
		int m_number = heart.getM_number(); int mu_id = heart.getMu_id();
		int find = communityMapper.heartview(m_number,mu_id);
		
		if (find == 0 ) { 
			communityMapper.insertHeart(heart); 
			result = 1;  
		}else{ 
			communityMapper.deleteHeart(heart);
			result=0; 
		}
			 
		
		 return result; 
		 
	  }

	@Override
	public void insertComment(CommentDTO insertComment) {
		communityMapper.insertComment(insertComment);
		
	}

	@Override
	public List<CommentDTO> selectComment(int mu_id) {
		List<CommentDTO> list = communityMapper.selectComment(mu_id);
		return list;
	}

	@Override
	public void updateComment(CommentDTO updateComment) {
		communityMapper.updateComment(updateComment);
		
	}

	@Override
	public void deleteComment(CommentDTO deleteComment) {
		communityMapper.deleteComment(deleteComment);
		
	}

	@Override
	public int counts() {
		return communityMapper.counts();
		
	}

	@Override
	public List<CommunityAllDTO> listPage(int displaypost, int postnum) {
		
		List<CommunityAllDTO> list=communityMapper.listPage(displaypost, postnum);
		for (CommunityAllDTO dto : list) {
	        String content = dto.getMu_detail();
	        String imageUrl = extractImageUrlFromContent(content); // 이미지 URL 추출 메서드 호출
	        dto.setPreviewImageUrl(imageUrl);
	    }
		return list;
		
	}

	@Override
	public List<CommunityAllDTO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) {
		List<CommunityAllDTO> list=communityMapper.listPageSearch(displayPost, postNum, searchType, keyword);
		for (CommunityAllDTO dto : list) {
	        String content = dto.getMu_detail();
	        String imageUrl = extractImageUrlFromContent(content); // 이미지 URL 추출 메서드 호출
	        dto.setPreviewImageUrl(imageUrl);
	    }
		
		
		return list;
	}

	@Override
	public int listPageSearchCount(String searchType, String keyword) {
		
		return communityMapper.listPageSearchCount(searchType, keyword);
	}

	@Override
	public List<CommunityAllDTO> pageCategory(int displayPost, int postNum, String ca_l) {
		List<CommunityAllDTO> list=communityMapper.pageCategory(displayPost, postNum, ca_l);
		for (CommunityAllDTO dto : list) {
	        String content = dto.getMu_detail();
	        String imageUrl = extractImageUrlFromContent(content); // 이미지 URL 추출 메서드 호출
	        dto.setPreviewImageUrl(imageUrl);
	    }
		
		
		return list;
		
	}
	
	@Override
	public int pageCategoryCount(String ca_l) {
		
		return communityMapper.pageCategoryCount(ca_l);
	}

	@Override
	public List<CategoryDTO> category() {
		return communityMapper.category();
	}

	@Override
	public List<CommunityAllDTO> listPageSearchs(int displayPost, int postNum, String ca_l, String keyword,
			String searchType) {
		System.out.println(keyword);
		System.out.println(ca_l);
		System.out.println(displayPost);
		System.out.println(postNum);
		List<CommunityAllDTO> list=communityMapper.listPageSearchs(displayPost, postNum, ca_l, keyword, searchType);
		for (CommunityAllDTO dto : list) {
	        String content = dto.getMu_detail();
	        String imageUrl = extractImageUrlFromContent(content); // 이미지 URL 추출 메서드 호출
	        dto.setPreviewImageUrl(imageUrl);
	    }
		
		return list;
		
	}

	@Override
	public int listPageSearchsCount(String ca_l, String keyword, String searchType) {
		
		
		return communityMapper.listPageSearchsCount(ca_l, keyword, searchType);
	}


	

	
	

	






	
	 

	
	
	
	

	
	

	

	




}
