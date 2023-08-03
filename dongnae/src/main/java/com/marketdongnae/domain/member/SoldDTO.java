package com.marketdongnae.domain.member;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class SoldDTO {
	private int s_id ;
	private int m_number ;
	private int b_m_number; 
	private int s_score;
	private String s_review;
	private Timestamp s_regdate;
	private int g_id;
	private int g_price	;
	private String g_name;
	
}
