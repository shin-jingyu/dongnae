package com.marketdongnae.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class GoodsMapperTests {

	@Autowired
	private GoodsMapper mapper;
	
	@Test
	public void getGoodsDetailTest() {
		
		
		System.out.println(mapper.getGoodsDetail(4));
	}
	
	@Test
	public void getMemberGoodsTest() {
		System.out.println(mapper.getGoodsListByMemberNumber(1));
	}
}
