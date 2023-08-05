package com.marketdongnae.service.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marketdongnae.domain.TestDTO;
import com.marketdongnae.domain.member.Deal_viewDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.PasswordDTO;
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
	public MemberDTO getMember(String m_id) {
		return memberMapper.getMember(m_id);
	}
	
	// 이렇게 set이 아니라 통째로 넣으려고 하면 안됨 
	// 그래서 일단은 dto를 받아서 set으로 했는데 개선필요!!@@
	@Override
	public MemberDTO getMember_DTO(String m_id, MemberDTO memberDTO) {
		MemberDTO md = memberMapper.getMember(m_id);
		memberDTO.setM_id(md.getM_id());
		memberDTO.setM_name(md.getM_name());
		memberDTO.setM_pwd(md.getM_pwd());
		memberDTO.setM_email(md.getM_email());
		memberDTO.setM_phone(md.getM_phone());
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
	public List<Deal_viewDTO> getDealList(String m_id) {
		MemberDTO member =  memberMapper.getMember(m_id);
		int m_number =  member.getM_number();
		List<Deal_viewDTO> dealList =  memberMapper.getDealList(m_number);
		return dealList;
	}
	
	@Override
	public List<Deal_viewDTO> getOnSaleList(String m_id) {
		MemberDTO member =  memberMapper.getMember(m_id);
		int m_number =  member.getM_number();
		List<Deal_viewDTO> onSaleList =  memberMapper.getOnSaleList(m_number);
		return onSaleList;
	}
	
	@Override
	public int getPoint(String m_id) {
		MemberDTO member =  memberMapper.getMember(m_id);
		return member.getM_point();
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
	public Integer changePassword(String m_id, PasswordDTO passwordDTO) {
		MemberDTO member = memberMapper.getMember(m_id);
		passwordDTO.setM_id(m_id);
		
		// 입력한 현재 비밀번호가 맞는지 확인
		String rawPwd =  passwordDTO.getCurrent_password();
		String encodedPwd = (String) member.getM_pwd();
		System.out.println("####rawPwd:"+ passwordEncoder.encode(rawPwd) );
		System.out.println("####encodedPwd:"+encodedPwd );
		if( !passwordEncoder.matches(rawPwd , encodedPwd) ) {
			passwordDTO.setMessage("wrongCurrent");
			return null;
		};

		// 새 비밀번호와 확인이 일치하는지 확인
		String newPwd = passwordDTO.getNew_password();
		String confirmPwd = passwordDTO.getNew_password_confirm();
		if( !newPwd.equals(confirmPwd) ) {
			passwordDTO.setMessage("WrongConfirm");
			return null;
			};
			
		// 새 비밀번호로 변경
		String newEncodePwd = passwordEncoder.encode(newPwd);
		passwordDTO.setNew_password(newEncodePwd);  
		passwordDTO.setMessage("success");
			
		Integer result = memberMapper.changePassword(passwordDTO);
		return result ;
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

	
}