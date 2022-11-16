package com.example.telegramhwnotificationbot.component;

import com.example.telegramhwnotificationbot.service.TelegramBotUpdateListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TelegramBotComponent {

    public TelegramBotComponent() {
    }

    @Scheduled (cron = "0 0/1 * * * *")
    public void runScheduling() {


    }
}
