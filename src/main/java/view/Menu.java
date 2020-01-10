package view;

import view.impl.UsersMenu;

import java.util.Scanner;

public class Menu {
    final static int LOGIN_MENU_CODE = 1;
    final static String LOGIN_MENU_TEXT = "Login Menu";
    final static int USER_MAIN_MENU_CODE = 2;
    final static String USER_MAIN_MENU_TEXT = "User Main Menu";
    final static int USER_PRODUCT_MENU_CODE = 3;
    final static String USER_PRODUCT_MENU_TEXT = "User Product Menu";
    final static int USERS_MENU_CODE = 4;
    final static String USERS_MENU_TEXT = "Users Menu";

    public void runUsersMenu() {
        System.out.println("Select main menu item:");
        System.out.println(LOGIN_MENU_CODE + ". " + LOGIN_MENU_TEXT);
        System.out.println(USER_MAIN_MENU_CODE + ". " + USER_MAIN_MENU_TEXT);
        System.out.println(USER_PRODUCT_MENU_CODE + ". " + USER_PRODUCT_MENU_TEXT);
        System.out.println(USERS_MENU_CODE + ". " + USERS_MENU_TEXT);

        var scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        switch (input) {
            case LOGIN_MENU_CODE:
                //TODO Login Menu
                break;
            case USER_MAIN_MENU_CODE:
                //TODO User Main Menu
                break;
            case USER_PRODUCT_MENU_CODE:
                //TODO User Product Menu
                break;
            case USERS_MENU_CODE:
                var usersMenu = new UsersMenu();
                usersMenu.runMenu();
                break;
            default:
                break;
        }
    }
}
