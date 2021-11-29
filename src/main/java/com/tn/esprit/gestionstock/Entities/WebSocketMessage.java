package com.tn.esprit.gestionstock.Entities;

public class WebSocketMessage {

    private String socketMessage;
    private long objectId;

    public WebSocketMessage() {
    }
    public WebSocketMessage(String socketMessage, long id) {
        this.socketMessage = socketMessage;
        this.objectId = id;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }



    public WebSocketMessage(String socketMessage) {
        this.socketMessage = socketMessage;
    }

    public String getSocketMessage() {
        return socketMessage;
    }

    public void setSocketMessage(String socketMessage) {
        this.socketMessage = socketMessage;
    }
}
