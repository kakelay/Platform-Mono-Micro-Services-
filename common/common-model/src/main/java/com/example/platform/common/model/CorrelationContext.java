package com.example.platform.common.model;

public final class CorrelationContext {

    private final String correlationId;
    private final String traceId;
    private final String spanId;

    public CorrelationContext(String correlationId, String traceId, String spanId) {
        this.correlationId = correlationId;
        this.traceId = traceId;
        this.spanId = spanId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public String getTraceId() {
        return traceId;
    }

    public String getSpanId() {
        return spanId;
    }
}
