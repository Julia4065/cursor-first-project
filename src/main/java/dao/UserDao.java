package dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UserDao {
    public String usersJsonFile = "users.json";

    public List<User> users = List.of(
            new User(1, "Ben", true),
            new User(2, "Alice", true),
            new User(3, "Bill", false),
            new User(4, "John", false)
    );

    public void changeUserBlockStatus(int userId, boolean block) {
        List<User> users = getUsers();
        users.stream()
                .filter(v -> v.getId() == userId)
                .forEach(v -> v.blockUser(block));
        writeJsonToFile(users, usersJsonFile);
    }

    public List<User> getUsers() {
        return readJsonFile(usersJsonFile);
    }

    public List<User> getUsersListByBlockedStatus(boolean block) {
        return getUsers().stream()
                .filter(v -> v.isBlocked() == block)
                .collect(Collectors.toList());
    }

    private void writeJsonToFile(List<User> jsonString, String jsonFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson;
        try {
            arrayToJson = objectMapper.writeValueAsString(jsonString);
            try {
                FileWriter file;
                file = new FileWriter(jsonFile);
                file.write(arrayToJson);
                file.flush();
            } catch (IOException e) {
                System.out.println("Can not write data to " + jsonFile);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private List<User> readJsonFile(String jsonFile) {
        List<User> users = null;
        try {
            users = new ObjectMapper().readValue(new File(jsonFile), new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println("Can not read data from " + jsonFile);
        }
        return users;
    }
}

