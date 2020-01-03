package model;

import java.time.LocalDate;

public class Message {

    private static int messageId;
    private int receiverUserId;
    private String messageText;
    private LocalDate messageTime;

    public Message(int receiverUserId, String messageText) {
        messageId ++;
        this.receiverUserId = receiverUserId;
        this.messageText = messageText;
        this.messageTime = LocalDate.now();
    }

    public int getReceiverUserId() {
        return receiverUserId;
    }

    public String getMessageText() {
        return messageText;
    }

    public LocalDate getMessageTime() {
        return messageTime;
    }

    public static int getMessageId() {
        return messageId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "receiverUserId=" + receiverUserId +
                ", messageText='" + messageText + '\'' +
                ", messageId='" + messageId + '\'' +
                ", messageTime=" + messageTime +
                '}';
    }
}
