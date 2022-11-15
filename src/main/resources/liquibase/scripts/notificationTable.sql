-- liquibase formatted sql

-- changeSet eLugovoy: 1
CREATE TABLE notificationTask (
    chatId          INTEGER PRIMARY KEY,
    message         TEXT,
    timeSendMessage TIMESTAMP
);

-- changeSet eLugovoy: 2
DROP TABLE notificationTask;
