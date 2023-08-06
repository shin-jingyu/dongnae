package com.marketdongnae.mapper;

import java.util.List;

import com.marketdongnae.domain.category.Category_Goods_1;
import com.marketdongnae.domain.category.Category_Goods_2;

public interface CategoryMapper {

	List<Category_Goods_1> getCategory1();
	List<Category_Goods_2> getCategory2();
	
	
}
