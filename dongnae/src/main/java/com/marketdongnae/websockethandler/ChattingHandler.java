package com.marketdongnae.websockethandler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.marketdongnae.service.chatting.ChattingService;

import lombok.extern.log4j.Log4j;



@Log4j
public class ChattingHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
		
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	private final ChattingService chattingService;

    @Autowired
    public ChattingHandler(ChattingService chattingService) {
        this.chattingService = chattingService;
    }
	
	//채팅을 위해 해당 페이지에 들어오면(본 포스트에서는 /chat) 클라이언트가 연결된 후 해당 클라이언트의 세션을 sessionList에 add한다.
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		log.info("#ChattingHandler, afterConnectionEstablished");
		System.out.println("#ChattingHandler, afterConnectionEstablished");
		
		sessionList.add(session);
		
		log.info(session.getPrincipal().getName() + "님이 입장하셨습니다.");
		System.out.println(session.getPrincipal().getName() + "님이 입장하셨습니다.");
		sessionList.forEach(x->System.out.println(x));
	}
	
	//클라이언트와 연결이 끊어진 경우(채팅방을 나간 경우) remove로 해당 세션을 제거한다.
		@Override
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			
			log.info("#ChattingHandler, afterConnectionClosed");
			System.out.println("#ChattingHandler, afterConnectionClosed");
			sessionList.remove(session);
			
			log.info(session.getPrincipal().getName() + "님이 퇴장하셨습니다.");
			System.out.println(session.getPrincipal().getName() + "님이 퇴장하셨습니다.");
		}
	
	//웹 소켓 서버로 메세지를 전송했을 때 이 메서드가 호출된다. 현재 웹 소켓 서버에 접속한 Session모두에게 메세지를 전달해야 하므로 loop를 돌며 메세지를 전송한다
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		log.info("#ChattingHandler, handleMessage");
		log.info(session.getId() + ": " + message);
		System.out.println("#ChattingHandler, handleMessage");
		System.out.println(session.getId() + ": " + message);
		
		for(WebSocketSession s : sessionList) {
			s.sendMessage(new TextMessage(session.getPrincipal().getName() + ":" + message.getPayload()));
		}
	}
	
	
}
