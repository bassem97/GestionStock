package com.tn.esprit.gestionstock.Service.WebSocket;


import com.tn.esprit.gestionstock.Configurations.Greeting;
import com.tn.esprit.gestionstock.Entities.WebSocketMessage;

public interface WebSocketService  {

     Greeting sendWebSocketMessage(WebSocketMessage message) throws Exception ;


    }
