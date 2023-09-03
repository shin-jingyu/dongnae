package com.marketdongnae.service.chatting;

import org.springframework.stereotype.Service;

import com.marketdongnae.domain.chatting.ChatRoom;
import com.marketdongnae.mapper.ChatMapper;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ChattingServiceImpl  implements ChattingService {

	ChatMapper mapper;
	
	@Override
	public ChatRoom isRoom(ChatRoom roomVO) {
		// TODO Auto-generated method stub
		roomVO = mapper.selectRoom(roomVO);
		return roomVO;
	}

	@Override
	public void createRoom(ChatRoom roomVO) {
		// TODO Auto-generated method stub
		mapper.createRoom(roomVO);
	}
	
	
}
