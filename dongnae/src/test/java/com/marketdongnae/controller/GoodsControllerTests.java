package com.marketdongnae.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.goods.GoodsPictureDTO;
import com.marketdongnae.service.goods.GoodsService;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class GoodsControllerTests {
	
	@Autowired
	private GoodsService service;
	
	@Test
	public void getList() {
		service.getList();
		assertNotNull(service.getList());
	}
	
	@Test
	public void uploadTest() {
		GoodsDTO dto = new GoodsDTO();
		GoodsPictureDTO picture = new GoodsPictureDTO();
		
		picture.setG_pic01("testPicture1");
		picture.setG_pic02("testPicture2");
		picture.setG_pic03("testPicture3");
		
		dto.setG_name("testName");
		dto.setG_price(10000);
		dto.setGoodsPictureDTO(picture);
		
		service.insertGoods(dto);
		
	}
	
}
