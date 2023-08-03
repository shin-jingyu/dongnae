package com.marketdongnae.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.marketdongnae.domain.TestDTO;
import com.marketdongnae.mapper.MemberMapper;
import com.marketdongnae.security.CustomUserDetails;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	MemberTestDTO memberTestDTO;
	
	@Override
	public List<MemberTestDTO> getList(int page, String field, String query) {
		List<MemberTestDTO> list = new ArrayList<MemberTestDTO>();
		MemberTestDTO mem = new MemberTestDTO("ㅁ", 1);
		list.add(mem);
		return list;
	}


}