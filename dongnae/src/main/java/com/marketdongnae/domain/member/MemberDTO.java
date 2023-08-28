package com.marketdongnae.domain.member;

import java.sql.Date;
import java.sql.Timestamp;

import com.marketdongnae.domain.goods.GoodsDTO;

import lombok.Data;
@Data
public class MemberDTO {

	private int m_number	;
	private String m_id		;
	private String m_pwd		;
	private String m_name		;
	private String m_email	;
	private String m_phone	;
	private int m_point	;
	private Date  m_regdate	;
	private int si_id		;
	private String m_auth		;

	private int do_id;
	private String m_pic;
	private String m_picpath;

}
