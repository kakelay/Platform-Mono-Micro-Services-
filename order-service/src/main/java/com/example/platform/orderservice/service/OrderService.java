package com.example.platform.orderservice.service;

import com.example.platform.orderservice.dto.request.CreateOrderRequest;
import com.example.platform.orderservice.dto.request.UpdateOrderRequest;
import com.example.platform.orderservice.dto.response.OrderResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponse createOrder(CreateOrderRequest request);
    OrderResponse getOrder(UUID id);
    List<OrderResponse> listOrders();
    List<OrderResponse> listOrdersByCustomer(UUID customerId);
    List<OrderResponse> listOrdersByAccount(UUID accountId);
    OrderResponse updateOrder(UUID id, UpdateOrderRequest request);
    void deleteOrder(UUID id);
}
