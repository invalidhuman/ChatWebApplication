package com.example.ChatWebApplication.chat.handler;

import com.example.ChatWebApplication.model.ChatMessage;
import com.example.ChatWebApplication.model.ChatRoom;
import com.example.ChatWebApplication.service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component
    public class WebSocketChatHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload {}", payload);
//        TextMessage textMessage = new TextMessage("Welcome chatting sever~^^ ");
//        session.sendMessage(textMessage);

        // 채팅 메시지를 전달받아 객체로 변환
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        // 전달받은 메시지에 담긴 채팅방id로 발송 대상 채팅방 정보 조회
        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());

        // 현재 채팅방에 입장해 있는 클라이언트들에게 타입에 따른 메시지 전송
        room.handleActions(session, chatMessage, chatService);
    }
}