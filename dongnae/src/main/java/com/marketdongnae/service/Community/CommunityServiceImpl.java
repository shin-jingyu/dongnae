package com.marketdongnae.service.Community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketdongnae.domain.community.CommunityAllDTO;
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
	
	
	

	




}
