package com.practice.candidpractice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.candidpractice.dao.UserRepository;
import com.practice.candidpractice.entities.User;
import com.practice.candidpractice.enums.TokenType;
import com.practice.candidpractice.service.ConfirmationTokenService;
import com.practice.candidpractice.service.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfirmationTokenService tokenService;

    @Override
    public User registerUser(User user) throws Exception {
        // Check if user already exists i.e, with the same email
        if (this.userRepository.existsByEmail(user.getEmail().trim().toLowerCase()) == true)
            throw new Exception("Email already in use!!");

        // Save new user
        this.userRepository.save(user);

        // Generate and save token
        String token = tokenService.generateToken(user, TokenType.ACCOUNT_VERIFICATION).toString();

        return user;
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    public void enableUser() {

    }

    public String getVerificationURL(String token, String type) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path(type + "?code=" + token).toUriString();
    }
}