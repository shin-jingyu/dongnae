package com.marketdongnae.mapper;

import java.util.List;
import java.util.Map;

import com.marketdongnae.domain.member.BuyDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.SoldDTO;
import com.marketdongnae.security.CustomUserDetails;

public interface MemberMapper {
	public CustomUserDetails loginID(String m_id);
	
	
	public MemberDTO getMember(String m_id);

	public Integer updateMember(MemberDTO memberDTO);

	public BuyDTO getBuy(String b_id);

	public SoldDTO getSold(String s_id);

	public List<SoldDTO> getSoldList(int m_number);

	public List<BuyDTO> getBuyList(int m_number);

	public Integer regist(MemberDTO memberDTO);

	public Integer changePassword(Map<String, Object> map);

}
