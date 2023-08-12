package com.marketdongnae.service.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marketdongnae.domain.member.Deal_viewDTO;
import com.marketdongnae.domain.member.Do_areaDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PasswordDTO;
import com.marketdongnae.domain.member.PointDTO;
import com.marketdongnae.domain.member.Si_areaDTO;
import com.marketdongnae.domain.member.Wish_viewDTO;
import com.marketdongnae.mapper.GoodsMapper;
import com.marketdongnae.mapper.MemberMapper;
import com.marketdongnae.security.CustomUserDetails;
import com.marketdongnae.service.goods.GoodsServiceImpl;

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
	public MemberDTO getMember(String m_id) {
		return memberMapper.getMember(m_id);
	}
	

	@Override
	public Integer updateMember(MemberDTO memberDTO) {
		Integer result = memberMapper.updateMember(memberDTO);
		return result ;
	}


	@Override
	public List<Deal_viewDTO> getSoldList(String m_id) {
		MemberDTO member =  memberMapper.getMember(m_id);
		int m_number =  member.getM_number();
		List<Deal_viewDTO> soldlist =  memberMapper.getSoldList( m_number);
		return soldlist;
	}
	
	
	@Override
	public List<Deal_viewDTO> getBuyList(String m_id) {
		MemberDTO member =  memberMapper.getMember(m_id);
		int m_number =  member.getM_number();
		List<Deal_viewDTO> buylist =  memberMapper.getBuyList(m_number);
		return buylist;
	}

	@Override
	public int getAvgScore(String m_id) {
		MemberDTO member =  memberMapper.getMember(m_id);
		int m_number =  member.getM_number();
		List<Deal_viewDTO> soldlist =  memberMapper.getSoldList( m_number);
		int sum = 0 ;
		for (Deal_viewDTO sold : soldlist) {
			sum += (int) sold.getD_score();
		}
		int avgScore = (int) Math.ceil(sum/ soldlist.size()) ;
		return avgScore;
	}
	

	
	@Override
	public List<Deal_viewDTO> getOnSaleList(String m_id) {
		MemberDTO member =  memberMapper.getMember(m_id);
		int m_number =  member.getM_number();
		List<Deal_viewDTO> onSaleList =  memberMapper.getOnSaleList(m_number);
		return onSaleList;
	}


	@Override
	public Integer regist(MemberDTO memberDTO) {
		String pwd1 = memberDTO.getM_pwd();
		String pwd2 = passwordEncoder.encode(pwd1);
		memberDTO.setM_pwd(pwd2);
		System.out.println("pwd2"+pwd2);
		Integer result = memberMapper.regist(memberDTO);
		return result ;
	}

	@Override
	public String changePassword(String m_id, PasswordDTO passwordDTO) {
		MemberDTO member = memberMapper.getMember(m_id);
		passwordDTO.setM_id(m_id);
		
		// 입력한 현재 비밀번호가 맞는지 확인
		String rawPwd =  passwordDTO.getCurrent_password();
		String encodedPwd = (String) member.getM_pwd();
		if( !passwordEncoder.matches(rawPwd , encodedPwd) ) {
			passwordDTO.setMessage("wrongCurrent");
			return "fail";
		};

		// 새 비밀번호와 확인이 일치하는지 확인
		String newPwd = passwordDTO.getNew_password();
		String confirmPwd = passwordDTO.getNew_password_confirm();
		if( !newPwd.equals(confirmPwd) ) {
			passwordDTO.setMessage("WrongConfirm");
			return "fail";
			};
			
		// 새 비밀번호로 변경
		String newEncodePwd = passwordEncoder.encode(newPwd);
		passwordDTO.setNew_password(newEncodePwd);  
		passwordDTO.setMessage("success");
			
		memberMapper.changePassword(passwordDTO);
		return "success" ;
	}

	@Override
	public List<Wish_viewDTO> getWish_viewList(String m_id) {
		MemberDTO member =  memberMapper.getMember(m_id);
		int m_number =  member.getM_number();
		List<Wish_viewDTO> wish_viewList =  memberMapper.getWish_viewList(m_number);
		return wish_viewList;
	}

	@Override
	public void deleteWish(int wish_id) {
		memberMapper.deleteWish( wish_id);
		
	}

	@Override
	public String getSi_area(String m_id) {
		MemberDTO memberDTO = memberMapper.getMember(m_id);
		int si_id = memberDTO.getSi_id();
		Si_areaDTO si_areaDTO  = memberMapper.getSi_area(si_id);
		String si_area = si_areaDTO.getSi_area();
		return si_area;
	}
	
	
	@Override
	public int getPoint(String m_id) {
		MemberDTO member =  memberMapper.getMember(m_id);
		return member.getM_point();
	}
	
	@Override
	public List<PointDTO> getPointList(String m_id) {
		List<PointDTO> pointlist =  memberMapper.getPointList(m_id);
		return pointlist;
	}
	
	@Override
	public void putPoint(PointDTO pointDTO) {
		String m_id = pointDTO.getM_id();
		MemberDTO memberDTO = memberMapper.getMember(m_id);
		memberDTO.setM_point(memberDTO.getM_point()+pointDTO.getP_price());
		memberMapper.updatePoint(memberDTO);
		memberMapper.insertPointList( pointDTO );
	}


	@Override
	public String checkId(String checkId) {
		String msg ; 
		MemberDTO memberDTO = memberMapper.getMember(checkId);
		if(memberDTO==null)
			msg = "ok";
		else 
			msg = "duplicated";
		return msg;
	}


}