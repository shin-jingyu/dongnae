package com.marketdongnae.domain.community;

import java.sql.Time;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class CommunityAllDTO {
	//Community 
	private int mu_id;
	private String ca_l;
	private String si_area ; 
	private String mu_name ;
	private String mu_detail;
	private int m_number;
	private String m_id ;
	private Timestamp mu_data; 
	private int mu_c ; 
	private int heart ; 
	private int comment ;

	
}
