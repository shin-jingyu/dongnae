package com.marketdongnae.mapper;

import java.util.List;
import java.util.Map;

import com.marketdongnae.domain.member.Deal_viewDTO;
import com.marketdongnae.domain.member.Do_areaDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.domain.member.Point_viewDTO;
import com.marketdongnae.domain.member.Si_areaDTO;
import com.marketdongnae.domain.member.Wish_viewDTO;
import com.marketdongnae.security.CustomUserDetails;

public interface MemberMapper {
	public CustomUserDetails loginID(String m_id);

	public List<Do_areaDTO> getDoList();
	
	public List<Si_areaDTO> getSiList(int do_id);
	
	public MemberDTO getMember(String m_id);

	public Integer updateMember(MemberDTO memberDTO);

	public List<Deal_viewDTO> getDealList(int m_number);

	public List<Deal_viewDTO> getSoldList(int m_number);

	public List<Deal_viewDTO> getBuyList(int m_number);
	
	public List<Deal_viewDTO> getOnSaleList(int m_number);

	public Integer regist(MemberDTO memberDTO);

	public String changePassword(PasswordDTO passwordDTO);

	public List<Wish_viewDTO> getWish_viewList(int m_number);
	
	public void deleteWish(int wish_id);

	public void putPoint(MemberDTO memberDTO);
	
//	public void plusPoint(Point_viewDTO point_viewDTO);

	


}
