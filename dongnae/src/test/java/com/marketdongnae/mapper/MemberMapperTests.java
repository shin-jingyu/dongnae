package com.marketdongnae.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.goods.SearchDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberMapperTests {

	@Autowired
	private GoodsMapper mapper;
	//상품 번호별 상세 가져오기
//	@Test
	public void getGoodsDetailTest() {
		System.out.println(mapper.getGoodsDetail(4));
	}
	//회원의 상품 가져오기
//	@Test
	public void getMemberGoodsTest() {
		System.out.println(mapper.getGoodsListByMemberNumber(1));
	}
	
	//검색기능
	@Test
	public void searchGoodsTests() {
		SearchDTO search = new SearchDTO();
		search.setKeyword("샤");
		List<GoodsDTO> list =  mapper.getSearchGoods(search);
		list.forEach(x->System.out.println(x));
		assertNotNull(list);
	}
	
}
