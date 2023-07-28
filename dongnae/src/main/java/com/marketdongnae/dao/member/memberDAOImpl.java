package com.marketdongnae.dao.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.marketdongnae.security.CustomUserDetails;

public class memberDAOImpl implements memberDAO {

	@Autowired
	SqlSessionTemplate sql;
	@Override
	public CustomUserDetails readMember(String userid) {
		// TODO Auto-generated method stub
		CustomUserDetails userDetails = new CustomUserDetails();
		sql.select(userid, userDetails, null);
		
		return userDetails;
	}
	
	
}
