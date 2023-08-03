package com.marketdongnae.controller.api;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.marketdongnae.security.CustomUserDetails;

public interface TestService {
	

	List <MemberTestDTO> getList( int page, String field, String query);

}