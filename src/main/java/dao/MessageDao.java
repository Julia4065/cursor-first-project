package dao;


import model.Message;

import java.util.List;

public class MessageDao {
    private List<Message> messages = List.of(
            new Message(1, "Hi Ben!"),
            new Message(2, "Hello Alice"),
            new Message(3, "Thanks Bill"),
            new Message(4, "Buy John")
    );

    public List<Message> getMessages() {
        return messages;
    }
}
