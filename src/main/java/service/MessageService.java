package service;

import dao.MessageDao;

public class MessageService {
    public void sendMessage(int receiverUserId, String text) {
        MessageDao messageDao = new MessageDao();
        messageDao.sendMessage(receiverUserId, text);
    }
}
