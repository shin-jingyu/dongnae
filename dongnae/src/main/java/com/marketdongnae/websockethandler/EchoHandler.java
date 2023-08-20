package com.marketdongnae.websockethandler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.marketdongnae.security.CustomUserDetails;


@Component
@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	
	private List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();

	
	
	
	//클라이언트가 웹 소켓 생성
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Socket 연결");
		//웹 소켓 생성시 세션 리스트에 저장
		sessions.add(session);
	}

	//JS에서 메시지 받을 경우
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		
		SecurityContextImpl o = (SecurityContextImpl) session.getAttributes().get("SPRING_SECURITY_CONTEXT");
        CustomUserDetails principal = (CustomUserDetails) o.getAuthentication().getPrincipal();
        System.out.println("username = " + principal.getUsername());
        
		for(WebSocketSession single : sessions) {
		
			//세션아이디
			String hsid = principal.getUsername();
			
			//세션값이 같을때, 알람보낼 것이 있을 때만 전송 -> 로그인 한 사용자가 처음으로 알람 받는 순간임
			//해당 sendMsg에 DB정보 넣어서 체크 안된 알람 전부 전송하기
//			if(single.getAttributes().get("user_id").equals(principal.getUsername())) {        
//				//체크 안된 알림들만 담아서 View
//				List<AlarmDto> dto = new ArrayList<>();
//				dto = alarmDao.selectAlarm(hsid);
//				for(AlarmDto alarm : dto) {
//					int idx = alarm.getIdx();
//					String prefix = alarm.getPrefix();
//					String code = alarm.getCode();
//					if(code.equals("NewPost")) {
//						code = "답변이 등록되었습니다.";
//					}
//					
//					TextMessage sendMsg = new TextMessage("("+idx+")" + prefix + "에 " + code);
//		            single.sendMessage(sendMsg);
//				}
//			}
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {//연결 해제
		// TODO Auto-generated method stub
		logger.info("Socket 끊음");
		//웹 소켓이 종료될 때마다 리스트에서 뺀다.
		sessions.remove(session);
	}
	
	
}
