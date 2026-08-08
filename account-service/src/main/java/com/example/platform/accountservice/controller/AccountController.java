package com.example.platform.accountservice.controller;

import com.example.platform.accountservice.dto.request.CreateAccountRequest;
import com.example.platform.accountservice.dto.request.UpdateAccountRequest;
import com.example.platform.accountservice.dto.response.AccountResponse;
import com.example.platform.accountservice.service.AccountService;
import com.example.platform.common.model.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AccountResponse>> create(@Valid @RequestBody CreateAccountRequest request) {
        return ResponseEntity.ok(ApiResponse.success(accountService.createAccount(request), null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AccountResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(accountService.getAccount(id), null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AccountResponse>>> list(@RequestParam(required = false) UUID customerId) {
        return ResponseEntity.ok(ApiResponse.success(
                customerId == null ? accountService.listAccounts() : accountService.listAccountsByCustomer(customerId), null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AccountResponse>> update(@PathVariable UUID id, @Valid @RequestBody UpdateAccountRequest request) {
        return ResponseEntity.ok(ApiResponse.success(accountService.updateAccount(id, request), null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok(ApiResponse.success(null, null));
    }
}
