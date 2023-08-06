package com.marketdongnae.controller;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.marketdongnae.service.goods.CategoryService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class CategoryControllerTests {

	
	@Autowired
	CategoryService servcie;
	
	@Test
	public void getCategoryTest() {
		
		Map<String, Object> maps = servcie.getCategoryData();

		 Set<String> keys = maps.keySet();

		    // 각 키에 대한 값을 조회하여 출력
		    for (String key : keys) {
		        Object value = maps.get(key);
		        System.out.println(key + " : " + value);
		    }
	}
}
