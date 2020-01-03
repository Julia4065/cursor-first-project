package service;

import model.Message;

public class MessageService {
    public int sendMessage(int receiverUserId, String text){
        messages.put(new Message(receiverUserId, text));
        return Message.getMessageId();
    }
}
