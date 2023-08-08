package com.marketdongnae.service.Community;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		System.out.println("service before");
		communityMapper.deleteCommunity(mu_id);
		System.out.println("service after");
		
	}

	@Override
	public HeartDTO heartview(String m_id, String mu_id) {
		
		return communityMapper.heartview(m_id, mu_id);
	}
	

	
	
	

	

	

	

	

	
	
	
	

	




}
