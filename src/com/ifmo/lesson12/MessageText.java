package com.ifmo.lesson12;

import java.io.Serializable;

public class MessageText implements Serializable {
    // передача серверу
    // нужно серилизовать, передать и прочитать на сервере
    // за сериализацию отвечают оутпут и инпут стрим
    //  по какому-то адресу, по определенному порту будет ждать сообщение
    // клиент создает сокет, и по адресу и порту соединяется с сервером
    // после этого сервер создает объект сокета
    // это и есть поток для передачи собщения
    //

    private String sender;
    private String messageText;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public MessageText(String sender, String messageText) {
        this.sender = sender;
        this.messageText = messageText;
    }
}
