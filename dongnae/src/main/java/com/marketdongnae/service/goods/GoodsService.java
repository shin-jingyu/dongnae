package com.marketdongnae.service.goods;

import java.util.List;
import java.util.Map;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.goods.SearchDTO;

public interface GoodsService {

	List<GoodsDTO> getGoodsList();
	
	List<GoodsDTO> getSearchGoods(SearchDTO search);
	
	Map<String, Object> getGoodsList(int m_number);

	void insertGoods(GoodsDTO goodsDTO);

	void updateGoods(GoodsDTO goodsDTO);

	public GoodsDTO getGoodsDetail(int g_id);




}
