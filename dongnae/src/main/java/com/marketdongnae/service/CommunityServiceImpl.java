package com.marketdongnae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketdongnae.domain.community.CommunityDTO;
import com.marketdongnae.mapper.CommunityMapper;

@Service("CommunityService")
public class CommunityServiceImpl implements CommunityService {
	@Autowired
	private CommunityMapper communityMapper ;

	@Override
	public List<CommunityDTO> getCommunity() {
		List<CommunityDTO> list = communityMapper.getCommunity();
		return list;
	}



}
