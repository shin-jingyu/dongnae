package com.marketdongnae.domain.chatting;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ChatRoom {
	private int chatroomId;
    private int buyNumber;
    private int gId;
    private Timestamp chatRegdate;
    private List<MessageVO> messages = new ArrayList<>();


    public void addMessage(MessageVO message) {
        messages.add(message);
    }

    public List<MessageVO> getMessages() {
        return messages;
    }
}
