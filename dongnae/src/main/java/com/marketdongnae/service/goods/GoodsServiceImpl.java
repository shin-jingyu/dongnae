package com.marketdongnae.service.goods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.marketdongnae.domain.goods.GoodsDTO;
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
	public void updateGoods(GoodsDTO goodsDTO) {
		// TODO Auto-generated method stub
		goodsMapper.updateGoods(goodsDTO);
	}
	
	@Override
	public void insertGoods(GoodsDTO goodsDTO) {
		// TODO Auto-generated method stub
		goodsMapper.insertGoods(goodsDTO);
	}

}
