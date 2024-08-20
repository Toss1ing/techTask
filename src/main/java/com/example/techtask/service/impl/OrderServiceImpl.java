package com.example.techtask.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.techtask.model.Order;
import com.example.techtask.model.enumiration.UserStatus;
import com.example.techtask.repository.UserRepository;
import com.example.techtask.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;

    @Override
    public Order findOrder() {
        return userRepository.findAll().stream()
                .flatMap(user -> user.getOrders().stream())
                .filter(order -> order.getQuantity() > 1)
                .max(Comparator.comparing(Order::getCreatedAt))
                .orElseThrow(() -> new RuntimeException("Order without many item's"));
    }

    @Override
    public List<Order> findOrders() {
        return userRepository.findAll().stream()
                .filter(user -> user.getUserStatus() == UserStatus.ACTIVE)
                .flatMap(user -> user.getOrders().stream())
                .sorted(Comparator.comparing(Order::getCreatedAt))
                .collect(Collectors.toList());
    }

}
