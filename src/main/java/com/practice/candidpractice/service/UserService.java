package com.practice.candidpractice.service;

import org.springframework.stereotype.Service;

import com.practice.candidpractice.entities.User;

@Service
public interface UserService {
    public User registerUser(User user) throws Exception;
}