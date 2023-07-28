package com.marketdongnae.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.marketdongnae.dao.member.memberDAO;
import com.marketdongnae.dao.member.memberMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private memberDAO memberDAO;
	
	@Autowired
	private memberMapper member;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.warn("Load User By UserName : " + username);
		
		//userName means userId
		
		CustomUserDetails member = memberDAO.readMember(username);
		CustomUserDetails member = member.readMember(username);
		if(member==null) {
			throw new UsernameNotFoundException(username);
		}
		log.warn("queried by member mapper : " + member);
		
		
		return member;
	}

	
}
