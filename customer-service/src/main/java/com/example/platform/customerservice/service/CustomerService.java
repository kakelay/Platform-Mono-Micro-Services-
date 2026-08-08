package com.example.platform.customerservice.service;

import com.example.platform.customerservice.dto.request.CreateCustomerRequest;
import com.example.platform.customerservice.dto.request.UpdateCustomerRequest;
import com.example.platform.customerservice.dto.response.CustomerResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerResponse createCustomer(CreateCustomerRequest request);
    CustomerResponse getCustomer(UUID id);
    List<CustomerResponse> listCustomers();
    CustomerResponse updateCustomer(UUID id, UpdateCustomerRequest request);
    void deleteCustomer(UUID id);
}
