package com.example.techtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.techtask.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
