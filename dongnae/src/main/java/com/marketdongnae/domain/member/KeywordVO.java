package com.marketdongnae.domain.member;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class KeywordVO {
	private int key_id;
	private int m_number;
	private String keyword;
	private Timestamp key_regdate ;
}
