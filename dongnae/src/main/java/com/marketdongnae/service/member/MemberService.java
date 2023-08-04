package com.marketdongnae.service.member;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.marketdongnae.domain.member.DealDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.security.CustomUserDetails;

public interface MemberService {
	
	CustomUserDetails loginID(String m_id);

	MemberDTO getMember_DTO(String m_id, MemberDTO memberDTO);
	
	MemberDTO getMember(String m_id);

	Integer updateMember(MemberDTO memberDTO);

	List<DealDTO> getSoldList(String m_id);

	List<DealDTO> getBuyList(String m_id) ;
	
	List<DealDTO> getDealList(String m_id);
	
	Integer regist(MemberDTO memberDTO);

	Integer changePassword(String m_id, PasswordDTO passwordDTO);

	int getAvgScore(String m_id);
	
	int getPoint(String m_id);
	
}