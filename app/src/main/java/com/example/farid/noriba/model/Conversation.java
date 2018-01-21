package com.example.farid.noriba.model;

import java.util.Date;

/**
 * Created by farid on 21/01/2018.
 */

public class Conversation {
    private String dateC;
    private Message messages;
    private String userF;
    private String userH;

    public Conversation() {
    }

    public Conversation(String dateC, Message messages, String userF, String userH) {
        this.dateC = dateC;
        this.messages = messages;
        this.userF = userF;
        this.userH = userH;
    }

    public String getDateC() {
        return dateC;
    }

    public Conversation setDateC(String dateC) {
        this.dateC = dateC;
        return this;
    }

    public Message getMessages() {
        return messages;
    }

    public Conversation setMessages(Message messages) {
        this.messages = messages;
        return this;
    }

    public String getUserF() {
        return userF;
    }

    public Conversation setUserF(String userF) {
        this.userF = userF;
        return this;
    }

    public String getUserH() {
        return userH;
    }

    public Conversation setUserH(String userH) {
        this.userH = userH;
        return this;
    }
}
