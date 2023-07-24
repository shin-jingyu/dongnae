package com.marketdongnae.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketdongnae.domain.TestDTO;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	TestDTO testDTO;

	@Override
	public String insert(Map<String, Object> map) {
		if(testDTO.insert(map) == 1)
			return map.get("m_id").toString();
		return null;
	}

}
