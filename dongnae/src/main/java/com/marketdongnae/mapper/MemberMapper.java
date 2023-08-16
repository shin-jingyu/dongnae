package com.marketdongnae.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.marketdongnae.domain.member.MemberAllDTO;
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
	
	public MemberDTO getMember(int m_number);
	
	public MemberDTO checkId(String m_id);

	public Integer updateMember(MemberDTO memberDTO);

	public List<Deal_viewDTO> getSoldList(int m_number);

	public Integer regist(MemberDTO memberDTO);

	public String changePassword(PasswordDTO passwordDTO);

	public void deleteWish(int wish_id);

	public Si_areaDTO getSi_area(int si_id);

	public void updatePoint(MemberDTO memberDTO);

	public void insertPointList(PointDTO pointDTO);

	public List<Deal_viewDTO> getDealPageList(@Param ("m_number") int m_number
											, @Param ("d_type") String d_type
											,@Param ("displayStart") int displayStart );
	
	public int getDealCnt(@Param ("m_number") int m_number, @Param ("d_type") String d_type);
	
	
	public List<MemberAllDTO> getPageList(@Param ("m_number") int m_number
										, @Param ("table") String table
										,@Param ("displayStart") int displayStart);

	public int getListCnt(@Param ("m_number") int m_number, @Param ("table_id") String table_id, @Param ("table") String table);
	


}
