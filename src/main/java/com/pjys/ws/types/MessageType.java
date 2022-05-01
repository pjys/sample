package com.pjys.ws.types;

public enum MessageType {
    REQUEST_ALL_LOCATIONS, //모든 위치 요청
    RESPONSE_ALL_LOCATIONS, //모든 위치 응답
    ADD_USER, //유저 추가
    LEAVE,   //클라이언트가 떠날때
    REFRESH_MY_LOCATION,  //내 위치 갱신
    NOTICE_MY_LOCATION, //내 위치 알림
    LOCATION, //위치데이터 타입
    TEST,
    CHAT, //채팅메세지
    POSITION, //위치정보
}
