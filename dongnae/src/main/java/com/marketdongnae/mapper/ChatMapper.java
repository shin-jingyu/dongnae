package com.marketdongnae.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.marketdongnae.domain.chatting.ChatRoom;
@Mapper
public interface ChatMapper {

	void createRoom(ChatRoom vo);

	ChatRoom selectRoom(ChatRoom roomVO);

}
