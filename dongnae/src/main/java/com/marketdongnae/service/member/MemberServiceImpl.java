package com.marketdongnae.service.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marketdongnae.domain.TestDTO;
import com.marketdongnae.domain.member.BuyDTO;
import com.marketdongnae.domain.member.MemberDTO;
import com.marketdongnae.domain.member.SoldDTO;
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
	
	@Override
	public CustomUserDetails loginID(String m_id) {
		return memberMapper.loginID(m_id);
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
	public BuyDTO getBuy(String b_id) {
		return memberMapper.getBuy(b_id);
	}

	@Override
	public SoldDTO getSold(String s_id) {
		return memberMapper.getSold(s_id);
	}

	@Override
	public List<SoldDTO> getSoldList(int m_number) {
		return memberMapper.getSoldList(  m_number);
	}

	@Override
	public List<BuyDTO> getBuyList(int m_number) {
		return memberMapper.getBuyList( m_number);
	}

	@Override
	public Integer regist(MemberDTO memberDTO) {
		Integer result = memberMapper.regist(memberDTO);
		return result ;
	}

	@Override
	public Integer changePassword(Map<String, Object> map) {
		Integer result = memberMapper.changePassword(map);
		return result ;
	}


}