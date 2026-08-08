package com.example.platform.transactionservice.service;

import com.example.platform.transactionservice.dto.request.CreateTransactionRequest;
import com.example.platform.transactionservice.dto.request.UpdateTransactionRequest;
import com.example.platform.transactionservice.dto.response.TransactionResponse;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    TransactionResponse createTransaction(CreateTransactionRequest request);
    TransactionResponse getTransaction(UUID id);
    List<TransactionResponse> listTransactions();
    List<TransactionResponse> listTransactionsByAccount(UUID accountId);
    TransactionResponse updateTransaction(UUID id, UpdateTransactionRequest request);
    void deleteTransaction(UUID id);
}
