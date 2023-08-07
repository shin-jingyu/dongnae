package com.marketdongnae.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.HeartDTO;
import com.marketdongnae.domain.community.communityDetailDTO;



@Mapper
public interface CommunityMapper {
	// 글 불러오기
	public List<CommunityAllDTO> communityAll();
	// 글 상세보기
	public CommunityAllDTO communityDetail(String mu_id);
	// 조회수 증가
	public void  updateCount(String mu_id); 
	//글쓰기
	public void insertCommunity(communityDetailDTO community);
	
	//수정하기
	public void updateCommunity(communityDetailDTO community);
	//삭제하기
	public  void deleteCommunity(int mu_id);
	

}
