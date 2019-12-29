package service;

import dao.UserDao;

public class UserService {

    public static void blockUser(int userId, boolean block) {
        UserDao.blockUser(userId, block);
    }
}
