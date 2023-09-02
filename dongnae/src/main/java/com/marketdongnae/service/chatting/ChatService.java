package com.marketdongnae.service.chatting;

import java.util.List;

import com.marketdongnae.domain.chatting.ChatRoomVO;
import com.marketdongnae.domain.chatting.MessageVO;

public interface ChatService {
	public void createRoom(ChatRoomVO vo)throws Exception;
	public ChatRoomVO isRoom(ChatRoomVO vo)throws Exception;
	public void insertMessage(MessageVO vo)throws Exception;
	public String getPartner(ChatRoomVO vo)throws Exception;
	public String getName(String str)throws Exception;
	public List<MessageVO> getMessageList(String str)throws Exception;
	public List<ChatRoomVO> getRoomList(String str)throws Exception;
	public List<ChatRoomVO> getRoomList2(String str)throws Exception;
	public MessageVO getRecentMessage(String str)throws Exception;
	//public String isGetMessageList(String str)throws Exception;
	
	public String getTutorId(String str)throws Exception;
	public List<ChatRoomVO> getRoomListTutor(String str)throws Exception;
	
	public int getAllCount(String str);
}
