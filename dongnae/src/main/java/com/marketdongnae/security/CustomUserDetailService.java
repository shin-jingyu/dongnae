package com.marketdongnae.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.marketdongnae.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String m_id) throws UsernameNotFoundException {
		log.warn("Load User By UserName : " + m_id);
		
		//userName means userId
		
		CustomUserDetails member = memberMapper.select(m_id);
		if(member==null) {
			throw new UsernameNotFoundException(m_id);
		}
		log.warn("queried by member mapper : " + m_id);
		
		
		return member;
	}

	
}
