package com.example.platform.customerservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateCustomerRequest {

    @NotBlank
    private String customerType;

    @NotBlank
    private String name;

    @NotBlank
    private String status;

    @NotBlank
    private String kycStatus;

    @NotNull
    private List<CustomerAddress> addresses;

    @NotNull
    private List<CustomerContact> contacts;

    public static class CustomerAddress {
        @NotBlank
        private String addressType;
        @NotBlank
        private String street;
        @NotBlank
        private String city;
        @NotBlank
        private String state;
        @NotBlank
        private String country;
        @NotBlank
        private String postalCode;

        public String getAddressType() {
            return addressType;
        }

        public void setAddressType(String addressType) {
            this.addressType = addressType;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }
    }

    public static class CustomerContact {
        @NotBlank
        private String contactType;
        @NotBlank
        private String value;

        public String getContactType() {
            return contactType;
        }

        public void setContactType(String contactType) {
            this.contactType = contactType;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKycStatus() {
        return kycStatus;
    }

    public void setKycStatus(String kycStatus) {
        this.kycStatus = kycStatus;
    }

    public List<CustomerAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CustomerAddress> addresses) {
        this.addresses = addresses;
    }

    public List<CustomerContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<CustomerContact> contacts) {
        this.contacts = contacts;
    }
}
