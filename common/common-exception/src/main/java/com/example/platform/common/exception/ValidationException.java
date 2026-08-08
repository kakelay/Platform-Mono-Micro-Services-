package com.example.platform.common.exception;

public class ValidationException extends BaseException {

    public ValidationException(String code, String message) {
        super(code, message);
    }

    public ValidationException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
