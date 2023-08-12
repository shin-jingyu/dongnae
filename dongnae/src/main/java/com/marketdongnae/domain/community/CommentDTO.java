package com.marketdongnae.domain.community;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentDTO {
	private int com_id  ; 
	private String com_c ;
	private int m_number ;
	private int mu_id ;
	private Timestamp com_data;
}
