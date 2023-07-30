package com.marketdongnae.mapper;

import java.util.List;
import java.util.Map;

import com.marketdongnae.security.CustomUserDetails;

public interface MemberMapper {
	public CustomUserDetails loginID(String m_id);
	
	
	
	
	public Map<String, Object> getMember(String m_id);

	public Integer updateMember(Map<String, Object> map);

	public Map<String, Object> getBuy(String b_id);

	public Map<String, Object> getSold(String s_id);

	public List<Map<String, Object>> getSoldList(int m_number);

	public List<Map<String, Object>> getBuyList(int m_number);

	public Integer regist(Map<String, Object> map);

	public Integer changePassword(Map<String, Object> map);

}
