package com.example.telegramhwnotificationbot.component;

import com.example.telegramhwnotificationbot.entity.NotificationTask;
import com.example.telegramhwnotificationbot.repository.TelegramBotRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

@Component
public class TelegramBotComponent {

    private final TelegramBotRepository telegramBotRepository;
    private final TelegramBot telegramBot;

    public TelegramBotComponent(TelegramBotRepository telegramBotRepository, TelegramBot telegramBot) {
        this.telegramBotRepository = telegramBotRepository;
        this.telegramBot = telegramBot;
    }

    @Scheduled (cron = "0 0/1 * * * *")
    public void runScheduling() {
        Collection <NotificationTask> notice =
                telegramBotRepository.findAllByTimeSendMessage
                        (LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        notice.forEach(notificationTask -> {
            SendMessage mess = new SendMessage(notificationTask.getChatId()
                    , "Вы просили меня напомнить об этом: " + notificationTask.getMessage());
            telegramBot.execute(mess);
        });

    }
}
