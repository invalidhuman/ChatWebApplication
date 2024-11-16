package com.example.ChatWebApplication.controller;

import com.example.ChatWebApplication.model.ChatRoom;
import com.example.ChatWebApplication.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;
    // curl -X POST http://localhost:8080/chat?name=test -H "Content-Type: application/json"
    @PostMapping
    public ChatRoom createRoom(@RequestParam String name) {
        return chatService.createRoom(name);
    }

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }
}
