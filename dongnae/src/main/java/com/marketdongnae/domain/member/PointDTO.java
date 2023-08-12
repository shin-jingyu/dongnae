package com.marketdongnae.domain.member;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class PointDTO {
	private int p_id	;	
	private String	 m_id 	;
	private String p_type ;
	private int p_price ;
	private Timestamp p_regdate  ;
	
}
