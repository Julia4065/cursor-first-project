package service;

import dao.UserDao;

public class UserService {

    public static void blockUser(int userId) {
        UserDao.blockUser(userId);
    }

    public static void unBlockUser(int userId) {
        UserDao.unBlockUser(userId);
    }


}
