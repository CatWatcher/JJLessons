package multithreading.messageApp;

import java.io.Serializable;

// будем передавать между клиентом и сервером
// объекты этого класса
public class Message implements Serializable {

    private String messageText;
    private String sender;
    // получаетель
    private String recipient;

    public Message(String messageText, String sender, String recipient) {
        this.messageText = messageText;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageText='" + messageText + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
