package view.impl;

import dao.UserDao;
import model.User;
import service.UserService;

import java.util.*;


public class UsersMenu {
    final static int BLOCK_USER_CODE = 1;
    final static String BLOCK_USER_TEXT = "Block user";
    final static int UNBLOCK_USER_CODE = 2;
    final static String UNBLOCK_USER_TEXT = "Unblock user";
    final static int PRIVATE_MESSAGE_CODE = 3;
    final static String PRIVATE_MESSAGE_TEXT = "Private message";
    final static int EXIT_CODE = 0;
    final static String EXIT_TEXT = "To exit";

    public void runMenu() {

        int input = showMainMenu();

        switch (input) {
            case BLOCK_USER_CODE:
                blockUsersMenu(true);
                break;
            case UNBLOCK_USER_CODE:
                blockUsersMenu(false);
                break;
            case PRIVATE_MESSAGE_CODE:
                //TODO Create massages
                System.out.println("Select user to sent the message");
                break;
            default:
                break;
        }
    }

    public int showMainMenu() {
        System.out.println("Select menu item:");
        System.out.println(BLOCK_USER_CODE + ". " + BLOCK_USER_TEXT);
        System.out.println(UNBLOCK_USER_CODE + ". " + UNBLOCK_USER_TEXT);
        System.out.println(PRIVATE_MESSAGE_CODE + ". " + PRIVATE_MESSAGE_TEXT);
        System.out.println(EXIT_CODE + ". " + EXIT_TEXT);

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
        System.out.println(EXIT_CODE + ". " + EXIT_TEXT);
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == EXIT_CODE) {
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
