package com.practice.candidpractice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.practice.candidpractice.entities.ConfirmationToken;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {

    ConfirmationToken findByToken(String token);

}