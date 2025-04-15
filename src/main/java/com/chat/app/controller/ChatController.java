package com.chat.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.chat.app.model.ChatMessage;

@Controller
public class ChatController {

    //app/sendMessage is the endpoint for sending messages
    @MessageMapping("/sendMessage")
    //topic/messages is the endpoint for receiving messages
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        // Logic to send a message to the chat
        return message;
    }

    @GetMapping("chat")
    // This method is used to return the chat view
    public String chat() {
        return "chat";
    }

}
