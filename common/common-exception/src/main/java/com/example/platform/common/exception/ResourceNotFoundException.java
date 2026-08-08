package com.example.platform.common.exception;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(String code, String message) {
        super(code, message);
    }

    public ResourceNotFoundException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
