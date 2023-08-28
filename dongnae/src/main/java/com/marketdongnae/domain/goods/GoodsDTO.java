package com.marketdongnae.domain.goods;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class GoodsDTO {
	
	private int g_id;
	private int c2_id;
	private int m_number;
	private String g_name;
	private String g_text;
	private int g_price;
	private String g_pic01;
	private String g_pic02;
	private String g_pic03;
	private String g_picpath;
	private int g_like;
	private Timestamp g_regdate;
	private String g_status;
}
