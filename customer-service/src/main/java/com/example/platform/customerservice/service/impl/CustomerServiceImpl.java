package com.example.platform.customerservice.service.impl;

import com.example.platform.common.exception.BusinessException;
import com.example.platform.customerservice.dto.request.CreateCustomerRequest;
import com.example.platform.customerservice.dto.request.UpdateCustomerRequest;
import com.example.platform.customerservice.dto.response.CustomerResponse;
import com.example.platform.customerservice.entity.CustomerAddressEntity;
import com.example.platform.customerservice.entity.CustomerContactEntity;
import com.example.platform.customerservice.entity.CustomerEntity;
import com.example.platform.customerservice.repository.CustomerRepository;
import com.example.platform.customerservice.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public CustomerResponse createCustomer(CreateCustomerRequest request) {
        var customer = new CustomerEntity();
        customer.setId(UUID.randomUUID());
        customer.setCustomerType(request.getCustomerType());
        customer.setName(request.getName());
        customer.setStatus(request.getStatus());
        customer.setKycStatus(request.getKycStatus());
        customer.setCreatedAt(LocalDateTime.now());
        request.getAddresses().forEach(address -> {
            var entity = new CustomerAddressEntity();
            entity.setId(UUID.randomUUID());
            entity.setCustomer(customer);
            entity.setAddressType(address.getAddressType());
            entity.setStreet(address.getStreet());
            entity.setCity(address.getCity());
            entity.setState(address.getState());
            entity.setCountry(address.getCountry());
            entity.setPostalCode(address.getPostalCode());
            customer.getAddresses().add(entity);
        });
        request.getContacts().forEach(contact -> {
            var entity = new CustomerContactEntity();
            entity.setId(UUID.randomUUID());
            entity.setCustomer(customer);
            entity.setContactType(contact.getContactType());
            entity.setValue(contact.getValue());
            customer.getContacts().add(entity);
        });
        return toResponse(repository.save(customer));
    }

    @Override
    public CustomerResponse getCustomer(UUID id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new BusinessException("CUSTOMER_NOT_FOUND", "Customer not found"));
    }

    @Override
    public List<CustomerResponse> listCustomers() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public CustomerResponse updateCustomer(UUID id, UpdateCustomerRequest request) {
        var customer = repository.findById(id)
                .orElseThrow(() -> new BusinessException("CUSTOMER_NOT_FOUND", "Customer not found"));
        customer.setStatus(request.getStatus());
        customer.setKycStatus(request.getKycStatus());
        customer.getAddresses().clear();
        request.getAddresses().forEach(address -> {
            var entity = new CustomerAddressEntity();
            entity.setId(UUID.randomUUID());
            entity.setCustomer(customer);
            entity.setAddressType(address.getAddressType());
            entity.setStreet(address.getStreet());
            entity.setCity(address.getCity());
            entity.setState(address.getState());
            entity.setCountry(address.getCountry());
            entity.setPostalCode(address.getPostalCode());
            customer.getAddresses().add(entity);
        });
        customer.getContacts().clear();
        request.getContacts().forEach(contact -> {
            var entity = new CustomerContactEntity();
            entity.setId(UUID.randomUUID());
            entity.setCustomer(customer);
            entity.setContactType(contact.getContactType());
            entity.setValue(contact.getValue());
            customer.getContacts().add(entity);
        });
        return toResponse(repository.save(customer));
    }

    @Override
    @Transactional
    public void deleteCustomer(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("CUSTOMER_NOT_FOUND", "Customer not found");
        }
        repository.deleteById(id);
    }

    private CustomerResponse toResponse(CustomerEntity customer) {
        var addresses = customer.getAddresses().stream()
                .map(address -> new CustomerResponse.CustomerAddress(address.getAddressType(), address.getStreet(), address.getCity(), address.getState(), address.getCountry(), address.getPostalCode()))
                .toList();
        var contacts = customer.getContacts().stream()
                .map(contact -> new CustomerResponse.CustomerContact(contact.getContactType(), contact.getValue()))
                .toList();
        return new CustomerResponse(customer.getId(), customer.getCustomerType(), customer.getName(), customer.getStatus(), customer.getKycStatus(), customer.getCreatedAt(), addresses, contacts);
    }
}
