package com.marketdongnae.domain.member;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AllDTO {
	private int	 m_number 	;
	
	// PointDTO
	private int p_id	;	
	private String p_type ;
	private int p_price ;
	private Timestamp p_regdate  ;
	
	// Wish_viewDTO
	private int wish_id	;	
	private int g_id ;
	private String	 g_name ;
	private int g_price ;
	
}
