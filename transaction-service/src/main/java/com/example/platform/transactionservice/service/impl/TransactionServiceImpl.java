package com.example.platform.transactionservice.service.impl;

import com.example.platform.common.exception.BusinessException;
import com.example.platform.transactionservice.dto.request.CreateTransactionRequest;
import com.example.platform.transactionservice.dto.request.UpdateTransactionRequest;
import com.example.platform.transactionservice.dto.response.TransactionResponse;
import com.example.platform.transactionservice.entity.TransactionEntity;
import com.example.platform.transactionservice.repository.TransactionRepository;
import com.example.platform.transactionservice.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public TransactionResponse createTransaction(CreateTransactionRequest request) {
        var entity = new TransactionEntity();
        entity.setId(UUID.randomUUID());
        entity.setAccountId(request.getAccountId());
        entity.setAmount(request.getAmount());
        entity.setCurrency(request.getCurrency());
        entity.setType(request.getType());
        entity.setStatus(request.getStatus());
        entity.setDescription(request.getDescription());
        entity.setCreatedAt(LocalDateTime.now());
        return toResponse(repository.save(entity));
    }

    @Override
    public TransactionResponse getTransaction(UUID id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new BusinessException("TRANSACTION_NOT_FOUND", "Transaction not found"));
    }

    @Override
    public List<TransactionResponse> listTransactions() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public List<TransactionResponse> listTransactionsByAccount(UUID accountId) {
        return repository.findByAccountId(accountId).stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public TransactionResponse updateTransaction(UUID id, UpdateTransactionRequest request) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new BusinessException("TRANSACTION_NOT_FOUND", "Transaction not found"));
        entity.setStatus(request.getStatus());
        return toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void deleteTransaction(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("TRANSACTION_NOT_FOUND", "Transaction not found");
        }
        repository.deleteById(id);
    }

    private TransactionResponse toResponse(TransactionEntity entity) {
        return new TransactionResponse(
                entity.getId(),
                entity.getAccountId(),
                entity.getAmount(),
                entity.getCurrency(),
                entity.getType(),
                entity.getStatus(),
                entity.getDescription(),
                entity.getCreatedAt());
    }
}
