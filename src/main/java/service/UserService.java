package service;

import dao.impl.UserDao;

public class UserService {

    public void setUserStatus(int userId, boolean block) {
        var userDao = new UserDao();
        userDao.changeUserBlockStatus(userId, block);
    }
}
