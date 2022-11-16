-- liquibase formatted sql

-- changeSet eLugovoy: 1
CREATE TABLE notification_task
(
    id                BIGSERIAL PRIMARY KEY,
    chat_id           BIGINT,
    message           TEXT,
    time_send_message TIMESTAMP
);



