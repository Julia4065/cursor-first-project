package service;

import dao.UserDao;

public class UserService {

    public void setUserStatus(int userId, boolean block) {
        UserDao userDao = new UserDao();
        userDao.changeUserBlockStatus(userId, block);
    }
}
