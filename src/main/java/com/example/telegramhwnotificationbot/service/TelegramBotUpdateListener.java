package com.example.telegramhwnotificationbot.service;

import com.example.telegramhwnotificationbot.entity.NotificationTask;
import com.example.telegramhwnotificationbot.repository.TelegramBotRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TelegramBotUpdateListener implements UpdatesListener {

    private final Pattern pattern = Pattern.compile("([0-9\\.\\:\\s]{16})(\\s)([\\W+]+)");
    private final LocalDateTime timeSendMessage = LocalDateTime.parse("10.11.2022 17:00",
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));

    private final Logger log = LoggerFactory.getLogger(TelegramBotUpdateListener.class);


    private final TelegramBot telegramBot;

    private final TelegramBotRepository telegramBotRepository;

    public TelegramBotUpdateListener(TelegramBot telegramBot, TelegramBotRepository telegramBotRepository) {
        this.telegramBot = telegramBot;
        this.telegramBotRepository = telegramBotRepository;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    public int process (List<Update> updates){
        updates.forEach(update -> {
            log.info("Processing update: {}", update);
            Long id = update.message().chat().id();
            String message = update.message().text();

            if (update.message().text().equals("/start")) {
                SendMessage mess = new SendMessage(id, "Приветствую тебя, землянин!");
                telegramBot.execute(mess);


                Matcher matcher = pattern.matcher("10.11.2022 17:00 Сделать домашнюю работу");
                if (matcher.matches()) {
                    String date = matcher.group(1);
                    String item = matcher.group(3);
                    NotificationTask notificationTask = new NotificationTask(id, message, timeSendMessage);
                    telegramBotRepository.save(notificationTask);
                }
            }

        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
