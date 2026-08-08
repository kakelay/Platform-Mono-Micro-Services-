package com.example.platform.customerservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UpdateCustomerRequest {

    @NotBlank
    private String status;

    @NotBlank
    private String kycStatus;

    @NotNull
    private List<CreateCustomerRequest.CustomerAddress> addresses;

    @NotNull
    private List<CreateCustomerRequest.CustomerContact> contacts;

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getKycStatus() { return kycStatus; }
    public void setKycStatus(String kycStatus) { this.kycStatus = kycStatus; }
    public List<CreateCustomerRequest.CustomerAddress> getAddresses() { return addresses; }
    public void setAddresses(List<CreateCustomerRequest.CustomerAddress> addresses) { this.addresses = addresses; }
    public List<CreateCustomerRequest.CustomerContact> getContacts() { return contacts; }
    public void setContacts(List<CreateCustomerRequest.CustomerContact> contacts) { this.contacts = contacts; }
}
