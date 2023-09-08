package com.marketdongnae.domain.chatting;


import java.sql.Timestamp;

import lombok.Data;

@Data
public class ChatRoom {
	private String roomId;        // 방 번호
    
    private String userEmail;    // 사용자 이메일
    private String userName;    // 사용자 이름
    
    private String masterEmail; // 상대방 이메일
    private String masterName;    // 상대방 이름
    
}
