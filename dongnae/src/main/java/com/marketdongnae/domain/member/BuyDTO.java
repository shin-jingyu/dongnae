package com.marketdongnae.domain.member;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class BuyDTO {
	private int b_id ;
	private int m_number ;
	private int s_m_number; 
	private Timestamp b_regdate;
	private int g_id;
	private int g_price	;
	private String g_name;
	
}
