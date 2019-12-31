package view.impl;

import dao.UserDao;
import model.User;
import service.UserService;

import java.util.*;


public class UsersMenu {
    public void runMenu() {

        int input = showMainMenu();

        if (input == 0) {
            return;
        } else if (input == 1) {
            blockUsersMenu(true);
        } else if (input == 2) {
            blockUsersMenu(false);
        } else if (input == 3) {
            //TODO Create massages
            System.out.println("Select user to sent the message");
        }
    }

    public int showMainMenu() {
        System.out.println("Select menu item:");
        System.out.println("1. Block user");
        System.out.println("2. Unblock user");
        System.out.println("3. Private message");
        System.out.println("0. To exit");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void blockUsersMenu(boolean block) {
        List<User> users;
        if (block) {
            System.out.println("Select user to block");
        } else {
            System.out.println("Select user to unblock");
        }
        UserDao userDao = new UserDao();
        users = userDao.getBlockedUsersList(!block);
        Map<Integer, Integer> usersId = new HashMap<>();
        for (int i = 1; i <= users.size(); i++) {
            System.out.println(i + ". " + users.get(i - 1).getName());
            usersId.put(i, users.get(i - 1).getId());
        }
        System.out.println("0. To exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 0) {
            return;
        }
        try {
            UserService userService = new UserService();
            userService.blockUser(usersId.get(input), block);
            if (block) {
                System.out.println(users.get(input - 1).getName() + " blocked successful");
            } else {
                System.out.println(users.get(input - 1).getName() + " unblocked successful");
            }
        } catch (NullPointerException e) {
            System.out.println("User not found");
        }
    }
}
