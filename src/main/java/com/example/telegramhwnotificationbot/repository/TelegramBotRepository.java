package com.example.telegramhwnotificationbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.telegramhwnotificationbot.entity.NotificationTask;

import java.time.LocalDateTime;
import java.util.Collection;

public interface TelegramBotRepository extends JpaRepository <NotificationTask, Long > {
    Collection<NotificationTask> findAllByTimeSendMessage(LocalDateTime timeMessage);
}
