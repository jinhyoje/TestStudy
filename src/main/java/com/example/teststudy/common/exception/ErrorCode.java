package com.example.teststudy.common.exception;

public enum ErrorCode {
    DUPLICATED_USERNAME(400, "중복된 아이디입니다."),
    NOT_FOUND_USER(400, "존재하지 않는 유저입니다."),
    PASSWORD_DOES_NOT_MATCH(400, "비밀번호가 일치하지 않습니다.");


    private final int code;
    private final String description;

    ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}

