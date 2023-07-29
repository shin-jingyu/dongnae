package com.marketdongnae.service;
import java.util.List;
import java.util.Map;

import com.marketdongnae.security.CustomUserDetails;

public interface MemberService {

	Map<String, Object> getMember(String m_id);

	Integer updateMember(Map<String, Object> map);

	Map<String, Object> getBuy(String b_id);

	Map<String, Object> getSold(String s_id);

	List<Map<String, Object>> getSoldList (int m_number);

	List<Map<String, Object>> getBuyList(int m_number);
}