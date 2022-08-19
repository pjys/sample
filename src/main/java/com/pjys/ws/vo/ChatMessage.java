package com.pjys.ws.vo;

import com.pjys.ws.types.MessageType;
import lombok.*;

@ToString
@Setter
@Getter
@Builder
public class ChatMessage {
    private String roomName;
    private MessageType messageType;
    private String message;
    private String sender;
}
