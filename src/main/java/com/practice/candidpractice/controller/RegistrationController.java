package com.practice.candidpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.candidpractice.entities.User;
import com.practice.candidpractice.enums.TokenType;
import com.practice.candidpractice.service.ConfirmationTokenService;
import com.practice.candidpractice.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/auth")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ConfirmationTokenService tokenService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid User user) {
        try {
            this.userService.registerUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/verify")
    public void verify(@PathVariable(value = "token") String token) {

    }
}