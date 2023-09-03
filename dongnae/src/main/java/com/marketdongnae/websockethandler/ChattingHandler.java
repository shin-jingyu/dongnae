package com.marketdongnae.websockethandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.marketdongnae.domain.chatting.ChatRoom;
import com.marketdongnae.domain.chatting.MessageVO;
import com.marketdongnae.service.chatting.ChattingService;

import lombok.extern.log4j.Log4j;



@Log4j
public class ChattingHandler extends TextWebSocketHandler {

	
	@Autowired
	private ChattingService service;
	
	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
		
	private List<WebSocketSession> sessionList ;
	
	public ChattingHandler() {
		sessionList = new ArrayList<WebSocketSession>();
	}
	
	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		log.info("#ChattingHandler, afterConnectionEstablished");
		System.out.println("#ChattingHandler, afterConnectionEstablished");
		users.put(session.getId(), session);
		sessionList.add(session);
		
		System.out.println("session.getId() : " + session.getId());
		log.info(session.getPrincipal().getName() + "님이 입장하셨습니다.");
		System.out.println(session.getPrincipal().getName() + "님이 입장하셨습니다.");
		sessionList.forEach(x->System.out.println(x));
	}
	
	
	
	//웹 소켓 서버로 메세지를 전송했을 때 이 메서드가 호출된다. 현재 웹 소켓 서버에 접속한 Session모두에게 메세지를 전달해야 하므로 loop를 돌며 메세지를 전송한다
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		log.info("#ChattingHandler, handleMessage");
		log.info(session.getId() + ": " + message);
		System.out.println("#ChattingHandler, handleMessage");
		System.out.println(session.getId() + ": " + message);
		
		 Map<String, Object> map = null;
		 MessageVO messageVO = MessageVO.convertMessage(message.getPayload());
		 System.out.println("1 : " + messageVO.toString());
		
		 ChatRoom roomVO = new ChatRoom();
		 roomVO.setChatroom_id(messageVO.getChatroom_id());			// 채팅방
		 roomVO.setBuyer_M_Number(messageVO.getBuyer_M_Number()); 	// 구매자
		 roomVO.setSeller_M_Number(messageVO.getSeller_M_Number()); // 판매자
		 roomVO.setG_id(messageVO.getG_id());						// 상품
		 System.out.println(roomVO);
		 ChatRoom chatRoom = null;
		 
		 if(!(messageVO.getBuyer_M_Number() == messageVO.getSeller_M_Number())) {
			 System.out.println("채팅방 검사");
			 
			 if(service.isRoom(roomVO) == null) {
				 service.createRoom(roomVO);
				 chatRoom = service.isRoom(roomVO);
			 }else {
				 chatRoom = service.isRoom(roomVO);
			 }
			 
		 }else {
			 chatRoom = service.isRoom(roomVO);
		 }
		 
		 messageVO.setChatroom_id(chatRoom.getChatroom_id());
//		if(chatRoom.getBuyer_M_Number() == )
		 
		for(WebSocketSession s : sessionList) {
			map = s.getAttributes();
			
			//받는 사람
			
				s.sendMessage(new TextMessage(session.getPrincipal().getName() + ":" + message.getPayload()));
				
			
		}
	}
	
	//클라이언트와 연결이 끊어진 경우(채팅방을 나간 경우) remove로 해당 세션을 제거한다.
		@Override
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			
			log.info("#ChattingHandler, afterConnectionClosed");
			System.out.println("#ChattingHandler, afterConnectionClosed");
			
			sessionList.remove(session);
			users.remove(session.getId(), session);
			
			log.info(session.getPrincipal().getName() + "님이 퇴장하셨습니다.");
			System.out.println(session.getPrincipal().getName() + "님이 퇴장하셨습니다.");
		}
	
}
