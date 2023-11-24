package com.example.teststudy.user;

import com.example.teststudy.common.exception.CustomException;
import com.example.teststudy.common.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class UserServiceTest {

    private UserService userService;
    private MemoryUserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new MemoryUserRepository();
        userService = new UserService(userRepository);
    }

    @Test
    @DisplayName("회원가입 성공")
    void testJoin_Success() {
        // given : 초기 상태
        UserDTO newUser = new UserDTO("newUser", "password");

        // when : 메소드 호출, 테스트 코드 실행
        userService.join(newUser);

        // then : 예상 결과 검증
        UserDTO foundUser = userRepository.findByUsername("newUser");
        assertNotNull(foundUser);
        assertEquals(newUser.getUsername(), foundUser.getUsername());
        assertEquals(newUser.getPassword(), foundUser.getPassword());
    }

    @Test
    @DisplayName("회원가입 실패 - 중복된 username")
    void testJoin_DuplicatedUsername() {
        UserDTO existingUser = new UserDTO("existingUser", "password");
        userRepository.save(existingUser);

        UserDTO newUser = new UserDTO("existingUser", "newPassword");

        CustomException exception = assertThrows(CustomException.class, () -> {
            userService.join(newUser);
        });

        assertEquals(ErrorCode.DUPLICATED_USERNAME, exception.getErrorCode());
    }

    @Test
    @DisplayName("로그인 성공")
    void testLogin_Success() {
        UserDTO user = new UserDTO("user1", "password");
        userRepository.save(user);

        UserDTO loggedInUser = userService.login("user1", "password");

        assertNotNull(loggedInUser);
        assertEquals(user.getUsername(), loggedInUser.getUsername());
        assertEquals(user.getPassword(), loggedInUser.getPassword());
    }

    @Test
    @DisplayName("로그인 실패 - username이 존재하지 않음")
    void testLogin_UserNotFound() {
        CustomException exception = assertThrows(CustomException.class, () -> {
            userService.login("nonExistingUser", "password");
        });

        assertEquals(ErrorCode.NOT_FOUND_USER, exception.getErrorCode());
    }

    @Test
    @DisplayName("로그인 실패 - password가 일치하지 않음")
    void testLogin_PasswordDoesNotMatch() {
        UserDTO user = new UserDTO("user2", "password");
        userRepository.save(user);

        CustomException exception = assertThrows(CustomException.class, () -> {
            userService.login("user2", "wrongPassword");
        });

        assertEquals(ErrorCode.PASSWORD_DOES_NOT_MATCH, exception.getErrorCode());
    }
}
