package com.pjys.ws;

import com.pjys.ws.types.MessageType;
import com.pjys.ws.vo.ChatMessage;
import com.pjys.ws.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class WsController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    public static Map<String, UserInfo> users = new ConcurrentHashMap<>();

    @GetMapping("chat/index")
    public String index(){
        return "chat/chat";
    }

    @MessageMapping("/test/chat")
    public void testReceive(@Payload ChatMessage message,SimpMessageHeaderAccessor headerAccessor){
        if(users.get(message.getSender()) == null){
            users.put(message.getSender(),
                    UserInfo.builder()
                    .sender(message.getSender())
                    .build());
            headerAccessor.getSessionAttributes().put("sender", message.getSender());
        }

        System.out.println("메세지 듣는 유저들"+users);
        message.setMessageType(MessageType.TEST);
        messagingTemplate.convertAndSend("/topic/chat/",message);
    }
}