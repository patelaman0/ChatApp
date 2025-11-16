package com.chat.Chat.Controller;


import com.chat.Chat.Entity.ChatMessage;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class ChatController {


    @MessageMapping("/room/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public ChatMessage sendToRoom(@DestinationVariable String roomId, ChatMessage message) {
        message.setRoomId(roomId);
        return message;
    }

    @GetMapping("/chat")
    public String dashboard(Model model, Principal principal) {
        return "chat";
    }

}
