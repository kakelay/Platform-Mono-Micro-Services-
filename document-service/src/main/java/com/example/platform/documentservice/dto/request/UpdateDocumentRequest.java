package com.example.platform.documentservice.dto.request;

import jakarta.validation.constraints.NotBlank;

public class UpdateDocumentRequest {

    @NotBlank
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
