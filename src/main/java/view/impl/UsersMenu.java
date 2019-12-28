package view.impl;

import dao.UserDao;
import service.UserService;

import java.util.Scanner;

import static dao.UserDao.users;

public class UsersMenu {
    public static void main(String[] args) {

        for (model.User user : users) {
            System.out.println(user.toString());
        }

        System.out.println("Select menu item:");
        System.out.println("1. Block user");
        System.out.println("2. Unblock user");
        System.out.println("3. Private message");

        Scanner myInput = new Scanner(System.in);
        int mainMenuInput = myInput.nextInt();
        if (mainMenuInput == 1) {
            System.out.println("Select user to block");
            for (int i = 0; i < UserDao.getUnBlockedUsersList().size(); i++) {
                System.out.println(i + 1 + ". " + UserDao.getUnBlockedUsersList().get(i).getName());
            }
            Scanner blockUser = new Scanner(System.in);
            int userToBlock = blockUser.nextInt();
            UserService.blockUser(userToBlock - 1);
        } else if (mainMenuInput == 2) {
            System.out.println("Select user to unblock");
            for (int i = 0; i < UserDao.getBlockedUsersList().size(); i++) {
                System.out.println(i + 1 + ". " + UserDao.getBlockedUsersList().get(i).getName());
            }
            Scanner unBlockUser = new Scanner(System.in);
            int userToUnBlock = unBlockUser.nextInt();
            UserService.unBlockUser(userToUnBlock - 1);
        } else if (mainMenuInput == 3) {
            System.out.println("Select user to sent the message");
        }

        for (model.User user : users) {
            System.out.println(user.toString());
        }
    }
}
