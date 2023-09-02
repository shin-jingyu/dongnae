package com.marketdongnae.service.chatting;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marketdongnae.domain.chatting.ChatRoomVO;
import com.marketdongnae.domain.chatting.MessageVO;
import com.marketdongnae.mapper.ChatMapper;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {
	
	private final ChatMapper chatMapper;

	

}
