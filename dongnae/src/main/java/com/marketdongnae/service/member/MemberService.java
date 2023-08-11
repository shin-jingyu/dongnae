package com.marketdongnae.service.member;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.marketdongnae.domain.member.Deal_viewDTO;
import com.marketdongnae.domain.member.Do_areaDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.domain.member.Si_areaDTO;
import com.marketdongnae.domain.member.Wish_viewDTO;
import com.marketdongnae.security.CustomUserDetails;

public interface MemberService {
	
	CustomUserDetails loginID(String m_id);
	
	List<Do_areaDTO> getDoList();
	
	List<Si_areaDTO> getSiList(int do_id);
	

	MemberDTO getMember(String m_id);

	Integer updateMember(MemberDTO memberDTO);

	List<Deal_viewDTO> getSoldList(String m_id);

	List<Deal_viewDTO> getBuyList(String m_id) ;
	
	List<Deal_viewDTO> getDealList(String m_id);
	
	List<Deal_viewDTO> getOnSaleList(String m_id);
	
	Integer regist(MemberDTO memberDTO);

	String changePassword(String m_id, PasswordDTO passwordDTO);

	int getAvgScore(String m_id);
	
	int getPoint(String m_id);
	
	void putPoint(String m_id, int m_point);

	List<Wish_viewDTO> getWish_viewList(String m_id);

	void deleteWish(int wish_id);

	String getSi_area(String m_id);

	


}