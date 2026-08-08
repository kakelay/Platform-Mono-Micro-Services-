package com.example.platform.customerservice.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customer_contacts")
public class CustomerContactEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @Column(nullable = false)
    private String contactType;

    @Column(nullable = false)
    private String value;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

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
