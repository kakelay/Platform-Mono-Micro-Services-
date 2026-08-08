package com.example.platform.transactionservice.controller;

import com.example.platform.common.model.ApiResponse;
import com.example.platform.transactionservice.dto.request.CreateTransactionRequest;
import com.example.platform.transactionservice.dto.request.UpdateTransactionRequest;
import com.example.platform.transactionservice.dto.response.TransactionResponse;
import com.example.platform.transactionservice.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TransactionResponse>> create(@Valid @RequestBody CreateTransactionRequest request) {
        return ResponseEntity.ok(ApiResponse.success(transactionService.createTransaction(request), null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TransactionResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(transactionService.getTransaction(id), null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TransactionResponse>>> list(@RequestParam(required = false) UUID accountId) {
        return ResponseEntity.ok(ApiResponse.success(
                accountId == null ? transactionService.listTransactions() : transactionService.listTransactionsByAccount(accountId), null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TransactionResponse>> update(@PathVariable UUID id, @Valid @RequestBody UpdateTransactionRequest request) {
        return ResponseEntity.ok(ApiResponse.success(transactionService.updateTransaction(id, request), null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok(ApiResponse.success(null, null));
    }
}
