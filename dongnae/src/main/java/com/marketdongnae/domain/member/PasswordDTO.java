package com.marketdongnae.domain.member;

import java.sql.Date;

import lombok.Data;

@Data
public class PasswordDTO {
	private int m_number		;
	private String current_password  ;
	private String new_password  ;
	private String  new_password_confirm ;
	private String message;
}
