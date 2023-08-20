package com.marketdongnae.service.member;

import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marketdongnae.domain.member.Deal_viewDTO;
import com.marketdongnae.domain.member.Do_areaDTO;
import com.marketdongnae.domain.member.AllDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PageDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.domain.member.PointDTO;
import com.marketdongnae.domain.member.Si_areaDTO;
import com.marketdongnae.mapper.MemberMapper;
import com.marketdongnae.security.CustomUserDetails;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class MemberServiceImpl implements MemberService {
	private final MemberMapper memberMapper;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public CustomUserDetails loginID(String m_id) {
		return memberMapper.loginID(m_id);
	}
	

	@Override
	public List<Do_areaDTO> getDoList() {
		return memberMapper.getDoList();
	}
	

	@Override
	public List<Si_areaDTO> getSiList(int do_id) {
		return  memberMapper.getSiList( do_id);
	}

	
	@Override
	public MemberDTO getMember(CustomUserDetails customUserDetails) {
		return memberMapper.getMember((int) customUserDetails.getM_number());
	}
	

	@Override
	public Integer updateMember(MemberDTO memberDTO) {
		Integer result = memberMapper.updateMember(memberDTO);
		return result ;
	}
	
	@Override
	public String getSi_area(CustomUserDetails customUserDetails) {
		MemberDTO memberDTO = memberMapper.getMember((int) customUserDetails.getM_number());
		int si_id = memberDTO.getSi_id();
		Si_areaDTO si_areaDTO  = memberMapper.getSi_area(si_id);
		String si_area = si_areaDTO.getSi_area();
		return si_area;
	}

	

	@Override
	public Integer regist(MemberDTO memberDTO) {
		String pwd1 = memberDTO.getM_pwd();
		String pwd2 = passwordEncoder.encode(pwd1);
		memberDTO.setM_pwd(pwd2);
		Integer result = memberMapper.regist(memberDTO);
		return result ;
	}
	

	
	@Override
	public String checkId(String checkId) {
		String msg ; 
		MemberDTO memberDTO = memberMapper.checkId(checkId);
		if(memberDTO==null)
			msg = "ok";
		else 
			msg = "duplicated";
		return msg;
	}
	

	@Override
	public String checkPassword(CustomUserDetails customUserDetails, Map<String, Object> passwordDTO) {
		int m_number  = customUserDetails.getM_number();
		String msg = "";
		
		// 입력한 현재 비밀번호가 맞는지 확인
		String rawPwd = (String) passwordDTO.get("current_password");
		String encodedPwd = customUserDetails.getPassword();
		//		String encodedPwd = (String) member.getM_pwd();
		if( !passwordEncoder.matches(rawPwd , encodedPwd) ) {
			// passwordDTO.setMessage("wrongCurrent");
			msg = "wrongCurrent";
		};

		// 새 비밀번호와 확인이 일치하는지 확인
		String newPwd = (String) passwordDTO.get("new_password");
		String confirmPwd =  (String)  passwordDTO.get("new_password_confirm");
		if( !newPwd.equals(confirmPwd) ) {
			// passwordDTO.setMessage("WrongConfirm");
			msg ="WrongConfirm";
			};
			
		return msg ; 
	}

	@Override
	public void changePassword(CustomUserDetails customUserDetails, String new_password) {
		int m_number  = customUserDetails.getM_number();
		// 새 비밀번호로 변경
		String newEncodePwd = passwordEncoder.encode(new_password);
		// passwordDTO.setNew_password(newEncodePwd);  
		// passwordDTO.setMessage("success");
			
		memberMapper.changePassword(m_number,newEncodePwd);
	}




	
	@Override
	public PageDTO getPageDTO( String table, String table_id ,int nowpage , CustomUserDetails customUserDetails) {
		int m_number = (int) customUserDetails.getM_number() ;
		int ListCnt = memberMapper.getListCnt( m_number , table_id, table );
		
		PageDTO pageDTO = new PageDTO();
			pageDTO.setNowpage(nowpage);
			pageDTO.setCount(ListCnt);
		return pageDTO;
	}

	@Override
	public List<AllDTO> getPageList(String table, PageDTO pageDTO, CustomUserDetails customUserDetails) {
		int m_number = (int) customUserDetails.getM_number() ;
		int displayStart = pageDTO.getDisplayStart();
		return memberMapper.getPageList(m_number, table, displayStart);
	}
	

	@Override
	public PageDTO getDealPageDTO(int nowpage ,CustomUserDetails customUserDetails, String d_type) {
		int m_number = (int) customUserDetails.getM_number() ; 
		int dealCnt = memberMapper.getDealCnt(m_number, d_type);
		PageDTO pageDTO = new PageDTO();
			pageDTO.setNowpage(nowpage);
			pageDTO.setCount(dealCnt);
		return pageDTO;
	}
	
	@Override
	public List<Deal_viewDTO> getDealPageList(CustomUserDetails customUserDetails, String d_type,PageDTO pageDTO) {
		int m_number = (int) customUserDetails.getM_number() ; 
		int displayStart = pageDTO.getDisplayStart();
		return memberMapper.getDealPageList(m_number, d_type, displayStart);
	}

	
	
	
	@Override
	public List<Deal_viewDTO> getSoldList(CustomUserDetails customUserDetails) {
		List<Deal_viewDTO> soldlist =  memberMapper.getSoldList( (int) customUserDetails.getM_number());
		return soldlist;
	}


	@Override
	public int getAvgScore(CustomUserDetails customUserDetails) {
		List<Deal_viewDTO> soldlist =  memberMapper.getSoldList( (int) customUserDetails.getM_number());
		int sum = 0 ;
		int avgScore = 0 ;
		for (Deal_viewDTO sold : soldlist) {
			sum += (int) sold.getD_score();
		}
		if(!soldlist.isEmpty())
			avgScore = (int) Math.ceil(sum/ soldlist.size()) ;
		else
			avgScore = 0 ;
		
		return avgScore;
	}
	
	
	@Override
	public int getPoint(CustomUserDetails customUserDetails) {
		MemberDTO member =  memberMapper.getMember((int) customUserDetails.getM_number());
		return member.getM_point();
	}
	
	
	@Override
	public void putPoint(PointDTO pointDTO) {
		int m_number = pointDTO.getM_number();
		MemberDTO memberDTO = memberMapper.getMember(m_number);
		memberDTO.setM_point(memberDTO.getM_point()+pointDTO.getP_price());
		memberMapper.updatePoint(memberDTO);
		memberMapper.insertPointList( pointDTO );
	}
	

	@Override
	public void deleteWish(int wish_id) {
		memberMapper.deleteWish( wish_id);
		
	}





}