package com.example.platform.orderservice.dto.request;

import jakarta.validation.constraints.NotBlank;

public class UpdateOrderRequest {

    @NotBlank
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
