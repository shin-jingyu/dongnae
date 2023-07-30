package com.marketdongnae.domain.goods;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class GoodsDTO {
	
	private int g_id;
	private int c2_id;
	private int m_number;
	private String g_name;
	private int g_price;
	private Timestamp g_regdate;
	private int g_like;
	private String filePath;
	private String g_pic01;
	private String g_pic02;
	private String g_pic03;
	
}
