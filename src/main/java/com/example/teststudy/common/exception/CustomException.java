package com.example.teststudy.common.exception;

public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
    private final SuccessCode successCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
        this.successCode = null; // SuccessCode가 전달되지 않은 경우 null로 초기화
    }

    public CustomException(SuccessCode successCode) {
        super(successCode.getDescription());
        this.errorCode = null; // ErrorCode가 전달되지 않은 경우 null로 초기화
        this.successCode = successCode;
    }

    public SuccessCode getSuccessCode() {
        if (successCode == null) {
            throw new IllegalStateException("이 예외에는 SuccessCode를 사용할 수 없습니다.");
        }
        return successCode;
    }

    public ErrorCode getErrorCode() {
        if (errorCode == null) {
            throw new IllegalStateException("이 예외에는 ErrorCode를 사용할 수 없습니다.");
        }
        return errorCode;
    }

    public int getErrorCodeValue() {
        return errorCode != null ? errorCode.getCode() : -1; // 기본값 설정
    }

    public String getErrorMessage() {
        return errorCode != null ? errorCode.getDescription() : successCode.getDescription();
    }
}

