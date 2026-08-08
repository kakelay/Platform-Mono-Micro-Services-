package com.example.platform.orderservice.controller;

import com.example.platform.common.model.ApiResponse;
import com.example.platform.orderservice.dto.request.CreateOrderRequest;
import com.example.platform.orderservice.dto.request.UpdateOrderRequest;
import com.example.platform.orderservice.dto.response.OrderResponse;
import com.example.platform.orderservice.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponse>> create(@Valid @RequestBody CreateOrderRequest request) {
        return ResponseEntity.ok(ApiResponse.success(orderService.createOrder(request), null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(orderService.getOrder(id), null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderResponse>>> list(@RequestParam(required = false) UUID customerId,
                                                                  @RequestParam(required = false) UUID accountId) {
        return ResponseEntity.ok(ApiResponse.success(
                customerId != null ? orderService.listOrdersByCustomer(customerId) :
                accountId != null ? orderService.listOrdersByAccount(accountId) :
                orderService.listOrders(), null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderResponse>> update(@PathVariable UUID id, @Valid @RequestBody UpdateOrderRequest request) {
        return ResponseEntity.ok(ApiResponse.success(orderService.updateOrder(id, request), null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable UUID id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok(ApiResponse.success(null, null));
    }
}
