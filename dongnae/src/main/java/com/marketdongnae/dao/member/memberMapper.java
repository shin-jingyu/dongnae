package com.marketdongnae.dao.member;

import com.marketdongnae.security.CustomUserDetails;

public interface memberMapper {
	
	public CustomUserDetails readMember(String userid);
	
}
