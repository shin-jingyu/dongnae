package com.marketdongnae.service.Community;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.HeartDTO;
import com.marketdongnae.domain.community.communityDetailDTO;
import com.marketdongnae.domain.member.MemberDTO;


public interface CommunityService {
	//글 리스트
	public List<CommunityAllDTO> communityAll();
	//글상세보기
	public CommunityAllDTO communityDetail(String mu_id);
	//조회수 증가
	public void  updateCount(String mu_id);
	//글쓰기
	public void insertCommunity(communityDetailDTO community);
	//수정하기
	public void updateCommunity(communityDetailDTO community);
	// 삭제하기
	public  void deleteCommunity(int mu_id);
	//좋아요
	public HeartDTO heartview(@Param("m_number") String m_number,@Param("mu_id") String mu_id);
	
	public int insertHeart(HeartDTO heart);
	
}
