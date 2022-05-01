package com.pjys.ws.vo;

import com.pjys.ws.types.MessageType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class ChatMessage {
    private MessageType messageType;
    private String message;
    private String sender;
}
