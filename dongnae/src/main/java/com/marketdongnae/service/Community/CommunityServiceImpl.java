package com.marketdongnae.service.Community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.marketdongnae.domain.community.CommentDTO;
import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.HeartDTO;
import com.marketdongnae.domain.community.communityDetailDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.mapper.CommunityMapper;


@Service("CommunityService")
public class CommunityServiceImpl implements CommunityService {
	@Autowired
	private CommunityMapper communityMapper ;

	@Override
	public List<CommunityAllDTO> communityAll() {
		List<CommunityAllDTO> list = communityMapper.communityAll();
		return list;
	}

	@Override
	public CommunityAllDTO communityDetail(String mu_id) {
	
		return communityMapper.communityDetail(mu_id);
	}

	@Override
	public void updateCount(String mu_id) {
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
	public HeartDTO heartview(String m_number,String mu_id) {
		
		return communityMapper.heartview(m_number,mu_id);
	}

	
	  @Override public int insertHeart(HeartDTO heart) { 
		 Map<String, Object> map = new HashMap<String, Object>();
		 int result =0;
		 
		 int m_numberInt = heart.getM_number();
		 int mu_idInt = heart.getMu_id();
		 String m_number = String.valueOf(m_numberInt);
		 String mu_id = String.valueOf(mu_idInt);
		 
		 HeartDTO find = communityMapper.heartview(m_number,mu_id);
		 
		 
		 if (find == null ) { 
			communityMapper.insertHeart(heart);
			result = 1;
		 }else if(find.getH_num()==0){ 
			communityMapper.updateHearts(heart);
			 result=1;
		 }else {
			  communityMapper.updateHeart(heart); 
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
	
		return communityMapper.listPage(displaypost, postnum);
		
	}


	






	
	 

	
	
	
	

	
	

	

	




}
