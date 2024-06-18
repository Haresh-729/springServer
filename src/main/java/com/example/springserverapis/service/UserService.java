package com.example.springserverapis.service;

import com.example.springserverapis.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;
    private int nextId = 1; // Track next available ID

    public UserService() {
        userList = new ArrayList<>();

        // Sample data for testing
        User user1 = new User(nextId++, "Haresh", "password1", "kuradeharesh4002@gmail.com", 19);
        User user2 = new User(nextId++, "Swati", "password2", "swati@gmail.com", 18);
        User user3 = new User(nextId++, "Khushi", "password3", "khushix@gmail.com", 20);
        User user4 = new User(nextId++, "Harshada", "password4", "harshada@gmail.com", 19);
        User user5 = new User(nextId++, "Ria", "password5", "ria@gmail.com", 21);

        userList.addAll(List.of(user1, user2, user3, user4, user5));
    }

    public void registerUser(User user) {
        user.setId(nextId++);
        userList.add(user);
    }

    public Optional<User> getUserById(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst();
    }

    public Optional<User> getUserByUsername(String username) {
        return userList.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
}
