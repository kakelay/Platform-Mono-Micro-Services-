package com.example.platform.common.model;

import java.time.OffsetDateTime;

public final class ApiResponse<T> {

    private final boolean success;
    private final String code;
    private final String message;
    private final T data;
    private final OffsetDateTime timestamp;
    private final String traceId;

    private ApiResponse(boolean success, String code, String message, T data, String traceId) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = OffsetDateTime.now();
        this.traceId = traceId;
    }

    public static <T> ApiResponse<T> success(T data, String traceId) {
        return new ApiResponse<>(true, "00", "Success", data, traceId);
    }

    public static <T> ApiResponse<T> error(String code, String message, String traceId) {
        return new ApiResponse<>(false, code, message, null, traceId);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public String getTraceId() {
        return traceId;
    }
}
