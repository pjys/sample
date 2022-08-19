package com.pjys.ws;

import com.pjys.auth.domain.Member;
import com.pjys.auth.domain.SecurityMember;
import com.pjys.common.utils.FeelUtil;
import com.pjys.ws.types.MessageType;
import com.pjys.ws.vo.ChatMessage;
import com.pjys.ws.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class WsController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    public static Map<String, UserInfo> users = new ConcurrentHashMap<>();

    @GetMapping("temp/test")
    public ModelAndView test(@RequestParam(required = false, defaultValue = "1") String roomName){
        ModelAndView mav = new ModelAndView("chat/ui");
        return mav;
    }

    @GetMapping("temp/chat")
    public ModelAndView index(@RequestParam(required = false, defaultValue = "1") String roomName){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mav = new ModelAndView("chat/index");
//        SecurityMember member = (SecurityMember)authentication.getPrincipal();
//        mav.addObject("userName",member.getUsername());
        mav.addObject("userName", FeelUtil.randomHangulName());
        mav.addObject("roomName",roomName);
        return mav;
    }

    @MessageMapping("/chat/send")
    public void testReceive(@Payload ChatMessage message,SimpMessageHeaderAccessor headerAccessor){
        System.out.println("메세지 듣는 유저들"+users);
        message.setMessageType(MessageType.CHAT);
        messagingTemplate.convertAndSend("/topic/chat/"+message.getRoomName(),message);
    }

    @MessageMapping("/chat/enter")
    public void userEnter(@Payload ChatMessage message,SimpMessageHeaderAccessor headerAccessor){
        if(users.get(message.getSender()) == null){
            users.put(message.getSender(),
                    UserInfo.builder()
                            .sender(message.getSender())
                            .build());
            headerAccessor.getSessionAttributes().put("sender", message.getSender());
            headerAccessor.getSessionAttributes().put("roomName", message.getRoomName());
        }
        message.setMessageType(MessageType.ENTER);
        messagingTemplate.convertAndSend("/topic/chat/"+message.getRoomName(),message);
    }

}