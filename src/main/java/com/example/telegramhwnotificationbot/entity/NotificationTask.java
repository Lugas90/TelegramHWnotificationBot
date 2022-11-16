package com.example.telegramhwnotificationbot.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class NotificationTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long chatId;
    private String message;
    private LocalDateTime timeSendMessage;

    public NotificationTask(long chatId, String message, LocalDateTime timeSendMessage) {
        this.chatId = chatId;
        this.message = message;
        this.timeSendMessage = timeSendMessage;
    }

    public NotificationTask() {

    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeSendMessage() {
        return timeSendMessage;
    }

    public void setTimeSendMessage(LocalDateTime timeSendMessage) {
        this.timeSendMessage = timeSendMessage;
    }

}
