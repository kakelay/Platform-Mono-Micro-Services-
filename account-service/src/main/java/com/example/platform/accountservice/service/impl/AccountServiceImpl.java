package com.example.platform.accountservice.service.impl;

import com.example.platform.accountservice.dto.request.CreateAccountRequest;
import com.example.platform.accountservice.dto.request.UpdateAccountRequest;
import com.example.platform.accountservice.dto.response.AccountResponse;
import com.example.platform.accountservice.entity.AccountEntity;
import com.example.platform.accountservice.repository.AccountRepository;
import com.example.platform.accountservice.service.AccountService;
import com.example.platform.common.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public AccountResponse createAccount(CreateAccountRequest request) {
        var entity = new AccountEntity();
        entity.setId(UUID.randomUUID());
        entity.setCustomerId(request.getCustomerId());
        entity.setAccountNumber(generateAccountNumber());
        entity.setAccountType(request.getAccountType());
        entity.setCurrency(request.getCurrency());
        entity.setBalance(BigDecimal.ZERO);
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(LocalDateTime.now());
        return toResponse(repository.save(entity));
    }

    @Override
    public AccountResponse getAccount(UUID id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new BusinessException("ACCOUNT_NOT_FOUND", "Account not found"));
    }

    @Override
    public List<AccountResponse> listAccounts() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public List<AccountResponse> listAccountsByCustomer(UUID customerId) {
        return repository.findByCustomerId(customerId).stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public AccountResponse updateAccount(UUID id, UpdateAccountRequest request) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("ACCOUNT_NOT_FOUND", "Account not found"));
        entity.setStatus(request.getStatus());
        return toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void deleteAccount(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("ACCOUNT_NOT_FOUND", "Account not found");
        }
        repository.deleteById(id);
    }

    private AccountResponse toResponse(AccountEntity entity) {
        return new AccountResponse(
                entity.getId(),
                entity.getCustomerId(),
                entity.getAccountNumber(),
                entity.getAccountType(),
                entity.getCurrency(),
                entity.getBalance(),
                entity.getStatus(),
                entity.getCreatedAt());
    }

    private String generateAccountNumber() {
        return "ACCT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
