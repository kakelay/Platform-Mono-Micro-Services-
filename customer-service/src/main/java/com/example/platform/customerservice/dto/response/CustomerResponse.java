package com.example.platform.customerservice.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CustomerResponse {

    private final UUID id;
    private final String customerType;
    private final String name;
    private final String status;
    private final String kycStatus;
    private final LocalDateTime createdAt;
    private final List<CustomerAddress> addresses;
    private final List<CustomerContact> contacts;

    public CustomerResponse(UUID id, String customerType, String name, String status, String kycStatus, LocalDateTime createdAt, List<CustomerAddress> addresses, List<CustomerContact> contacts) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.status = status;
        this.kycStatus = kycStatus;
        this.createdAt = createdAt;
        this.addresses = addresses;
        this.contacts = contacts;
    }

    public static class CustomerAddress {
        private final String addressType;
        private final String street;
        private final String city;
        private final String state;
        private final String country;
        private final String postalCode;

        public CustomerAddress(String addressType, String street, String city, String state, String country, String postalCode) {
            this.addressType = addressType;
            this.street = street;
            this.city = city;
            this.state = state;
            this.country = country;
            this.postalCode = postalCode;
        }

        public String getAddressType() { return addressType; }
        public String getStreet() { return street; }
        public String getCity() { return city; }
        public String getState() { return state; }
        public String getCountry() { return country; }
        public String getPostalCode() { return postalCode; }
    }

    public static class CustomerContact {
        private final String contactType;
        private final String value;

        public CustomerContact(String contactType, String value) {
            this.contactType = contactType;
            this.value = value;
        }

        public String getContactType() { return contactType; }
        public String getValue() { return value; }
    }

    public UUID getId() { return id; }
    public String getCustomerType() { return customerType; }
    public String getName() { return name; }
    public String getStatus() { return status; }
    public String getKycStatus() { return kycStatus; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<CustomerAddress> getAddresses() { return addresses; }
    public List<CustomerContact> getContacts() { return contacts; }
}
