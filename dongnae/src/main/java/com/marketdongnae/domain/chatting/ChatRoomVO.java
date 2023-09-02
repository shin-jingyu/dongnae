package com.marketdongnae.domain.chatting;


import java.sql.Timestamp;

import lombok.Data;

@Data
public class ChatRoomVO {
	private int chatroom_id;
	private int buy_number;
	private int g_id;
	private Timestamp chat_regdate;
}
