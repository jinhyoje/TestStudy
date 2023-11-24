package com.example.teststudy.user;

import java.util.ArrayList;
import java.util.List;

public class MemoryUserRepository implements UserRepository {
    private static List<UserDTO> users = new ArrayList<>();

    @Override
    public void save(UserDTO userDTO) {
        users.add(userDTO);
    }

    @Override
    public UserDTO findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<UserDTO> findAll() {
        return users;
    }
}
