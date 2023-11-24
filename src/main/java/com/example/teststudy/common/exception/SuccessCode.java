package com.example.teststudy.common.exception;

public enum SuccessCode {
    JOIN_SUCCESS(200, "회원가입 성공"),
    LOGIN_SUCCESS(200, "로그인 성공");

    private final int code;
    private final String description;

    SuccessCode(int code, String description) {
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
