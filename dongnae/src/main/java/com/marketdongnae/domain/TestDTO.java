package com.marketdongnae.domain;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDTO {
	@Autowired
	SqlSessionTemplate sqlsessionTemplate;

	public int insert(Map<String, Object> map) {
		return sqlsessionTemplate.insert("Test.insert", map) ;
	}
}