package com.example.platform.common.exception;

import java.time.OffsetDateTime;

public class ErrorResponse {

    private final boolean success;
    private final String code;
    private final String message;
    private final Object data;
    private final OffsetDateTime timestamp;
    private final String traceId;

    public ErrorResponse(String code, String message, Object data, String traceId) {
        this.success = false;
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = OffsetDateTime.now();
        this.traceId = traceId;
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

    public Object getData() {
        return data;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public String getTraceId() {
        return traceId;
    }
}
