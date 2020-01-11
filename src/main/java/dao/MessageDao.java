package dao;


import model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    private List<Message> messages = new ArrayList<>(List.of(
            new Message(1, "Hi Ben!"),
            new Message(2, "Hello Alice"),
            new Message(3, "Thanks Bill"),
            new Message(4, "Bye John")
    ));

    public List<Message> getMessages() {
        return messages;
    }

    public void sendMessage(int receiverUserId, String text) {
        messages.add(new Message(receiverUserId, text));
    }
}
