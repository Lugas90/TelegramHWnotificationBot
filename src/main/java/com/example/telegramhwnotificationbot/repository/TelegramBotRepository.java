package com.example.telegramhwnotificationbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.telegramhwnotificationbot.entity.NotificationTask;

public interface TelegramBotRepository extends JpaRepository <NotificationTask, Long > {
}
