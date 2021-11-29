package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.WebSocketMessage;
import com.tn.esprit.gestionstock.Service.WebSocket.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/ws")
public class WebSocketController {

    @Autowired
    WebSocketService webSocketService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    public void sendMessage(WebSocketMessage message) {
        this.simpMessagingTemplate.convertAndSend("/topic/greetings", message);
    }
}
