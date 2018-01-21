package com.example.farid.noriba.model;

import java.util.Date;
import java.util.List;

/**
 * Created by farid on 21/01/2018.
 */

public class Message {
    private User user;
    private String content;
    private String dateM;

    public Message() {
    }

    public Message(User user, String content, String dateM) {
        this.user = user;
        this.content = content;
        this.dateM = dateM;
    }

    public User getUser() {
        return user;
    }

    public Message setUser(User user) {
        this.user = user;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public String getDateM() {
        return dateM;
    }

    public Message setDateM(String dateM) {
        this.dateM = dateM;
        return this;
    }
}
