package com.example.ChatWebApplication.model;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;


@Getter
@Setter
@Accessors(chain = true)
public class ChatRoom {
    private String roomId;
    private String name;

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
}