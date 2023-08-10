package com.marketdongnae.domain.member;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Point_viewDTO {
	private int d_id	;	
	private int	 m_number 	;
	private String d_type ;
	private Timestamp d_regdate  ;
	private int g_price ;
	
}
