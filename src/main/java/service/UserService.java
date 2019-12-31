package service;

import dao.UserDao;

public class UserService {

    public void blockUser(int userId, boolean block) {
        UserDao userDao = new UserDao();
        userDao.blockUser(userId, block);
    }
}
