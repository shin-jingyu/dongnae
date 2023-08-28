package com.marketdongnae.service.goods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.goods.SearchDTO;
import com.marketdongnae.domain.goods.WishGoodsDTO;
import com.marketdongnae.mapper.GoodsMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class GoodsServiceImpl implements GoodsService {

	private final GoodsMapper goodsMapper;
	
	
	
	@Override
	public List<GoodsDTO> getGoodsList() {
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsList();
	}
	
	@Override
	public Map<String, Object> getGoodsList(int m_number) {
		// TODO Auto-generated method stub
		Map<String, Object> maps = new HashMap<String, Object>();
//		List<GoodsDTO> list = goodsMapper.getGoodsListByMemberNumber(m_number);
		maps.put("memberGoods", goodsMapper.getGoodsListByMemberNumber(m_number));
		return maps;
	}
	
	@Override
	public List<GoodsDTO> getSearchGoods(SearchDTO search) {
		// TODO Auto-generated method stub
		return goodsMapper.getSearchGoods(search);
	}
	
	@Override
	public void updateGoods(GoodsDTO goodsDTO) {
		// TODO Auto-generated method stub
		goodsMapper.updateGoods(goodsDTO);
	}
	
	@Override
	public void insertGoods(GoodsDTO goodsDTO) {
		// TODO Auto-generated method stub
		goodsMapper.insertGoods(goodsDTO);
	}

	@Override
	public GoodsDTO getGoodsDetail(int g_id) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsDetail(g_id);
	}

	@Override
	public void goodsWish(WishGoodsDTO wish) {
		// TODO Auto-generated method stub
		if(goodsMapper.checkWishGoods(wish) > 0) {
			goodsMapper.deleteWishGoods(wish);
		}else {
			goodsMapper.wishGoods(wish);
		}
	}

	@Override
	public boolean checkWishGoods(WishGoodsDTO wish) {
		// TODO Auto-generated method stub
		return goodsMapper.checkWishGoods(wish) > 0;
	}

	@Override
	public int getCountWishGoods(int g_id) {
		// TODO Auto-generated method stub
		return goodsMapper.countWishGoodsByG_id(g_id);
	}

	@Override
	public List<GoodsDTO> getGoodsListOnSaleList(int m_number) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoodsListOnSaleByMemberNumber(m_number);
	}
	
	

	


	
	
	

}
