package com.pjys.ws;

import com.pjys.ws.types.MessageType;
import com.pjys.ws.vo.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WsController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @GetMapping("chat/index")
    public String index(){
        System.out.println("!");
        return "chat/chat";
    }

    @MessageMapping("/test/chat")
    public void testReceive(@Payload ChatMessage message){
        message.setMessageType(MessageType.TEST);
        messagingTemplate.convertAndSend("/topic/chat/",message);
    }
}
