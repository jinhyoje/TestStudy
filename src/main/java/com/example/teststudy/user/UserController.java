package com.example.teststudy.user;

import com.example.teststudy.common.exception.CustomException;
import com.example.teststudy.common.exception.SuccessCode;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public CustomException create(UserDTO userDTO) {
        userService.join(userDTO);
        return new CustomException(SuccessCode.JOIN_SUCCESS);
    }

    public CustomException login(String username, String password){
        userService.login(username, password);
        return new CustomException(SuccessCode.LOGIN_SUCCESS);
    }
}
