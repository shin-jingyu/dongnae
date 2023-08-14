package com.marketdongnae.service.goods;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.marketdongnae.domain.goods.GoodsDTO;

public interface GoodsService {

	List<GoodsDTO> getGoodsList();
	
	Map<String, Object> getGoodsList(int m_number);

	void insertGoods(GoodsDTO goodsDTO);

	void updateGoods(GoodsDTO goodsDTO);

	public GoodsDTO getGoodsDetail(int g_id);



}
