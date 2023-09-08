package com.marketdongnae.domain.chatting;

import lombok.Data;
@Data
public class ChatMessage {
	private String roomId;            // 방 번호
    private String messageId;        // 메세지 번호
    private String message;            // 메세지 내용
    private String name;            // 보낸이 이름
	
}
