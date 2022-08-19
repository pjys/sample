package com.pjys.ws;

import com.pjys.ws.types.MessageType;
import com.pjys.ws.vo.ChatMessage;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        logger.info("Session Connected : "+headerAccessor.getSessionAttributes());
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String sender = (String) headerAccessor.getSessionAttributes().get("sender");
        String roomName = (String) headerAccessor.getSessionAttributes().get("roomName");
        System.out.println(sender);

        ChatMessage message = ChatMessage.builder()
                .roomName(roomName)
                .messageType(MessageType.LEAVE)
                .sender(sender)
                .build();

        if(Strings.isNotEmpty(sender)){
            WsController.users.remove(sender);
            messagingTemplate.convertAndSend("/topic/chat/"+roomName,message);
            System.out.println(sender+" leave");
        }
        logger.info("Session Disconnected");
    }
}
