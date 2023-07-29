package com.marketdongnae.mapper.goods;

import java.util.List;

import com.marketdongnae.domain.goods.GoodsDTO;

public interface GoodsMapper {

	List<GoodsDTO> getList();

	void insertGoods(GoodsDTO goodsDTO);

}
