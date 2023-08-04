package com.marketdongnae.domain.community;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class communityDetailDTO {
	private int mu_id ;
	private String mu_name ; 
	private String mu_detail ;
	private String mu_i1 ;
	private String mu_i2 ;
	private String mu_i3 ; 
	private int mu_c ; 
	private Timestamp mu_data ;
	private int ca_id ; 
	private int m_number ;
}
