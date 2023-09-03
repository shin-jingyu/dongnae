package com.marketdongnae.service.chatting;

import com.marketdongnae.domain.chatting.ChatRoom;

public interface ChattingService {

	ChatRoom isRoom(ChatRoom roomVO);

	void createRoom(ChatRoom roomVO);
	
}
