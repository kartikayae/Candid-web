package com.practice.candidpractice.service;

import org.springframework.stereotype.Service;

import com.practice.candidpractice.entities.ConfirmationToken;
import com.practice.candidpractice.entities.User;
import com.practice.candidpractice.enums.TokenType;

@Service
public interface ConfirmationTokenService {

    ConfirmationToken generateToken(User user, TokenType tokenType);

}