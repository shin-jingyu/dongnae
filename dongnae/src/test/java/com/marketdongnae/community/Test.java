package com.marketdongnae.community;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.marketdongnae.controller.GoodsControllerTests;
import com.marketdongnae.database.DataSourceTests;
import com.marketdongnae.domain.community.CommunityDTO;
import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.mapper.CommunityMapper;
import com.marketdongnae.service.CommunityService;
import com.marketdongnae.service.goods.GoodsService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	   "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class Test {
	
	@Autowired
	private CommunityService service;
	
	@org.junit.Test
	public void getList() {
		List<CommunityDTO> list = service.getCommunity();
		list.forEach(x->log.info(x));
		assertNotNull(service.getCommunity());
	}
	 

}
