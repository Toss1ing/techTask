package com.example.techtask.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.techtask.model.User;
import com.example.techtask.service.impl.UserServiceImpl;

import lombok.RequiredArgsConstructor;

/**
 * Attention! Only DI and service interaction applicable in this class. Each
 * controller method
 * should only contain a call to the corresponding service method
 */
@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserServiceImpl userServiceImpl;

  @GetMapping("desired-user/{id}")
  public User findUser() {
    return userServiceImpl.findUser();
  }

  @GetMapping("desired-users")
  public List<User> findUsers() {
    return userServiceImpl.findUsers();
  }
}
