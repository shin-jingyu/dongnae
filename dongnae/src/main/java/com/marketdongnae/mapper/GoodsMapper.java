package com.marketdongnae.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.goods.SearchDTO;
import com.marketdongnae.domain.goods.WishGoodsDTO;

@Mapper
public interface GoodsMapper {

	List<GoodsDTO> getGoodsList();

	List<GoodsDTO> getSearchGoods(SearchDTO search);

	List<GoodsDTO> getGoodsListByMemberNumber(int m_number);

	void insertGoods(GoodsDTO goodsDTO);

	void updateGoods(GoodsDTO goodsDTO);

	void deleteGoods(GoodsDTO goodsDTO);

	GoodsDTO getGoodsDetail(int g_id);

	int checkWishGoods(WishGoodsDTO wish);

	void deleteWishGoods(WishGoodsDTO wish);

	void wishGoods(WishGoodsDTO wish);

	int countWishGoodsByG_id(int g_id);

	List<GoodsDTO> getGoodsListOnSaleByMemberNumber(int m_number);

	List<GoodsDTO> getGoodsListSoldByMemberNumber(int m_number);

	List<GoodsDTO> getGoodsListBuyByMemberNumber(int m_number);

}
