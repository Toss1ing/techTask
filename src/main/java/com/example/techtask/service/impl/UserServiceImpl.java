package com.example.techtask.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.techtask.model.User;
import com.example.techtask.model.enumiration.OrderStatus;
import com.example.techtask.repository.UserRepository;
import com.example.techtask.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUser() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .max(Comparator.comparing(this::calculateProductSumIn2003))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private double calculateProductSumIn2003(User user) {
        return user.getOrders().stream()
                .filter(order -> order.getCreatedAt().getYear() == 2003)
                .mapToDouble(order -> order.getQuantity() * order.getPrice())
                .sum();

    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll().stream()
                .filter(user -> user.getOrders().stream()
                        .anyMatch(order -> order.getCreatedAt().getYear() == 2010
                                && order.getOrderStatus() == OrderStatus.PAID))
                .collect(Collectors.toList());
    }

}
