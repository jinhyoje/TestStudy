package com.example.teststudy.user;

import java.lang.reflect.Member;
import java.util.List;

public interface UserRepository {
        void save(UserDTO userDTO);
        UserDTO findByUsername(String username);
        List<UserDTO> findAll();

}
