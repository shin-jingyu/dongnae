package com.marketdongnae.domain.chatting;


import java.sql.Timestamp;

import lombok.Data;

@Data
public class ChatRoom {
	private int chatroom_id;
    private int buyer_M_Number;
    private int seller_M_Number;
    private int g_id;
    private Timestamp chatRegdate;
}
