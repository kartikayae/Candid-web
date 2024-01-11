package com.practice.candidpractice.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.practice.candidpractice.dao.ConfirmationTokenRepository;
import com.practice.candidpractice.entities.ConfirmationToken;
import com.practice.candidpractice.entities.User;
import com.practice.candidpractice.enums.TokenType;
import com.practice.candidpractice.service.ConfirmationTokenService;

public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
    @Autowired
    private ConfirmationTokenRepository tokenRepository;

    public ConfirmationToken generateToken(User user, TokenType tokenType) {
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                tokenType,
                user);

        tokenRepository.save(confirmationToken);

        return confirmationToken;
    }

    @Transactional
    public String confirmToken(String token) throws Exception {
        ConfirmationToken confirmationToken = tokenRepository.findByToken(token);
        if (confirmationToken == null)
            throw new Exception("Token does not exists!");

        if (confirmationToken.getConfirmedAt() != null)
            throw new Exception("User already verified!");

        if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now()))
            throw new Exception("Token Expired!");
        else
            confirmationToken.setConfirmedAt(LocalDateTime.now());

        return "confirmed";
    }
}
