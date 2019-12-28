package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao {

    public static List<User> users = new ArrayList<User>() {{
        add(new User(1, "Ben", true));
        add(new User(2, "Alice", true));
        add(new User(3, "Bill", false));
        add(new User(4, "John", false));
    }};

    public static void unBlockUser(int userId) {
        users.stream()
                .filter(v -> v.getId() == userId)
                .forEach(User::unBlockUser);
    }

    public static void blockUser(int userId) {
        users.stream()
                .filter(v -> v.getId() == userId)
                .forEach(User::blockUser);
    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<User> getBlockedUsersList() {
        return getUsers().stream()
                .filter(User::isBlocked)
                .collect(Collectors.toList());
    }

    public static List<User> getUnBlockedUsersList() {
        return getUsers().stream()
                .filter(v -> !v.isBlocked())
                .collect(Collectors.toList());
    }
}
