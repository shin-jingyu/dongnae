package com.marketdongnae.service.member;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.compiler.ast.Keyword;

import com.marketdongnae.domain.member.Deal_viewDTO;
import com.marketdongnae.domain.member.Do_areaDTO;
import com.marketdongnae.domain.member.KeywordDTO;
import com.marketdongnae.domain.member.KeywordVO;
import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.member.AllDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PageDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.domain.member.PointDTO;
import com.marketdongnae.domain.member.Si_areaDTO;
import com.marketdongnae.security.CustomUserDetails;

public interface MemberService {
	
	CustomUserDetails loginID(String m_id);
	
	List<AllDTO> getDoList();
	
	List<AllDTO> getSiList(int do_id);
	
	MemberDTO getMember(CustomUserDetails customUserDetails);

	void updateMember(MemberDTO memberDTO);
	
	
	Integer regist(MemberDTO memberDTO);
	
	String checkId(String checkId);
	
	String checkPassword(CustomUserDetails customUserDetails, Map<String, Object>  passwordDTO);
	
	void changePassword(CustomUserDetails customUserDetails, String new_password);
	
	PageDTO getPageDTO( String table, String table_id ,int nowpage , CustomUserDetails customUserDetails);

	List<AllDTO> getPageList(String table, PageDTO pageDTO, CustomUserDetails customUserDetails);


	PageDTO getDealPageDTO(int nowpage, CustomUserDetails customUserDetails , String d_type);
	
	List<Deal_viewDTO> getDealPageList( CustomUserDetails customUserDetails, String d_type, PageDTO pageDTO);
	
	int getPoint(CustomUserDetails customUserDetails);

	void putPoint(PointDTO pointDTO);
	
	List<Deal_viewDTO> getSoldList(CustomUserDetails customUserDetails);

	int getAvgScore(CustomUserDetails customUserDetails);

	void deleteWish(int wish_id);
	
	
	List<GoodsDTO> getListKeywordGoods(CustomUserDetails customUserDetails );
	
	List<KeywordVO> getListKeyword(CustomUserDetails customUserDetails );
	
	boolean is_exist_Keyword(CustomUserDetails customUserDetails, String keyword);
	
	int insertKeyword(CustomUserDetails customUserDetails, String keyword);
	
	int deleteKeyword(int key_id);
	





	


	

	

	


}