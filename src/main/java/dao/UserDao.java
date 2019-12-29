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

    public static void blockUser(int userId, boolean block) {
        users.stream()
                .filter(v -> v.getId() == userId)
                .forEach(v -> v.blockUser(block));
    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<User> getBlockedUsersList(boolean block) {
        return getUsers().stream()
                .filter(v -> v.isBlocked() == block)
                .collect(Collectors.toList());
    }

}
