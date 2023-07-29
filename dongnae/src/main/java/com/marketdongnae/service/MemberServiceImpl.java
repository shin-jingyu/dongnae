package com.marketdongnae.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketdongnae.domain.TestDTO;
import com.marketdongnae.mapper.MemberMapper;
import com.marketdongnae.mapper.TestMapper;
import com.marketdongnae.security.CustomUserDetails;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;

	@Override
	public Map<String, Object> getMember(String m_id) {
		return memberMapper.getMember(m_id);
	}

	@Override
	public Integer updateMember(Map<String, Object> map) {
		Integer result = memberMapper.updateMember(map);
		return result ;
	}

	@Override
	public Map<String, Object> getBuy(String b_id) {
		return memberMapper.getBuy(b_id);
	}

	@Override
	public Map<String, Object> getSold(String s_id) {
		return memberMapper.getSold(s_id);
	}

	@Override
	public List<Map<String, Object>> getReviewList(int m_number) {
		return memberMapper.getReviewList( m_number);
	}
}