package com.example.platform.customerservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String customerType;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String kycStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerAddressEntity> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerContactEntity> contacts = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<CustomerAddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CustomerAddressEntity> addresses) {
        this.addresses = addresses;
    }

    public List<CustomerContactEntity> getContacts() {
        return contacts;
    }

    public void setContacts(List<CustomerContactEntity> contacts) {
        this.contacts = contacts;
    }
}
