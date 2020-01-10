package view.impl;

import dao.UserDao;
import model.User;
import service.MessageService;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


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

        int input = showUsersMenu();

        switch (input) {
            case BLOCK_USER_CODE:
                blockUsersMenu(true);
                break;
            case UNBLOCK_USER_CODE:
                blockUsersMenu(false);
                break;
            case PRIVATE_MESSAGE_CODE:
                sendMessageMenu();
                break;
            default:
                break;
        }
    }

    public int showUsersMenu() {
        System.out.println("Select menu item:");
        System.out.println(BLOCK_USER_CODE + ". " + BLOCK_USER_TEXT);
        System.out.println(UNBLOCK_USER_CODE + ". " + UNBLOCK_USER_TEXT);
        System.out.println(PRIVATE_MESSAGE_CODE + ". " + PRIVATE_MESSAGE_TEXT);
        System.out.println(EXIT_CODE + ". " + EXIT_TEXT);

        return Integer.parseInt(getInput());
    }

    public void blockUsersMenu(boolean block) {
        List<User> users;
        if (block) {
            System.out.println("Select user to block");
        } else {
            System.out.println("Select user to unblock");
        }
        var userDao = new UserDao();
        users = userDao.getUsersListByBlockedStatus(!block);
        Map<Integer, Integer> usersId = printUsersList(users);
        System.out.println(EXIT_CODE + ". " + EXIT_TEXT);
        int input = Integer.parseInt(getInput());
        if (input == EXIT_CODE) {
            return;
        }
        Integer userId = usersId.get(input);
        if (userId != null) {
            var userService = new UserService();
            userService.setUserStatus(userId, block);
            if (block) {
                System.out.println(users.get(input - 1).getName() + " blocked successful");
            } else {
                System.out.println(users.get(input - 1).getName() + " unblocked successful");
            }
        } else {
            System.out.println("User not found");
        }
    }

    public void sendMessageMenu() {
        System.out.println("Select user");
        var userDao = new UserDao();
        List<User> users = userDao.getUsers();
        Map<Integer, Integer> usersId = printUsersList(users);
        System.out.println(EXIT_CODE + ". " + EXIT_TEXT);
        int input = Integer.parseInt(getInput());
        if (input == EXIT_CODE) {
            return;
        }
        System.out.println("Type the message");
        String messageText = getInput();
        Integer userId = usersId.get(input);
        if (userId != null) {
            var messageService = new MessageService();
            messageService.sendMessage(userId, messageText);
            System.out.println("Message was send to " + users.get(input - 1).getName());
        } else {
            System.out.println("User not found");
        }
    }

    public Map<Integer, Integer> printUsersList(List<User> users) {
        var usersId = new HashMap<Integer, Integer>();
        for (int i = 1; i <= users.size(); i++) {
            System.out.println(i + ". " + users.get(i - 1).getName());
            usersId.put(i, users.get(i - 1).getId());
        }
        return usersId;
    }

    public String getInput() {
        var scanner = new Scanner(System.in);
        return scanner.next();
    }
}
