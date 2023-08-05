package com.marketdongnae.service.member;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.marketdongnae.domain.member.BuyDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.SoldDTO;
import com.marketdongnae.security.CustomUserDetails;

public interface MemberService {
	
	CustomUserDetails loginID(String m_id);

	MemberDTO getMember(String m_id);

	Integer updateMember(MemberDTO memberDTO);

	BuyDTO getBuy(String b_id);

	SoldDTO getSold(String s_id);

	List<SoldDTO> getSoldList( int m_number);

	List<BuyDTO> getBuyList(  int m_number);

	Integer regist(MemberDTO memberDTO);

	Integer changePassword(Map<String, Object> map);
	
}