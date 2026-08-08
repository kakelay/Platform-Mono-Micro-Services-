package com.example.platform.common.model;

public final class IntegrationEvent<T> {

    private final String eventId;
    private final String eventType;
    private final CorrelationContext correlationContext;
    private final T payload;

    public IntegrationEvent(String eventId, String eventType, CorrelationContext correlationContext, T payload) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.correlationContext = correlationContext;
        this.payload = payload;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public CorrelationContext getCorrelationContext() {
        return correlationContext;
    }

    public T getPayload() {
        return payload;
    }
}
