package com.marketdongnae.domain.chatting;

import java.sql.Timestamp;

import com.google.gson.Gson;

import lombok.Data;
@Data
public class MessageVO {
	private int message_id;
	private int chatroom_id;
	private int buyer_M_Number;
	private int seller_M_Number;
	private int g_id;
	private String chat_message;
	private Timestamp message_date;
	
	public static MessageVO convertMessage(String source) {
		MessageVO message = new MessageVO();
		Gson gson = new Gson();
		message = gson.fromJson(source,  MessageVO.class);
		return message;
	}
}
