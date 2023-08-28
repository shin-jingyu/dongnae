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
		log.warn("2. Load User By UserName(m_id) : " + m_id);
		
		CustomUserDetails member = memberMapper.loginID(m_id);
		if(member==null) {
			throw new UsernameNotFoundException(m_id);
		}
		log.warn("3. queried by member mapper : " + m_id);
		
		return member ;
	}
}
