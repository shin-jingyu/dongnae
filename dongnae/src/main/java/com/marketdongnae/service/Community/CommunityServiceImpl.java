package com.marketdongnae.service.Community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketdongnae.domain.community.CommunityAllDTO;
import com.marketdongnae.domain.community.HeartDTO;
import com.marketdongnae.domain.community.communityDetailDTO;
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
		CommunityAllDTO communityDetail = communityMapper.communityDetail(mu_id);
		return communityDetail;
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
		System.out.println("service before");
		communityMapper.deleteCommunity(mu_id);
		System.out.println("service after");
		
	}
	//좋아요 체크 

	@Override
	public HeartDTO heart(int m_number, int mu_id) {
		HeartDTO heartDTO = communityMapper.heart(m_number,mu_id );
		return heartDTO;
		
	}
	

	

	

	

	

	
	
	
	

	




}
