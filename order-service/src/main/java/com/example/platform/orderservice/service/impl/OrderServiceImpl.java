package com.example.platform.orderservice.service.impl;

import com.example.platform.common.exception.BusinessException;
import com.example.platform.orderservice.dto.request.CreateOrderRequest;
import com.example.platform.orderservice.dto.request.UpdateOrderRequest;
import com.example.platform.orderservice.dto.response.OrderResponse;
import com.example.platform.orderservice.entity.OrderEntity;
import com.example.platform.orderservice.repository.OrderRepository;
import com.example.platform.orderservice.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public OrderResponse createOrder(CreateOrderRequest request) {
        var order = new OrderEntity();
        order.setId(UUID.randomUUID());
        order.setCustomerId(request.getCustomerId());
        order.setAccountId(request.getAccountId());
        order.setTotalAmount(request.getTotalAmount());
        order.setCurrency(request.getCurrency());
        order.setStatus(request.getStatus());
        order.setDescription(request.getDescription());
        order.setCreatedAt(LocalDateTime.now());
        return toResponse(repository.save(order));
    }

    @Override
    public OrderResponse getOrder(UUID id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new BusinessException("ORDER_NOT_FOUND", "Order not found"));
    }

    @Override
    public List<OrderResponse> listOrders() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public List<OrderResponse> listOrdersByCustomer(UUID customerId) {
        return repository.findByCustomerId(customerId).stream().map(this::toResponse).toList();
    }

    @Override
    public List<OrderResponse> listOrdersByAccount(UUID accountId) {
        return repository.findByAccountId(accountId).stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional
    public OrderResponse updateOrder(UUID id, UpdateOrderRequest request) {
        var order = repository.findById(id)
                .orElseThrow(() -> new BusinessException("ORDER_NOT_FOUND", "Order not found"));
        order.setStatus(request.getStatus());
        return toResponse(repository.save(order));
    }

    @Override
    @Transactional
    public void deleteOrder(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("ORDER_NOT_FOUND", "Order not found");
        }
        repository.deleteById(id);
    }

    private OrderResponse toResponse(OrderEntity entity) {
        return new OrderResponse(entity.getId(), entity.getCustomerId(), entity.getAccountId(), entity.getTotalAmount(), entity.getCurrency(), entity.getStatus(), entity.getCreatedAt(), entity.getDescription());
    }
}
