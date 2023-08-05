package com.marketdongnae.domain.member;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class Wish_viewDTO  {
	private int wish_id	;	
	private int	 m_number 	;
	private int g_id ;
	private String	 g_name ;
	private int g_price ;

	private List<Wish_viewDTO> Wish_viewDTOList;
	
	
}
