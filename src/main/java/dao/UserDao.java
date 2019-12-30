package dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        List<User> users = getUsers();
        users.stream()
                .filter(v -> v.getId() == userId)
                .forEach(v -> v.blockUser(block));
        writeJsonToFile(users, "users.json");
    }

    public static List<User> getUsers() {
        return readJsonFile("users.json");
    }

    public static List<User> getBlockedUsersList(boolean block) {
        return getUsers().stream()
                .filter(v -> v.isBlocked() == block)
                .collect(Collectors.toList());
    }

    public static void writeJsonToFile(List<User> jsonString, String jsonFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson;
        try {
            arrayToJson = objectMapper.writeValueAsString(jsonString);
            FileWriter file;
            try {
                file = new FileWriter(jsonFile);
                file.write(arrayToJson);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readJsonFile(String jsonFile) {
        List<User> users = null;
        try {
            users = new ObjectMapper().readValue(new File(jsonFile), new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}

