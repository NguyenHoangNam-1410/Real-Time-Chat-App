package com.chat.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessage {
    private Long Id;
    private String sender;
    private String message;
    private String imageData;
    private String audioData;
}
