package com.marketdongnae.service.goods;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.marketdongnae.mapper.CategoryMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryMapper mapper;
	
	@Override
	public Map<String, Object> getCategoryData() {
		// TODO Auto-generated method stub
		
		Map<String, Object> categoryData = new HashMap<String, Object>();
		categoryData.put("category_1", mapper.getCategory1());
		categoryData.put("category_2", mapper.getCategory2());
		
		return categoryData;
	}

}
