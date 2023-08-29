package com.marketdongnae.service.member;
import java.util.List;
import java.util.Map;

import com.marketdongnae.domain.member.Deal_viewDTO;
import com.marketdongnae.domain.member.Do_areaDTO;
import com.marketdongnae.domain.member.KeywordDTO;
import com.marketdongnae.domain.member.KeywordVO;
import com.marketdongnae.domain.member.AllDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PageDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.domain.member.PointDTO;
import com.marketdongnae.domain.member.Si_areaDTO;
import com.marketdongnae.security.CustomUserDetails;

public interface MemberService {
	
	CustomUserDetails loginID(String m_id);
	
//	List<Do_areaDTO> getDoList();
//	
//	List<Si_areaDTO> getSiList(int do_id);
	
	List<AllDTO> getDoList();
	
	List<AllDTO> getSiList(int do_id);
	
	MemberDTO getMember(CustomUserDetails customUserDetails);

	void updateMember(MemberDTO memberDTO);
	
	
	Integer regist(MemberDTO memberDTO);
	
	String checkId(String checkId);
	
	String checkPassword(CustomUserDetails customUserDetails, Map<String, Object>  passwordDTO);
	void changePassword(CustomUserDetails customUserDetails, String new_password);
//	String changePassword(CustomUserDetails customUserDetails, PasswordDTO passwordDTO);

	
	PageDTO getPageDTO( String table, String table_id ,int nowpage , CustomUserDetails customUserDetails);

	List<AllDTO> getPageList(String table, PageDTO pageDTO, CustomUserDetails customUserDetails);


	PageDTO getDealPageDTO(int nowpage, CustomUserDetails customUserDetails , String d_type);
	
	List<Deal_viewDTO> getDealPageList( CustomUserDetails customUserDetails, String d_type, PageDTO pageDTO);
	
	
//	int getPoint(CustomUserDetails customUserDetails);
//	void putPoint(PointDTO pointDTO);
	
	int getPoint(CustomUserDetails customUserDetails);

	void putPoint(PointDTO pointDTO);
	
	List<Deal_viewDTO> getSoldList(CustomUserDetails customUserDetails);

	int getAvgScore(CustomUserDetails customUserDetails);

	void deleteWish(int wish_id);
	// 키워드 Service
	int registKeyword(KeywordVO keyword);
	KeywordDTO getListKeyword(int m_number);
	int deleteKeyword(int key_id);




	


	

	

	


}