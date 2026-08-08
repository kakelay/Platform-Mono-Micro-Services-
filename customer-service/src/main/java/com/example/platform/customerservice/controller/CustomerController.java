package com.example.platform.customerservice.controller;

import com.example.platform.common.model.ApiResponse;
import com.example.platform.customerservice.dto.request.CreateCustomerRequest;
import com.example.platform.customerservice.dto.request.UpdateCustomerRequest;
import com.example.platform.customerservice.dto.response.CustomerResponse;
import com.example.platform.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CustomerResponse>> create(@Valid @RequestBody CreateCustomerRequest request) {
        return ResponseEntity.ok(ApiResponse.success(customerService.createCustomer(request), null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(customerService.getCustomer(id), null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerResponse>>> list() {
        return ResponseEntity.ok(ApiResponse.success(customerService.listCustomers(), null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponse>> update(@PathVariable UUID id, @Valid @RequestBody UpdateCustomerRequest request) {
        return ResponseEntity.ok(ApiResponse.success(customerService.updateCustomer(id, request), null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(ApiResponse.success(null, null));
    }
}
