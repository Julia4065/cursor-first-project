package view;

import view.impl.UsersMenu;

import java.util.Scanner;

public class Menu {
    public void runUsersMenu() {
        System.out.println("Select main menu item:");
        System.out.println("1. Login Menu");
        System.out.println("2. User Main Menu");
        System.out.println("3. User Product Menu");
        System.out.println("4. Users Menu");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 4) {
            UsersMenu usersMenu = new UsersMenu();
            usersMenu.runMenu();
        }
    }
}
