package com.marketdongnae.mapper;

import java.util.List;
import java.util.Map;

import com.marketdongnae.domain.member.DealDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.security.CustomUserDetails;

public interface MemberMapper {
	public CustomUserDetails loginID(String m_id);
	
	
	public MemberDTO getMember(String m_id);

	public Integer updateMember(MemberDTO memberDTO);

	public List<DealDTO> getDealList(int m_number);

	public List<DealDTO> getSoldList(int m_number);

	public List<DealDTO> getBuyList(int m_number);

	public Integer regist(MemberDTO memberDTO);

	public Integer changePassword(PasswordDTO passwordDTO);

}
