package com.example.teststudy.common;

import com.example.teststudy.common.exception.ErrorCode;
import com.example.teststudy.common.exception.SuccessCode;

public class ResponseMessage {
    private String msg;
    private int statusCode;

    public ResponseMessage(String msg, int statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }

    public ResponseMessage(ErrorCode errorCode) {
        this.msg = errorCode.getDescription();
        this.statusCode = errorCode.getCode();
    }

    public ResponseMessage(SuccessCode successCode) {
        this.msg = successCode.getDescription();
        this.statusCode = successCode.getCode();
    }



    public String getMsg() {
        return msg;
    }

    public int getStatusCode() {
        return statusCode;
    }

}
