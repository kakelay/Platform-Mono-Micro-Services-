package com.example.platform.common.exception;

public abstract class BaseException extends RuntimeException {

    private final String code;

    protected BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    protected BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
