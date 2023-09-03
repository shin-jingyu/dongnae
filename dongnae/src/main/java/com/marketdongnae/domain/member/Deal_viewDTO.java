package com.marketdongnae.domain.member;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class Deal_viewDTO  {
	private int d_id	;	
	private String	 m_id 	;
	private String d_type ;
	private String	 d_m_id ;
	private Timestamp d_regdate  ;
	private int g_id ;
	private int g_price ;
	private String g_name ;
	private int d_score ;
	private String d_review ;
	private String g_picpath ;
	private String g_pic01 ;
	
	private int avgScore ;  // ?

}
