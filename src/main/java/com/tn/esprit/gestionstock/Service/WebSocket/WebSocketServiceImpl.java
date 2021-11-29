package com.tn.esprit.gestionstock.Service.WebSocket;


import com.tn.esprit.gestionstock.Configurations.Greeting;
import org.springframework.stereotype.Service;
import com.tn.esprit.gestionstock.Entities.WebSocketMessage;
import org.springframework.web.util.HtmlUtils;

@Service("webSocketService")
public class WebSocketServiceImpl implements  WebSocketService{
    @Override
    public Greeting sendWebSocketMessage(WebSocketMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting(HtmlUtils.htmlEscape(message.getSocketMessage()));
    }
}
