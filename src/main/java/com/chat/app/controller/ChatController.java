package com.chat.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;
import java.util.regex.Pattern;
import com.chat.app.model.ChatMessage;

@Controller
public class ChatController {
    // Pattern to detect potentially malicious content
    private static final Pattern SCRIPT_PATTERN = Pattern.compile("<script[^>]*>.*?</script>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final Pattern HTML_PATTERN = Pattern.compile("<[^>]+>");
    //app/sendMessage is the endpoint for sending messages
    @MessageMapping("/sendMessage")
    //topic/messages is the endpoint for receiving messages
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        // Sanitize the message content
        if (message.getMessage() != null) {
            // Option 1: Escape HTML completely
            message.setMessage(HtmlUtils.htmlEscape(message.getMessage()));

            // Option 2: Strip HTML tags (alternative)
            // message.setMessage(stripHtml(message.getMessage()));

            // Validate message length
            if (message.getMessage().length() > 10000) {
                throw new IllegalArgumentException("Message too long");
            }
        }

        // Sanitize sender name
        if (message.getSender() != null) {
            message.setSender(HtmlUtils.htmlEscape(message.getSender()));

            if (message.getSender().length() > 50) {
                throw new IllegalArgumentException("Sender name too long");
            }
        }

        // Validate file data (basic check)
        if (message.getImageData() != null && !message.getImageData().startsWith("data:image/")) {
            throw new IllegalArgumentException("Invalid image data");
        }

        if (message.getAudioData() != null && !message.getAudioData().startsWith("data:audio/")) {
            throw new IllegalArgumentException("Invalid audio data");
        }

        return message;
    }

    // Helper method to strip HTML tags (alternative to escaping)
    private String stripHtml(String input) {
        if (input == null) return null;
        return HTML_PATTERN.matcher(input).replaceAll("");
    }

    @GetMapping("chat")
    // This method is used to return the chat view
    public String chat() {
        return "chat";
    }

}
