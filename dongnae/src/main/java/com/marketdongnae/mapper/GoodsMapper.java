package com.marketdongnae.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.marketdongnae.domain.goods.GoodsDTO;
@Mapper
public interface GoodsMapper {

	List<GoodsDTO> getGoodsList();
	
	List<GoodsDTO> getGoodsListByMemberNumber(int m_number);

	void insertGoods(GoodsDTO goodsDTO);

	void updateGoods(GoodsDTO goodsDTO);
	
	void deleteGoods(GoodsDTO goodsDTO);

	GoodsDTO getGoodsDetail(int g_id);


}
