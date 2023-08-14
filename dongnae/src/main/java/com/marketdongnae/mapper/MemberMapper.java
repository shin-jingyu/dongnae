package com.marketdongnae.mapper;

import java.util.List;
import java.util.Map;

import com.marketdongnae.domain.member.Deal_viewDTO;
import com.marketdongnae.domain.member.Do_areaDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PageDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.domain.member.PointDTO;
import com.marketdongnae.domain.member.Si_areaDTO;
import com.marketdongnae.domain.member.Wish_viewDTO;
import com.marketdongnae.security.CustomUserDetails;

public interface MemberMapper {
	public CustomUserDetails loginID(String m_id);

	public List<Do_areaDTO> getDoList();
	
	public List<Si_areaDTO> getSiList(int do_id);
	
	public MemberDTO getMember(String m_id);

	public Integer updateMember(MemberDTO memberDTO);

	public List<Deal_viewDTO> getSoldList(String m_id);

//	public List<Deal_viewDTO> getBuyList(String m_id);
//	
//	public List<Deal_viewDTO> getOnSaleList(String m_id);

	public Integer regist(MemberDTO memberDTO);

	public String changePassword(PasswordDTO passwordDTO);

//	public List<Wish_viewDTO> getWish_viewList(String m_id);

	public List<Wish_viewDTO> getWishPageList(PageDTO pageDTO);
	
	public int getWishCnt(String m_id);
	
	public void deleteWish(int wish_id);

	public Si_areaDTO getSi_area(int si_id);

	public List<PointDTO> getPointPageList(PageDTO pageDTO);
	
	public int getPointCnt(String m_id);
	
	public void updatePoint(MemberDTO memberDTO);

	public void insertPointList(PointDTO pointDTO);

	public int getDealCnt(Deal_viewDTO deal_viewDTO);

	public List<Deal_viewDTO> getDealPageList(PageDTO pageDTO);

	


}
