package com.marketdongnae.dao.member;

import com.marketdongnae.security.CustomUserDetails;

public interface memberDAO {

	public CustomUserDetails readMember(String userid);
	
}
