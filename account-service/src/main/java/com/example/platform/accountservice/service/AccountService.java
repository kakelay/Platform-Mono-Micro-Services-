package com.example.platform.accountservice.service;

import com.example.platform.accountservice.dto.request.CreateAccountRequest;
import com.example.platform.accountservice.dto.request.UpdateAccountRequest;
import com.example.platform.accountservice.dto.response.AccountResponse;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    AccountResponse createAccount(CreateAccountRequest request);
    AccountResponse getAccount(UUID id);
    List<AccountResponse> listAccounts();
    List<AccountResponse> listAccountsByCustomer(UUID customerId);
    AccountResponse updateAccount(UUID id, UpdateAccountRequest request);
    void deleteAccount(UUID id);
}
