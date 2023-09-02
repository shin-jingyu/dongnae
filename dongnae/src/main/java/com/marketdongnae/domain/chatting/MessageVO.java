package com.marketdongnae.domain.chatting;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class MessageVO {
	private int message_id;
	private int chatroom_id;
	private int m_number;
	private String chat_message;
	private Timestamp message_date;
	
}
