package view.impl;

import dao.UserDao;
import model.User;
import service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static dao.UserDao.users;

public class UsersMenu {
    public static void main(String[] args) {

        for (model.User user : users) {
            System.out.println(user.toString());
        }

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

        for (model.User user : users) {
            System.out.println(user.toString());
        }
    }

    public static int showMainMenu() {
        System.out.println("Select menu item:");
        System.out.println("1. Block user");
        System.out.println("2. Unblock user");
        System.out.println("3. Private message");
        System.out.println("0. To exit");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void blockUsersMenu(boolean block) {
        List<User> users;
        if (block) {
            System.out.println("Select user to block");
        } else {
            System.out.println("Select user to unblock");
        }
        users = UserDao.getBlockedUsersList(block);
        Map<Integer, Integer> usersId = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + 1 + ". " + users.get(i).getName());
            usersId.put(i + 1, users.get(i).getId());
        }
        System.out.println("0. To exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 0) {
            return;
        }
        try {
            UserService.blockUser(usersId.get(input), block);
        }catch (NullPointerException e){
            System.out.println("User not found");
        }
    }
}
