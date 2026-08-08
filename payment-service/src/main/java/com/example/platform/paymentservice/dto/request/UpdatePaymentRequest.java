package com.example.platform.paymentservice.dto.request;

import jakarta.validation.constraints.NotBlank;

public class UpdatePaymentRequest {

    @NotBlank
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
