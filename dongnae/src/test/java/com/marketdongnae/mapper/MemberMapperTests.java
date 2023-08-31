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
import com.marketdongnae.domain.member.KeywordVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
					   "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberMapperTests {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	public void getListKeywordGoods(){
		List<KeywordVO> keywordList = memberMapper.getListKeyword(22);
		System.out.println(keywordList.toString());
		System.out.println(0000000);
		List<GoodsDTO> goodsList  = memberMapper.getListKeywordGoods(keywordList);
		System.out.println(goodsList.toString());
	}
	
}
