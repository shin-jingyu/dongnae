package com.marketdongnae.mapper;

import java.util.List;
import java.util.Map;

import com.marketdongnae.security.CustomUserDetails;

public interface MemberMapper {
	public CustomUserDetails select(String m_id);
	
	public Map<String, Object> getMember(String m_id);

	public Integer updateMember(Map<String, Object> map);

	// 반복 구현 후 지우기 
	public Map<String, Object> getBuy(String b_id);

	public Map<String, Object> getSold(String s_id);

	public List<Map<String, Object>> getSoldList(int m_number);

	public List<Map<String, Object>> getBuyList(int m_number);

}
