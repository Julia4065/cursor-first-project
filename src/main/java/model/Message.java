package model;

import java.time.LocalDate;

public class Message {

    private int receiverUserId;
    private String messageText;
    private LocalDate messageTime;

    public Message(int receiverUserId, String messageText) {
        this.receiverUserId = receiverUserId;
        this.messageText = messageText;
        this.messageTime = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Message{" +
                "receiverUserId=" + receiverUserId +
                ", messageText='" + messageText + '\'' +
                ", messageTime=" + messageTime +
                '}';
    }
}
