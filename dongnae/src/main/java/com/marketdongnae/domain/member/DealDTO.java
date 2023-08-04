package com.marketdongnae.domain.member;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class DealDTO {
	private int d_id	;	
	private int	 m_number 	;
	private String d_type ;
	private int	 d_m_number ;
	private Timestamp d_regdate  ;
	private int g_id ;
	private int g_price ;
	private String g_name ;
	private int d_score ;
	private String d_review ;
	
	private int avgScore ; 

	private List<DealDTO> dealDTOList;
	
	
}
