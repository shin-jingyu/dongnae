package com.marketdongnae.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.marketdongnae.domain.community.CommunityDTO;


@Mapper
public interface CommunityMapper {

	public List<CommunityDTO> getCommunity();
	
	public Map<String, Object> communityAll();
}
