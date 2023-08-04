package com.marketdongnae.service;

import java.util.List;

import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.CommunityDetailDTO;


public interface CommunityService {
	//글 리스트
	public List<CommunityAllDTO> communityAll();
	//글상세보기
	public CommunityAllDTO communityDetail(String mu_id);
	//조회수 증가
	public void  updateCount(String mu_id);
}
