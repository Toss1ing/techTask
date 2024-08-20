package com.example.techtask.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techtask.model.Order;
import com.example.techtask.service.impl.OrderServiceImpl;

import lombok.RequiredArgsConstructor;

/**
 * Attention! Only DI and service interaction applicable in this class. Each
 * controller method
 * should only contain a call to the corresponding service method
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {

  private final OrderServiceImpl orderServiceImpl;

  @GetMapping("desired-order/{id}")
  public Order findOrder() {
    return orderServiceImpl.findOrder();
  }

  @GetMapping("desired-orders")
  public List<Order> findOrders() {
    return orderServiceImpl.findOrders();
  }
}
