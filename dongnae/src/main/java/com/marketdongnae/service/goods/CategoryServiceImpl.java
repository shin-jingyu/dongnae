package com.marketdongnae.service.goods;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.marketdongnae.mapper.goods.CategoryMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryMapper mapper;
	
	@Override
	public Map<String, Object> getCategoryData() {
		// TODO Auto-generated method stub
		return null;
	}

}
