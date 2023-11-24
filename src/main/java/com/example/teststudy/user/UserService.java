package com.example.teststudy.user;

import com.example.teststudy.common.exception.CustomException;
import com.example.teststudy.common.exception.ErrorCode;

public class UserService {

    private final MemoryUserRepository userRepository;

    public UserService(MemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void join(UserDTO userDTO) {
        if(userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new CustomException(ErrorCode.DUPLICATED_USERNAME);
        }
        userRepository.save(userDTO);
    }


    public UserDTO login(String username, String password) {
        UserDTO userDTO = userRepository.findByUsername(username);

        if(userDTO == null) {
            throw new CustomException(ErrorCode.NOT_FOUND_USER);
        }
        if(!userDTO.getPassword().equals(password)) {
            throw new CustomException(ErrorCode.PASSWORD_DOES_NOT_MATCH);
        }
        return userDTO;
    }
}
