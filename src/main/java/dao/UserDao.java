package dao;

import model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDao {

    private List<User> users = List.of(
            new User(1, "Ben", true),
            new User(2, "Alice", true),
            new User(3, "Bill", false),
            new User(4, "John", false)
    );

    public void changeUserBlockStatus(int userId, boolean block) {
        List<User> users = getUsers();
        users.stream()
                .filter(v -> v.getId() == userId)
                .forEach(v -> v.setUserStatus(block));
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> getUsersListByBlockedStatus(boolean block) {
        return getUsers().stream()
                .filter(v -> v.isBlocked() == block)
                .collect(Collectors.toList());
    }
}

