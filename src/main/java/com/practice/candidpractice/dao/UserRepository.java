package com.practice.candidpractice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.candidpractice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Boolean existsByEmail(String email);

    User findByEmail(String email);
}