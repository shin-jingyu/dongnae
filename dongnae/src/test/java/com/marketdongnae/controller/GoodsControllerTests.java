package com.marketdongnae.controller;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.service.goods.GoodsService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class GoodsControllerTests {
	
	@Autowired
	private GoodsService service;
	
	@Test
	public void getList() {
		List<GoodsDTO> list = service.getList();
		list.forEach(x->log.info(x));
		assertNotNull(service.getList());
	}
	
	@Test
	public void insertTest() {
		GoodsDTO dto = new GoodsDTO();
		
		dto.setG_pic01("testPicture1");
		dto.setG_pic02("testPicture2");
		dto.setG_pic03("testPicture3");
		dto.setG_name("testName");
		dto.setG_price(10000);
		service.insertGoods(dto);
	}
	
	@Test
	public void updateTest() {
		GoodsDTO dto = new GoodsDTO();
		
		dto.setG_id(1);
		dto.setG_name("updateName22");
		service.updateGoods(dto);
	}
	
}
