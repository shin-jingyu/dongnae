package com.marketdongnae.service.goods;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marketdongnae.domain.goods.GoodsDTO;
import com.marketdongnae.mapper.goods.GoodsMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class GoodsServiceImpl implements GoodsService {

	private final GoodsMapper goodsMapper;
	
	@Override
	public List<GoodsDTO> getList() {
		// TODO Auto-generated method stub
		
		return goodsMapper.getList();
	}

	@Override
	public void insertGoods(GoodsDTO goodsDTO) {
		// TODO Auto-generated method stub
		log.info(goodsDTO);
		goodsMapper.insertGoods(goodsDTO);
	}
	
	

}
