package com.marketdongnae.service.goods;

import java.util.List;
import java.util.Map;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.domain.goods.SearchDTO;
import com.marketdongnae.domain.goods.WishGoodsDTO;

public interface GoodsService {

	List<GoodsDTO> getGoodsList();
	
	List<GoodsDTO> getSearchGoods(SearchDTO search);
	
	Map<String, Object> getGoodsList(int m_number);

	void insertGoods(GoodsDTO goodsDTO);

	void updateGoods(GoodsDTO goodsDTO);

	public GoodsDTO getGoodsDetail(int g_id);
	
	// 상품 좋아요 
	void goodsWish(WishGoodsDTO wish);
	//상품 좋아요 확인
	boolean checkWishGoods(WishGoodsDTO wish);
	//상품 좋아요 갯수 확인
	int getCountWishGoods(int g_id);
	// 멤버페이지 판매중 상품
	List<GoodsDTO> getGoodsListOnSaleList(int m_number);



}
